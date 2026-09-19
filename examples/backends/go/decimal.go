package main

import (
	"math/big"
	"regexp"
	"strings"
)

// Exact decimal arithmetic on decimal *strings*.
//
// The Meteroid Go SDK types every `format: decimal` value as a string, because a
// float64 cannot hold one losslessly — and, depending on the standard library only, it
// ships no arithmetic for them. The quota check has to subtract and compare those
// values, so this does it on big.Int scaled integers. Nothing in this backend ever
// passes a decimal through strconv.ParseFloat: that is how a 0.1-minute clip eventually
// bills wrong.

var decimalPattern = regexp.MustCompile(`^-?\d+(\.\d+)?$`)

// decimal is units × 10^-scale.
type decimal struct {
	units *big.Int
	scale int
}

// parseDecimal only ever sees values that came from Meteroid, so a malformed one is an
// upstream problem rather than a bug here or a bad request.
func parseDecimal(value string) (decimal, error) {
	if !decimalPattern.MatchString(value) {
		return decimal{}, newAPIError(codeUpstreamError,
			"Meteroid returned %q where an exact decimal was expected.", value)
	}
	whole, fraction, _ := strings.Cut(value, ".")
	// The pattern has already vouched for every digit, so SetString cannot fail.
	units, _ := new(big.Int).SetString(whole+fraction, 10)
	return decimal{units: units, scale: len(fraction)}, nil
}

// align lifts both operands to the larger of the two scales.
func align(a, b decimal) (x, y *big.Int, scale int) {
	scale = max(a.scale, b.scale)
	lift := func(d decimal) *big.Int {
		factor := new(big.Int).Exp(big.NewInt(10), big.NewInt(int64(scale-d.scale)), nil)
		return factor.Mul(factor, d.units)
	}
	return lift(a), lift(b), scale
}

// String renders the way the contract's `Decimal` wants: trailing zeros trimmed, never
// scientific notation, and no negative zero.
func (d decimal) String() string {
	digits := new(big.Int).Abs(d.units).String()
	if len(digits) <= d.scale {
		digits = strings.Repeat("0", d.scale-len(digits)+1) + digits
	}
	whole := digits[:len(digits)-d.scale]
	fraction := strings.TrimRight(digits[len(digits)-d.scale:], "0")

	var b strings.Builder
	if d.units.Sign() < 0 {
		b.WriteByte('-')
	}
	b.WriteString(whole)
	if fraction != "" {
		b.WriteByte('.')
		b.WriteString(fraction)
	}
	return b.String()
}

// normalizeDecimal renders a Meteroid decimal the way the contract requires:
// "3.50" becomes "3.5".
func normalizeDecimal(value string) (string, error) {
	d, err := parseDecimal(value)
	if err != nil {
		return "", err
	}
	return d.String(), nil
}

func normalizeDecimalOpt(value *string) (*string, error) {
	if value == nil {
		return nil, nil
	}
	normalized, err := normalizeDecimal(*value)
	if err != nil {
		return nil, err
	}
	return &normalized, nil
}

func addDecimal(a, b string) (string, error) {
	return combine(a, b, (*big.Int).Add)
}

func subtractDecimal(a, b string) (string, error) {
	return combine(a, b, (*big.Int).Sub)
}

func combine(a, b string, op func(z, x, y *big.Int) *big.Int) (string, error) {
	left, err := parseDecimal(a)
	if err != nil {
		return "", err
	}
	right, err := parseDecimal(b)
	if err != nil {
		return "", err
	}
	x, y, scale := align(left, right)
	return decimal{units: op(new(big.Int), x, y), scale: scale}.String(), nil
}

// decimalGreaterThan is numeric, not textual: "1" and "1.00" are the same balance.
func decimalGreaterThan(a, b string) (bool, error) {
	left, err := parseDecimal(a)
	if err != nil {
		return false, err
	}
	right, err := parseDecimal(b)
	if err != nil {
		return false, err
	}
	x, y, _ := align(left, right)
	return x.Cmp(y) > 0, nil
}

// billableMinutes is durationSeconds / 60, rounded **up** to two decimals — the demo
// always bills at least what it used. Integer ceiling division, so 100 / 60 is exactly
// "1.67".
func billableMinutes(durationSeconds int32) string {
	hundredths := (int64(durationSeconds)*100 + 59) / 60
	return decimal{units: big.NewInt(hundredths), scale: 2}.String()
}
