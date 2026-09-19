"""Model (de)serialization tests, mirroring rust/tests/it/model_serialization.rs."""

import dataclasses
import datetime
import pathlib
import re
import typing as t

import pytest

from meteroid.models import (
    Currency,
    Customer,
    CustomerCreateRequest,
    CustomerListResponse,
    Fee,
    InvoiceStatus,
    PaginationResponse,
    RatePlanFee,
)
from meteroid.serialization import BaseModel, ModelParseError, TaggedUnionModel


def test_currency_serialization() -> None:
    assert Currency.USD.value == "USD"
    assert Currency("EUR") is Currency.EUR
    assert str(Currency.JPY) == "JPY"


def test_invoice_status_serialization() -> None:
    assert InvoiceStatus.DRAFT.value == "DRAFT"
    assert InvoiceStatus("FINALIZED") is InvoiceStatus.FINALIZED
    assert InvoiceStatus("VOID") is InvoiceStatus.VOID


def test_customer_list_response() -> None:
    response = CustomerListResponse.from_json(
        """{
            "data": [],
            "pagination_meta": {
                "page": 0, "per_page": 10, "total_items": 0, "total_pages": 0
            }
        }"""
    )
    assert response.data == []
    assert response.pagination_meta.total_items == 0


def test_customer_list_response_with_data() -> None:
    response = CustomerListResponse.from_dict(
        {
            "data": [
                {
                    "id": "cust_123",
                    "name": "Test Customer",
                    "currency": "USD",
                    "custom_properties": {},
                    "preferred_locales": [],
                    "custom_taxes": [],
                    "invoicing_emails": [],
                    "invoicing_entity_id": "inv_entity_1",
                }
            ],
            "pagination_meta": {
                "page": 0,
                "per_page": 10,
                "total_items": 1,
                "total_pages": 1,
            },
        }
    )
    assert response == CustomerListResponse(
        data=[
            Customer(
                id="cust_123",
                name="Test Customer",
                currency=Currency.USD,
                custom_properties={},
                preferred_locales=[],
                custom_taxes=[],
                invoicing_emails=[],
                invoicing_entity_id="inv_entity_1",
            )
        ],
        pagination_meta=PaginationResponse(
            page=0, per_page=10, total_items=1, total_pages=1
        ),
    )


def test_customer_create_request_serialization() -> None:
    request = CustomerCreateRequest(
        currency=Currency.USD,
        custom_taxes=[],
        invoicing_emails=["billing@example.com"],
        name="Acme Corp",
    )
    payload = request.to_dict()

    assert payload["name"] == "Acme Corp"
    assert payload["currency"] == "USD"
    assert payload["invoicing_emails"] == ["billing@example.com"]

    # Optional fields must not appear when unset.
    assert "alias" not in payload
    assert "billing_email" not in payload


def test_customer_create_request_with_optional_fields() -> None:
    request = CustomerCreateRequest(
        currency=Currency.EUR,
        custom_taxes=[],
        invoicing_emails=[],
        name="Test Company",
        alias="test-alias",
        billing_email="billing@test.com",
    )
    payload = request.to_dict()

    assert payload["alias"] == "test-alias"
    assert payload["billing_email"] == "billing@test.com"


def test_customer_round_trip() -> None:
    original = Customer(
        id="cust_123",
        name="Test Customer",
        currency=Currency.USD,
        custom_properties={"tier": "gold"},
        preferred_locales=["fr-FR", "en"],
        custom_taxes=[],
        invoicing_emails=["a@example.com"],
        invoicing_entity_id="inv_1",
        alias="acme",
    )
    assert Customer.from_dict(original.to_dict()) == original


def test_fee_tagged_union_serialization() -> None:
    rate_fee = Fee(type="RATE", content=RatePlanFee(rates=[]))
    payload = rate_fee.to_dict()

    assert payload["type"] == "RATE"
    # Internally tagged: the variant's own fields sit next to the discriminator.
    assert payload["rates"] == []


def test_fee_tagged_union_deserialization() -> None:
    fee = Fee.from_json('{"type": "RATE", "rates": []}')
    assert fee.type == "RATE"
    assert isinstance(fee.content, RatePlanFee)
    assert fee.content.rates == []


def test_fee_tagged_union_unknown_variant() -> None:
    with pytest.raises(ModelParseError):
        Fee.from_dict({"type": "NOPE"})


def test_unknown_fields_are_ignored() -> None:
    response = CustomerListResponse.from_dict(
        {
            "data": [],
            "pagination_meta": {
                "page": 0,
                "per_page": 10,
                "total_items": 0,
                "total_pages": 0,
            },
            "unknown_field": "should be ignored",
        }
    )
    assert response.data == []


def test_optional_fields_deserialize_as_none() -> None:
    customer = Customer.from_dict(
        {
            "id": "cust_123",
            "name": "Test",
            "currency": "USD",
            "custom_properties": {},
            "preferred_locales": [],
            "custom_taxes": [],
            "invoicing_emails": [],
            "invoicing_entity_id": "inv_1",
        }
    )
    assert customer.alias is None
    assert customer.billing_email is None
    assert customer.phone is None


def test_optional_fields_deserialize_as_some() -> None:
    customer = Customer.from_dict(
        {
            "id": "cust_123",
            "name": "Test",
            "currency": "USD",
            "custom_properties": {},
            "preferred_locales": [],
            "custom_taxes": [],
            "invoicing_emails": [],
            "invoicing_entity_id": "inv_1",
            "alias": "my-alias",
            "billing_email": "billing@example.com",
        }
    )
    assert customer.alias == "my-alias"
    assert customer.billing_email == "billing@example.com"


def test_missing_required_field_raises() -> None:
    with pytest.raises(ModelParseError):
        Customer.from_dict({"id": "cust_123"})


def test_datetime_and_decimal_round_trip() -> None:
    from decimal import Decimal

    from meteroid.models import AppliedCoupon

    payload = {
        "id": "ac_1",
        "coupon_id": "c_1",
        "is_active": True,
        "created_at": "2024-01-15T10:30:00Z",
        "applied_amount": "12.34",
    }
    applied = AppliedCoupon.from_dict(payload)
    assert applied.created_at == datetime.datetime(
        2024, 1, 15, 10, 30, tzinfo=datetime.timezone.utc
    )
    assert applied.applied_amount == Decimal("12.34")

    out = applied.to_dict()
    assert out["applied_amount"] == "12.34"
    assert out["created_at"].startswith("2024-01-15T10:30:00")


def test_flattened_field_is_inlined() -> None:
    from meteroid.models import CouponEvent

    payload = {
        "id": "evt_1",
        "type": "coupon.created",
        "timestamp": "2024-01-15T10:30:00Z",
        # CouponEventData fields sit at the top level.
        "coupon_id": "c_1",
        "code": "SUMMER",
        "created_at": "2024-01-15T10:30:00Z",
        "description": "Summer sale",
        "disabled": False,
        "discount": {"type": "PERCENTAGE", "percentage": "10"},
        "reusable": False,
    }
    event = CouponEvent.from_dict(payload)
    assert event.coupon_event_data.code == "SUMMER"

    out = event.to_dict()
    assert out["code"] == "SUMMER"
    assert "coupon_event_data" not in out


# ---------------------------------------------------------------------------
# The Meteroid spec only produces internally tagged unions today; the
# adjacently tagged code path in `TaggedUnionModel` is covered here so the
# runtime stays correct if the spec ever grows one.
# ---------------------------------------------------------------------------


@dataclasses.dataclass
class _Payload(BaseModel):
    value: str


@dataclasses.dataclass
class _Adjacent(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "kind"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "kind"
    _CONTENT_ATTR: t.ClassVar[str] = "data"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = "data"
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {"A": _Payload}

    kind: t.Literal["A"]
    data: _Payload


def test_adjacently_tagged_round_trip() -> None:
    value = _Adjacent(kind="A", data=_Payload(value="x"))
    assert value.to_dict() == {"kind": "A", "data": {"value": "x"}}
    assert _Adjacent.from_dict({"kind": "A", "data": {"value": "x"}}) == value


# ---------------------------------------------------------------------------
# Fields whose spec name is a Python keyword are exposed under a trailing
# underscore (`class` -> `class_`), so `_JSON_KEYS` has to be keyed by that
# attribute name and not by a bare snake_case of the spec name. No such field
# exists in the current OpenAPI document, so the shape the template emits is
# reproduced here by hand.
# ---------------------------------------------------------------------------


@dataclasses.dataclass
class _KeywordFields(BaseModel):
    _JSON_KEYS: t.ClassVar[t.Mapping[str, str]] = {
        "class_": "class",
        "from_": "from",
        "import_": "import",
        "not_a_keyword": "notAKeyword",
    }

    class_: str
    from_: t.Optional[str] = None
    import_: t.Optional[str] = None
    not_a_keyword: t.Optional[str] = None


def test_keyword_named_fields_round_trip_under_their_wire_key() -> None:
    payload = {
        "class": "premium",
        "from": "2024-01-01",
        "import": "batch_1",
        "notAKeyword": "plain",
    }

    parsed = _KeywordFields.from_dict(payload)
    assert parsed.class_ == "premium"
    assert parsed.from_ == "2024-01-01"
    assert parsed.import_ == "batch_1"
    assert parsed.not_a_keyword == "plain"

    out = parsed.to_dict()
    assert out == payload
    # The trailing-underscore attribute names must never reach the wire.
    assert not any(key.endswith("_") for key in out)


def test_keyword_named_required_field_is_reported_by_wire_key() -> None:
    with pytest.raises(ModelParseError, match="missing required field 'class'"):
        _KeywordFields.from_dict({})


_STRUCT_TEMPLATE = (
    pathlib.Path(__file__).resolve().parents[2]
    / "codegen"
    / "templates"
    / "python"
    / "types"
    / "struct.py.jinja"
)


@pytest.mark.skipif(
    not _STRUCT_TEMPLATE.is_file(),
    reason="codegen templates are not shipped with the distribution",
)
def test_json_keys_template_is_keyed_by_the_attribute_name() -> None:
    """Guard the generator behind `test_keyword_named_fields_round_trip...`.

    The models above are generated, so the round-trip test only proves the
    runtime is correct. This pins the template that builds `_JSON_KEYS` to
    `py_ident(...)` -- the same helper that names the dataclass attribute --
    rather than a bare `to_snake_case`, which would drop the trailing
    underscore and silently serialize keyword fields under the wrong key.
    """
    source = _STRUCT_TEMPLATE.read_text()
    block = source.partition("{% set json_keys %}")[2].partition("{% endset %}")[0]
    assert block, "could not locate the `json_keys` block in struct.py.jinja"
    # Jinja comments explain the rule; only the code has to obey it.
    code = re.sub(r"\{#-?.*?-?#\}", "", block, flags=re.DOTALL)
    assert "py_ident(" in code
    assert "to_snake_case" not in code


def test_offset_less_datetime_is_utc() -> None:
    from meteroid.serialization import parse_datetime

    naive = parse_datetime("2026-09-19T10:00:00.123456")
    assert naive.tzinfo is not None
    assert naive.utcoffset() == datetime.timedelta(0)
    # Microseconds are kept.
    assert naive == datetime.datetime(
        2026, 9, 19, 10, 0, 0, 123456, tzinfo=datetime.timezone.utc
    )

    zulu = parse_datetime("2026-09-19T10:00:00.123Z")
    assert zulu == datetime.datetime(
        2026, 9, 19, 10, 0, 0, 123000, tzinfo=datetime.timezone.utc
    )
    # Offset-less and `Z` values can be compared and sorted together.
    assert zulu < naive

    paris = parse_datetime("2026-09-19T12:00:00+02:00")
    assert paris.utcoffset() == datetime.timedelta(hours=2)
    assert paris == datetime.datetime(2026, 9, 19, 10, 0, tzinfo=datetime.timezone.utc)

    # Naive datetimes handed in directly are treated as UTC too.
    assert parse_datetime(datetime.datetime(2026, 9, 19, 10)).tzinfo is not None


def test_model_with_offset_less_datetime() -> None:
    from meteroid.models import AppliedCoupon

    applied = AppliedCoupon.from_dict(
        {
            "id": "ac_1",
            "coupon_id": "c_1",
            "is_active": True,
            "created_at": "2026-09-19T10:00:00.123456",
            "applied_amount": "1",
        }
    )
    assert applied.created_at == datetime.datetime(
        2026, 9, 19, 10, 0, 0, 123456, tzinfo=datetime.timezone.utc
    )
    assert applied.to_dict()["created_at"] == "2026-09-19T10:00:00.123456+00:00"


# --------------------------------------------------------------------------
# Decimals
# --------------------------------------------------------------------------

_APPLIED_COUPON = {
    "id": "ac_1",
    "coupon_id": "c_1",
    "is_active": True,
    "created_at": "2024-01-15T10:30:00Z",
}


@pytest.mark.parametrize(
    ("raw", "expected"),
    [
        ("12.34", "12.34"),
        ("-0.5", "-0.5"),
        ("1e3", "1E+3"),
        ("1.5E-2", "0.015"),
    ],
)
def test_decimal_strings_are_parsed(raw: str, expected: str) -> None:
    from decimal import Decimal

    from meteroid.models import AppliedCoupon

    applied = AppliedCoupon.from_dict({**_APPLIED_COUPON, "applied_amount": raw})
    assert applied.applied_amount == Decimal(expected)


@pytest.mark.parametrize(
    "raw",
    ["NaN", "nan", "sNaN", "-NaN", "Infinity", "-Infinity", "inf", "-inf"],
)
def test_non_finite_decimal_strings_are_rejected(raw: str) -> None:
    from meteroid.models import AppliedCoupon

    with pytest.raises(ModelParseError, match="AppliedCoupon.applied_amount"):
        AppliedCoupon.from_dict({**_APPLIED_COUPON, "applied_amount": raw})


@pytest.mark.parametrize("raw", [12.34, 12, True, None, ["1"], {"v": "1"}, "", "abc"])
def test_decimal_fields_require_a_decimal_string(raw: object) -> None:
    from meteroid.models import CapacityFee

    valid = {"overage_rate": "1", "rate": "1", "included": 10, "metric_id": "m"}
    assert CapacityFee.from_dict(valid).overage_rate == 1
    with pytest.raises(ModelParseError, match="CapacityFee.overage_rate"):
        CapacityFee.from_dict({**valid, "overage_rate": raw})


def test_plain_string_fields_are_not_decimal_checked() -> None:
    from meteroid.models import CustomTaxRate

    # `CustomTaxRate.rate` is a plain `type: string` in the spec.
    rate = CustomTaxRate.from_dict({"name": "vat", "rate": "NaN", "tax_code": "x"})
    assert rate.rate == "NaN"


@pytest.mark.parametrize("bad", ["NaN", "sNaN", "Infinity", "-Infinity"])
def test_non_finite_decimals_are_never_serialized(bad: str) -> None:
    from decimal import Decimal

    from meteroid.api.common import serialize_query_params
    from meteroid.models import AppliedCoupon
    from meteroid.serialization import to_json_value

    applied = AppliedCoupon.from_dict(_APPLIED_COUPON)
    applied.applied_amount = Decimal(bad)
    with pytest.raises(ValueError, match="non-finite decimal"):
        applied.to_dict()
    with pytest.raises(ValueError, match="non-finite decimal"):
        to_json_value([Decimal(bad)])
    with pytest.raises(ValueError, match="non-finite decimal"):
        serialize_query_params({"amount": Decimal(bad)})


@pytest.mark.parametrize(
    ("fraction", "micros"),
    [
        ("", 0),
        (".1", 100000),
        (".123", 123000),
        (".123456", 123456),
        (".1234567", 123456),
        (".123456789", 123456),
        (".000000999", 0),
    ],
)
@pytest.mark.parametrize(
    ("suffix", "offset"),
    [
        ("", datetime.timedelta(0)),
        ("Z", datetime.timedelta(0)),
        ("z", datetime.timedelta(0)),
        ("+00:00", datetime.timedelta(0)),
        ("+02:00", datetime.timedelta(hours=2)),
        ("-05:30", -datetime.timedelta(hours=5, minutes=30)),
    ],
)
def test_parse_datetime_fractional_seconds(
    fraction: str, micros: int, suffix: str, offset: datetime.timedelta
) -> None:
    from meteroid.serialization import parse_datetime

    parsed = parse_datetime(f"2026-09-19T10:00:00{fraction}{suffix}")
    assert parsed.tzinfo is not None
    assert parsed.utcoffset() == offset
    assert parsed.replace(tzinfo=None) == datetime.datetime(2026, 9, 19, 10, 0, 0, micros)


@pytest.mark.parametrize(
    "raw",
    ["2026-09-19T10:00:00.", "2026-09-19T10:00:00.12a", "not a date", "2026-13-01"],
)
def test_parse_datetime_rejects_garbage(raw: str) -> None:
    from meteroid.serialization import parse_datetime

    with pytest.raises(ModelParseError):
        parse_datetime(raw)


def test_model_with_nanosecond_datetime() -> None:
    from meteroid.models import AppliedCoupon

    applied = AppliedCoupon.from_dict(
        {
            "id": "ac_1",
            "coupon_id": "c_1",
            "is_active": True,
            "created_at": "2026-09-19T10:00:00.123456789Z",
        }
    )
    assert applied.created_at == datetime.datetime(
        2026, 9, 19, 10, 0, 0, 123456, tzinfo=datetime.timezone.utc
    )


# --------------------------------------------------------------------------
# Any-JSON fields
# --------------------------------------------------------------------------


@pytest.mark.parametrize(
    "value",
    [{"tier": "gold", "limits": [1, 2]}, [1, "two", None], "text", 42, 1.5, True, None],
)
def test_json_config_value_round_trips_any_json(value: t.Any) -> None:
    import json

    from meteroid.models import ConfigValue, JsonConfigValue

    parsed = JsonConfigValue.from_dict({"value": value})
    assert parsed.value == value
    assert parsed.to_dict() == {"value": value}
    assert JsonConfigValue.from_json(parsed.to_json()) == parsed

    # Through the tagged union, as `get_effective_entitlements` returns it.
    wire = {"kind": "JSON", "value": value}
    config = ConfigValue.from_dict(json.loads(json.dumps(wire)))
    assert isinstance(config.content, JsonConfigValue)
    assert config.content.value == value
    assert config.to_dict() == wire


def test_optional_any_json_field_none_is_omitted() -> None:
    from meteroid.models import CustomerPatchRequest

    assert "custom_properties" not in CustomerPatchRequest().to_dict()
    patched = CustomerPatchRequest(custom_properties={"plan": "gold"})
    assert patched.to_dict()["custom_properties"] == {"plan": "gold"}
