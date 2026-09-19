package meteroid

import (
	"encoding/json"
	"reflect"
	"testing"
	"time"
)

// Optional fields must disappear from the payload when they are nil, and
// required fields must always be present.
func TestCustomerJSONRoundTrip(t *testing.T) {
	const payload = `{
		"id": "cust_123",
		"name": "Test Customer",
		"currency": "USD",
		"alias": "acme",
		"billing_address": {"city": "Paris", "country": "FR"},
		"custom_properties": {"tier":"gold"},
		"preferred_locales": ["fr-FR", "en"],
		"custom_taxes": [],
		"invoicing_emails": ["billing@acme.test"],
		"invoicing_entity_id": "inv_1"
	}`

	var customer Customer
	if err := json.Unmarshal([]byte(payload), &customer); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}

	if customer.Id != "cust_123" || customer.Name != "Test Customer" {
		t.Fatalf("unexpected identity: %+v", customer)
	}
	if customer.Currency != CurrencyUsd {
		t.Errorf("currency = %q, want %q", customer.Currency, CurrencyUsd)
	}
	if customer.Alias == nil || *customer.Alias != "acme" {
		t.Errorf("alias = %v, want %q", customer.Alias, "acme")
	}
	if customer.BillingAddress == nil || customer.BillingAddress.City == nil || *customer.BillingAddress.City != "Paris" {
		t.Errorf("billing address not decoded: %+v", customer.BillingAddress)
	}
	if customer.Phone != nil {
		t.Errorf("phone = %v, want nil for an absent field", customer.Phone)
	}
	var props map[string]string
	if err := json.Unmarshal(customer.CustomProperties, &props); err != nil || props["tier"] != "gold" {
		t.Errorf("custom_properties = %s (%v), want tier=gold", customer.CustomProperties, err)
	}

	encoded, err := json.Marshal(customer)
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}

	var fields map[string]any
	if err := json.Unmarshal(encoded, &fields); err != nil {
		t.Fatalf("re-unmarshal: %v", err)
	}
	if _, ok := fields["phone"]; ok {
		t.Errorf("absent optional field was serialized: %s", encoded)
	}
	if _, ok := fields["name"]; !ok {
		t.Errorf("required field missing from output: %s", encoded)
	}

	var again Customer
	if err := json.Unmarshal(encoded, &again); err != nil {
		t.Fatalf("second unmarshal: %v", err)
	}
	if !reflect.DeepEqual(customer, again) {
		t.Errorf("round trip changed the value:\n got %+v\nwant %+v", again, customer)
	}
}

// Timestamps are decoded as time.Time and re-encoded as RFC 3339.
func TestTimestampRoundTrip(t *testing.T) {
	const payload = `{
		"id": "addon_1",
		"name": "Extra seats",
		"created_at": "2024-05-01T12:30:00Z",
		"price_id": "price_1",
		"product_id": "prod_1",
		"self_serviceable": true
	}`

	var addOn AddOn
	if err := json.Unmarshal([]byte(payload), &addOn); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}
	if want := time.Date(2024, 5, 1, 12, 30, 0, 0, time.UTC); !addOn.CreatedAt.Equal(want) {
		t.Errorf("created_at = %v, want %v", addOn.CreatedAt, want)
	}
	if addOn.ArchivedAt != nil {
		t.Errorf("archived_at = %v, want nil", addOn.ArchivedAt)
	}

	encoded, err := json.Marshal(addOn)
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	var fields map[string]any
	if err := json.Unmarshal(encoded, &fields); err != nil {
		t.Fatalf("re-unmarshal: %v", err)
	}
	if got := fields["created_at"]; got != "2024-05-01T12:30:00Z" {
		t.Errorf("created_at re-encoded as %v", got)
	}
}

// A tagged union decodes into the matching variant, and re-encodes with the
// discriminator flattened back alongside the payload.
func TestTaggedUnionRoundTrip(t *testing.T) {
	const payload = `{"type":"RATE","rate":"42.00"}`

	var fee SubscriptionFee
	if err := json.Unmarshal([]byte(payload), &fee); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}
	if fee.Type != SubscriptionFeeRate {
		t.Fatalf("type = %q, want %q", fee.Type, SubscriptionFeeRate)
	}
	if fee.Rate == nil || fee.Rate.Rate != "42.00" {
		t.Fatalf("rate variant not decoded: %+v", fee.Rate)
	}
	if fee.OneTime != nil {
		t.Errorf("a second variant was populated: %+v", fee.OneTime)
	}

	encoded, err := json.Marshal(fee)
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	var fields map[string]any
	if err := json.Unmarshal(encoded, &fields); err != nil {
		t.Fatalf("re-unmarshal: %v", err)
	}
	if fields["type"] != "RATE" || fields["rate"] != "42.00" {
		t.Errorf("unexpected encoding: %s", encoded)
	}

	built := NewSubscriptionFeeRate(RateFee{Rate: "42.00"})
	rebuilt, err := json.Marshal(built)
	if err != nil {
		t.Fatalf("marshal constructed union: %v", err)
	}
	if string(rebuilt) != string(encoded) {
		t.Errorf("constructor produced %s, want %s", rebuilt, encoded)
	}
}

// A union nested inside a struct must decode through the parent's decoder.
func TestTaggedUnionNestedInStruct(t *testing.T) {
	const payload = `{"data":[{"type":"ONE_TIME","quantity":3,"rate":"10.00"}],"pagination_meta":{"page":0,"per_page":10,"total_items":1,"total_pages":1}}`

	var wrapper struct {
		Data           []SubscriptionFee  `json:"data"`
		PaginationMeta PaginationResponse `json:"pagination_meta"`
	}
	if err := json.Unmarshal([]byte(payload), &wrapper); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}
	if len(wrapper.Data) != 1 || wrapper.Data[0].OneTime == nil {
		t.Fatalf("nested union not decoded: %+v", wrapper.Data)
	}
	if wrapper.Data[0].OneTime.Quantity != 3 {
		t.Errorf("quantity = %d, want 3", wrapper.Data[0].OneTime.Quantity)
	}
}

// A variant this SDK version does not know about must survive a decode/encode
// cycle instead of being rejected or dropped. Every field and value is kept,
// but the bytes are not necessarily identical: encoding/json compacts the
// whitespace and escapes `<`, `>` and `&`.
func TestTaggedUnionUnknownVariantIsPreserved(t *testing.T) {
	const payload = `{"future_field":true,"type":"SOMETHING_NEW"}`

	var fee SubscriptionFee
	if err := json.Unmarshal([]byte(payload), &fee); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}
	if fee.Type != "SOMETHING_NEW" {
		t.Errorf("type = %q", fee.Type)
	}

	encoded, err := json.Marshal(fee)
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	if string(encoded) != payload {
		t.Errorf("unknown variant re-encoded as %s, want %s", encoded, payload)
	}

	// Pin the two ways re-encoding is allowed to differ from the input bytes,
	// so the doc comments on the generated unions stay honest.
	const spaced = `{ "type": "SOMETHING_NEW", "html": "<b>&x" }`
	if err := json.Unmarshal([]byte(spaced), &fee); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}
	encoded, err = json.Marshal(fee)
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	if string(encoded) == spaced {
		t.Errorf("re-encoding is byte-for-byte after all; update the doc comments: %s", encoded)
	}
	var before, after map[string]any
	if err := json.Unmarshal([]byte(spaced), &before); err != nil {
		t.Fatalf("unmarshal reference: %v", err)
	}
	if err := json.Unmarshal(encoded, &after); err != nil {
		t.Fatalf("re-unmarshal: %v", err)
	}
	if !reflect.DeepEqual(before, after) {
		t.Errorf("re-encoding changed the document:\n got %v\nwant %v", after, before)
	}
}

// Encoding a union with no variant set is a programming error and must be
// reported rather than silently producing a half-written object.
func TestTaggedUnionEmptyIsAnError(t *testing.T) {
	_, err := json.Marshal(SubscriptionFee{})
	if err == nil {
		t.Fatal("expected an error when marshalling an empty union")
	}

	_, err = json.Marshal(SubscriptionFee{Type: SubscriptionFeeRate})
	if err == nil {
		t.Fatal("expected an error when the variant payload is nil")
	}
}

func TestStringEnumIsKnown(t *testing.T) {
	if !CurrencyEur.IsKnown() {
		t.Error("EUR should be a known currency")
	}
	if Currency("XXX").IsKnown() {
		t.Error("XXX should not be a known currency")
	}
	if got := CurrencyEur.String(); got != "EUR" {
		t.Errorf("String() = %q, want EUR", got)
	}
}

func TestNullable(t *testing.T) {
	type patch struct {
		Name *Nullable[string] `json:"name,omitempty"`
	}

	cases := []struct {
		name  string
		value patch
		want  string
	}{
		{"absent", patch{}, `{}`},
		{"null", patch{Name: Null[string]()}, `{"name":null}`},
		{"set", patch{Name: Set("acme")}, `{"name":"acme"}`},
	}

	for _, tc := range cases {
		t.Run(tc.name, func(t *testing.T) {
			encoded, err := json.Marshal(tc.value)
			if err != nil {
				t.Fatalf("marshal: %v", err)
			}
			if string(encoded) != tc.want {
				t.Fatalf("marshal = %s, want %s", encoded, tc.want)
			}

			var decoded patch
			if err := json.Unmarshal(encoded, &decoded); err != nil {
				t.Fatalf("unmarshal: %v", err)
			}
			gotValue, gotOK := decoded.Name.Get()
			wantValue, wantOK := tc.value.Name.Get()
			if gotValue != wantValue || gotOK != wantOK {
				t.Fatalf("round trip = (%q, %v), want (%q, %v)", gotValue, gotOK, wantValue, wantOK)
			}
		})
	}
}

// The spec marks fields such as custom_taxes and invoicing_emails required and
// non-nullable, so a nil slice must go out as `[]`, never as `null`. The zero
// value of a request struct is the most common first call, and it has to be
// schema-valid without the caller knowing which collections are required.
func TestRequiredCollectionsMarshalEmptyWhenNil(t *testing.T) {
	encoded, err := json.Marshal(CustomerCreateRequest{
		Name:     Ptr("acme"),
		Currency: CurrencyEur,
	})
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	const want = `{"currency":"EUR","custom_taxes":[],"invoicing_emails":[],"name":"acme"}`
	if string(encoded) != want {
		t.Errorf("marshal = %s, want %s", encoded, want)
	}

	// The map counterpart: a required map field is `{}`, not `null`.
	encoded, err = json.Marshal(GroupedUsage{Value: "1"})
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	if string(encoded) != `{"dimensions":{},"value":"1"}` {
		t.Errorf("marshal = %s, want {\"dimensions\":{},\"value\":\"1\"}", encoded)
	}

	// A required any-JSON field left unset is `null`, which is itself a valid
	// "any JSON" value.
	encoded, err = json.Marshal(JsonConfigValue{})
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	if string(encoded) != `{"value":null}` {
		t.Errorf("marshal = %s, want {\"value\":null}", encoded)
	}
}

// Values the caller did set must reach the wire untouched, including an
// explicitly empty one.
func TestRequiredCollectionsKeepExplicitValues(t *testing.T) {
	req := CustomerCreateRequest{
		Name:            Ptr("acme"),
		Currency:        CurrencyEur,
		InvoicingEmails: []string{"billing@acme.test", "ap@acme.test"},
		CustomTaxes:     []CustomTaxRate{{Name: "VAT", Rate: "0.20"}},
	}

	encoded, err := json.Marshal(req)
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}

	var fields struct {
		CustomTaxes     []CustomTaxRate `json:"custom_taxes"`
		InvoicingEmails []string        `json:"invoicing_emails"`
	}
	if err := json.Unmarshal(encoded, &fields); err != nil {
		t.Fatalf("re-unmarshal: %v", err)
	}
	if !reflect.DeepEqual(fields.InvoicingEmails, []string(req.InvoicingEmails)) {
		t.Errorf("invoicing_emails = %v, want %v", fields.InvoicingEmails, req.InvoicingEmails)
	}
	if !reflect.DeepEqual(fields.CustomTaxes, []CustomTaxRate(req.CustomTaxes)) {
		t.Errorf("custom_taxes = %v, want %v", fields.CustomTaxes, req.CustomTaxes)
	}

	var decoded CustomerCreateRequest
	if err := json.Unmarshal(encoded, &decoded); err != nil {
		t.Fatalf("unmarshal: %v", err)
	}
	if !reflect.DeepEqual(decoded, req) {
		t.Errorf("round trip changed the value:\n got %+v\nwant %+v", decoded, req)
	}
}

// Optional collections keep the old behaviour: nil means absent, and absent
// fields stay out of the payload.
func TestOptionalCollectionsAreStillOmittedWhenNil(t *testing.T) {
	encoded, err := json.Marshal(CustomerPatchRequest{Alias: Ptr("acme")})
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}
	if string(encoded) != `{"alias":"acme"}` {
		t.Errorf("marshal = %s, want {\"alias\":\"acme\"}", encoded)
	}
}

// The nil-to-`[]` coercion lives on the field type rather than on a generated
// MarshalJSON precisely so that it survives the `flatten` embeds: a MarshalJSON
// promoted from CustomerEventData would take over CustomerEvent's encoding and
// drop id, timestamp and type.
func TestFlattenedEmbedKeepsOuterFields(t *testing.T) {
	encoded, err := json.Marshal(CustomerEvent{
		Id:   "evt_1",
		Type: EventTypeCustomerCreated,
		CustomerEventData: CustomerEventData{
			CustomerId: "cust_1",
			Name:       "acme",
			Currency:   "EUR",
		},
	})
	if err != nil {
		t.Fatalf("marshal: %v", err)
	}

	var fields map[string]any
	if err := json.Unmarshal(encoded, &fields); err != nil {
		t.Fatalf("re-unmarshal: %v", err)
	}
	for _, key := range []string{"id", "timestamp", "type", "customer_id", "name", "currency"} {
		if _, ok := fields[key]; !ok {
			t.Errorf("field %q missing from the embed's output: %s", key, encoded)
		}
	}
	if got, ok := fields["invoicing_emails"].([]any); !ok || len(got) != 0 {
		t.Errorf("invoicing_emails = %v, want []: %s", fields["invoicing_emails"], encoded)
	}
	// custom_properties is any-JSON (json.RawMessage): unset, it is `null`.
	if got, ok := fields["custom_properties"]; !ok || got != nil {
		t.Errorf("custom_properties = %v, want null: %s", got, encoded)
	}
}

// A JSON config value is "any JSON" in the spec: an object, an array, a scalar
// or null. Every one of them must decode, inside a full entitlements response,
// without failing the rest of the response, and must re-encode unchanged.
func TestJsonConfigValueAcceptsAnyJSON(t *testing.T) {
	values := []struct {
		name string
		json string
	}{
		{"object", `{"seats":5,"tier":"gold","nested":{"a":[1,2]}}`},
		{"array", `[1,"two",{"three":3}]`},
		{"string", `"premium"`},
		{"number", `12.5`},
		{"bool", `true`},
		{"null", `null`},
	}

	for _, tc := range values {
		t.Run(tc.name, func(t *testing.T) {
			payload := `{"data":[
				{"feature":{"id":"feat_1","name":"Seats","code":"seats"},
				 "value":{"type":"BOOLEAN","enabled":true}},
				{"feature":{"id":"feat_2","name":"Metadata","code":"meta"},
				 "value":{"type":"CONFIG","value":{"kind":"JSON","value":` + tc.json + `}}}
			]}`

			var resp EffectiveEntitlementListResponse
			if err := json.Unmarshal([]byte(payload), &resp); err != nil {
				t.Fatalf("unmarshal: %v", err)
			}
			if len(resp.Data) != 2 {
				t.Fatalf("got %d entitlements, want 2", len(resp.Data))
			}
			if resp.Data[0].Value.Boolean == nil {
				t.Fatalf("sibling entitlement not decoded: %+v", resp.Data[0].Value)
			}

			cfg := resp.Data[1].Value.Config
			if cfg == nil || cfg.Value.Json == nil {
				t.Fatalf("config value not decoded: %+v", resp.Data[1].Value)
			}
			if got := string(cfg.Value.Json.Value); got != tc.json {
				t.Errorf("value = %s, want %s", got, tc.json)
			}

			encoded, err := json.Marshal(resp)
			if err != nil {
				t.Fatalf("marshal: %v", err)
			}
			var got, want any
			if err := json.Unmarshal(encoded, &got); err != nil {
				t.Fatalf("re-unmarshal: %v", err)
			}
			if err := json.Unmarshal([]byte(payload), &want); err != nil {
				t.Fatalf("unmarshal payload: %v", err)
			}
			if !reflect.DeepEqual(got, want) {
				t.Errorf("round trip changed the document:\n got %s\nwant %s", encoded, payload)
			}
		})
	}
}
