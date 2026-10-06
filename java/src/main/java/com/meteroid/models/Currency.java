// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Values this version of the SDK does not know are kept, and sent back unchanged: {@link #value()}
 * is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on them.
 */
public final class Currency implements ToQueryParam {
    /** The value {@code "AED"}. */
    public static final Currency AED = new Currency("AED", Value.AED);

    /** The value {@code "AFN"}. */
    public static final Currency AFN = new Currency("AFN", Value.AFN);

    /** The value {@code "ALL"}. */
    public static final Currency ALL = new Currency("ALL", Value.ALL);

    /** The value {@code "AMD"}. */
    public static final Currency AMD = new Currency("AMD", Value.AMD);

    /** The value {@code "ANG"}. */
    public static final Currency ANG = new Currency("ANG", Value.ANG);

    /** The value {@code "AOA"}. */
    public static final Currency AOA = new Currency("AOA", Value.AOA);

    /** The value {@code "ARS"}. */
    public static final Currency ARS = new Currency("ARS", Value.ARS);

    /** The value {@code "AUD"}. */
    public static final Currency AUD = new Currency("AUD", Value.AUD);

    /** The value {@code "AWG"}. */
    public static final Currency AWG = new Currency("AWG", Value.AWG);

    /** The value {@code "AZN"}. */
    public static final Currency AZN = new Currency("AZN", Value.AZN);

    /** The value {@code "BAM"}. */
    public static final Currency BAM = new Currency("BAM", Value.BAM);

    /** The value {@code "BBD"}. */
    public static final Currency BBD = new Currency("BBD", Value.BBD);

    /** The value {@code "BDT"}. */
    public static final Currency BDT = new Currency("BDT", Value.BDT);

    /** The value {@code "BGN"}. */
    public static final Currency BGN = new Currency("BGN", Value.BGN);

    /** The value {@code "BHD"}. */
    public static final Currency BHD = new Currency("BHD", Value.BHD);

    /** The value {@code "BIF"}. */
    public static final Currency BIF = new Currency("BIF", Value.BIF);

    /** The value {@code "BMD"}. */
    public static final Currency BMD = new Currency("BMD", Value.BMD);

    /** The value {@code "BND"}. */
    public static final Currency BND = new Currency("BND", Value.BND);

    /** The value {@code "BOB"}. */
    public static final Currency BOB = new Currency("BOB", Value.BOB);

    /** The value {@code "BRL"}. */
    public static final Currency BRL = new Currency("BRL", Value.BRL);

    /** The value {@code "BSD"}. */
    public static final Currency BSD = new Currency("BSD", Value.BSD);

    /** The value {@code "BTN"}. */
    public static final Currency BTN = new Currency("BTN", Value.BTN);

    /** The value {@code "BWP"}. */
    public static final Currency BWP = new Currency("BWP", Value.BWP);

    /** The value {@code "BYN"}. */
    public static final Currency BYN = new Currency("BYN", Value.BYN);

    /** The value {@code "BZD"}. */
    public static final Currency BZD = new Currency("BZD", Value.BZD);

    /** The value {@code "CAD"}. */
    public static final Currency CAD = new Currency("CAD", Value.CAD);

    /** The value {@code "CDF"}. */
    public static final Currency CDF = new Currency("CDF", Value.CDF);

    /** The value {@code "CHF"}. */
    public static final Currency CHF = new Currency("CHF", Value.CHF);

    /** The value {@code "CLP"}. */
    public static final Currency CLP = new Currency("CLP", Value.CLP);

    /** The value {@code "CNH"}. */
    public static final Currency CNH = new Currency("CNH", Value.CNH);

    /** The value {@code "CNY"}. */
    public static final Currency CNY = new Currency("CNY", Value.CNY);

    /** The value {@code "COP"}. */
    public static final Currency COP = new Currency("COP", Value.COP);

    /** The value {@code "CRC"}. */
    public static final Currency CRC = new Currency("CRC", Value.CRC);

    /** The value {@code "CUC"}. */
    public static final Currency CUC = new Currency("CUC", Value.CUC);

    /** The value {@code "CUP"}. */
    public static final Currency CUP = new Currency("CUP", Value.CUP);

    /** The value {@code "CVE"}. */
    public static final Currency CVE = new Currency("CVE", Value.CVE);

    /** The value {@code "CZK"}. */
    public static final Currency CZK = new Currency("CZK", Value.CZK);

    /** The value {@code "DJF"}. */
    public static final Currency DJF = new Currency("DJF", Value.DJF);

    /** The value {@code "DKK"}. */
    public static final Currency DKK = new Currency("DKK", Value.DKK);

    /** The value {@code "DOP"}. */
    public static final Currency DOP = new Currency("DOP", Value.DOP);

    /** The value {@code "DZD"}. */
    public static final Currency DZD = new Currency("DZD", Value.DZD);

    /** The value {@code "EGP"}. */
    public static final Currency EGP = new Currency("EGP", Value.EGP);

    /** The value {@code "ERN"}. */
    public static final Currency ERN = new Currency("ERN", Value.ERN);

    /** The value {@code "ETB"}. */
    public static final Currency ETB = new Currency("ETB", Value.ETB);

    /** The value {@code "EUR"}. */
    public static final Currency EUR = new Currency("EUR", Value.EUR);

    /** The value {@code "FJD"}. */
    public static final Currency FJD = new Currency("FJD", Value.FJD);

    /** The value {@code "FKP"}. */
    public static final Currency FKP = new Currency("FKP", Value.FKP);

    /** The value {@code "GBP"}. */
    public static final Currency GBP = new Currency("GBP", Value.GBP);

    /** The value {@code "GEL"}. */
    public static final Currency GEL = new Currency("GEL", Value.GEL);

    /** The value {@code "GHS"}. */
    public static final Currency GHS = new Currency("GHS", Value.GHS);

    /** The value {@code "GIP"}. */
    public static final Currency GIP = new Currency("GIP", Value.GIP);

    /** The value {@code "GMD"}. */
    public static final Currency GMD = new Currency("GMD", Value.GMD);

    /** The value {@code "GNF"}. */
    public static final Currency GNF = new Currency("GNF", Value.GNF);

    /** The value {@code "GTQ"}. */
    public static final Currency GTQ = new Currency("GTQ", Value.GTQ);

    /** The value {@code "GYD"}. */
    public static final Currency GYD = new Currency("GYD", Value.GYD);

    /** The value {@code "HKD"}. */
    public static final Currency HKD = new Currency("HKD", Value.HKD);

    /** The value {@code "HNL"}. */
    public static final Currency HNL = new Currency("HNL", Value.HNL);

    /** The value {@code "HRK"}. */
    public static final Currency HRK = new Currency("HRK", Value.HRK);

    /** The value {@code "HTG"}. */
    public static final Currency HTG = new Currency("HTG", Value.HTG);

    /** The value {@code "HUF"}. */
    public static final Currency HUF = new Currency("HUF", Value.HUF);

    /** The value {@code "IDR"}. */
    public static final Currency IDR = new Currency("IDR", Value.IDR);

    /** The value {@code "ILS"}. */
    public static final Currency ILS = new Currency("ILS", Value.ILS);

    /** The value {@code "INR"}. */
    public static final Currency INR = new Currency("INR", Value.INR);

    /** The value {@code "IQD"}. */
    public static final Currency IQD = new Currency("IQD", Value.IQD);

    /** The value {@code "IRR"}. */
    public static final Currency IRR = new Currency("IRR", Value.IRR);

    /** The value {@code "ISK"}. */
    public static final Currency ISK = new Currency("ISK", Value.ISK);

    /** The value {@code "JMD"}. */
    public static final Currency JMD = new Currency("JMD", Value.JMD);

    /** The value {@code "JOD"}. */
    public static final Currency JOD = new Currency("JOD", Value.JOD);

    /** The value {@code "JPY"}. */
    public static final Currency JPY = new Currency("JPY", Value.JPY);

    /** The value {@code "KES"}. */
    public static final Currency KES = new Currency("KES", Value.KES);

    /** The value {@code "KGS"}. */
    public static final Currency KGS = new Currency("KGS", Value.KGS);

    /** The value {@code "KHR"}. */
    public static final Currency KHR = new Currency("KHR", Value.KHR);

    /** The value {@code "KMF"}. */
    public static final Currency KMF = new Currency("KMF", Value.KMF);

    /** The value {@code "KPW"}. */
    public static final Currency KPW = new Currency("KPW", Value.KPW);

    /** The value {@code "KRW"}. */
    public static final Currency KRW = new Currency("KRW", Value.KRW);

    /** The value {@code "KWD"}. */
    public static final Currency KWD = new Currency("KWD", Value.KWD);

    /** The value {@code "KYD"}. */
    public static final Currency KYD = new Currency("KYD", Value.KYD);

    /** The value {@code "KZT"}. */
    public static final Currency KZT = new Currency("KZT", Value.KZT);

    /** The value {@code "LAK"}. */
    public static final Currency LAK = new Currency("LAK", Value.LAK);

    /** The value {@code "LBP"}. */
    public static final Currency LBP = new Currency("LBP", Value.LBP);

    /** The value {@code "LKR"}. */
    public static final Currency LKR = new Currency("LKR", Value.LKR);

    /** The value {@code "LRD"}. */
    public static final Currency LRD = new Currency("LRD", Value.LRD);

    /** The value {@code "LSL"}. */
    public static final Currency LSL = new Currency("LSL", Value.LSL);

    /** The value {@code "LYD"}. */
    public static final Currency LYD = new Currency("LYD", Value.LYD);

    /** The value {@code "MAD"}. */
    public static final Currency MAD = new Currency("MAD", Value.MAD);

    /** The value {@code "MDL"}. */
    public static final Currency MDL = new Currency("MDL", Value.MDL);

    /** The value {@code "MGA"}. */
    public static final Currency MGA = new Currency("MGA", Value.MGA);

    /** The value {@code "MKD"}. */
    public static final Currency MKD = new Currency("MKD", Value.MKD);

    /** The value {@code "MMK"}. */
    public static final Currency MMK = new Currency("MMK", Value.MMK);

    /** The value {@code "MNT"}. */
    public static final Currency MNT = new Currency("MNT", Value.MNT);

    /** The value {@code "MOP"}. */
    public static final Currency MOP = new Currency("MOP", Value.MOP);

    /** The value {@code "MRU"}. */
    public static final Currency MRU = new Currency("MRU", Value.MRU);

    /** The value {@code "MUR"}. */
    public static final Currency MUR = new Currency("MUR", Value.MUR);

    /** The value {@code "MVR"}. */
    public static final Currency MVR = new Currency("MVR", Value.MVR);

    /** The value {@code "MWK"}. */
    public static final Currency MWK = new Currency("MWK", Value.MWK);

    /** The value {@code "MXN"}. */
    public static final Currency MXN = new Currency("MXN", Value.MXN);

    /** The value {@code "MYR"}. */
    public static final Currency MYR = new Currency("MYR", Value.MYR);

    /** The value {@code "MZN"}. */
    public static final Currency MZN = new Currency("MZN", Value.MZN);

    /** The value {@code "NAD"}. */
    public static final Currency NAD = new Currency("NAD", Value.NAD);

    /** The value {@code "NGN"}. */
    public static final Currency NGN = new Currency("NGN", Value.NGN);

    /** The value {@code "NIO"}. */
    public static final Currency NIO = new Currency("NIO", Value.NIO);

    /** The value {@code "NOK"}. */
    public static final Currency NOK = new Currency("NOK", Value.NOK);

    /** The value {@code "NPR"}. */
    public static final Currency NPR = new Currency("NPR", Value.NPR);

    /** The value {@code "NZD"}. */
    public static final Currency NZD = new Currency("NZD", Value.NZD);

    /** The value {@code "OMR"}. */
    public static final Currency OMR = new Currency("OMR", Value.OMR);

    /** The value {@code "PAB"}. */
    public static final Currency PAB = new Currency("PAB", Value.PAB);

    /** The value {@code "PEN"}. */
    public static final Currency PEN = new Currency("PEN", Value.PEN);

    /** The value {@code "PGK"}. */
    public static final Currency PGK = new Currency("PGK", Value.PGK);

    /** The value {@code "PHP"}. */
    public static final Currency PHP = new Currency("PHP", Value.PHP);

    /** The value {@code "PKR"}. */
    public static final Currency PKR = new Currency("PKR", Value.PKR);

    /** The value {@code "PLN"}. */
    public static final Currency PLN = new Currency("PLN", Value.PLN);

    /** The value {@code "PYG"}. */
    public static final Currency PYG = new Currency("PYG", Value.PYG);

    /** The value {@code "QAR"}. */
    public static final Currency QAR = new Currency("QAR", Value.QAR);

    /** The value {@code "RON"}. */
    public static final Currency RON = new Currency("RON", Value.RON);

    /** The value {@code "RSD"}. */
    public static final Currency RSD = new Currency("RSD", Value.RSD);

    /** The value {@code "RUB"}. */
    public static final Currency RUB = new Currency("RUB", Value.RUB);

    /** The value {@code "RWF"}. */
    public static final Currency RWF = new Currency("RWF", Value.RWF);

    /** The value {@code "SAR"}. */
    public static final Currency SAR = new Currency("SAR", Value.SAR);

    /** The value {@code "SBD"}. */
    public static final Currency SBD = new Currency("SBD", Value.SBD);

    /** The value {@code "SCR"}. */
    public static final Currency SCR = new Currency("SCR", Value.SCR);

    /** The value {@code "SDG"}. */
    public static final Currency SDG = new Currency("SDG", Value.SDG);

    /** The value {@code "SEK"}. */
    public static final Currency SEK = new Currency("SEK", Value.SEK);

    /** The value {@code "SGD"}. */
    public static final Currency SGD = new Currency("SGD", Value.SGD);

    /** The value {@code "SHP"}. */
    public static final Currency SHP = new Currency("SHP", Value.SHP);

    /** The value {@code "SLL"}. */
    public static final Currency SLL = new Currency("SLL", Value.SLL);

    /** The value {@code "SOS"}. */
    public static final Currency SOS = new Currency("SOS", Value.SOS);

    /** The value {@code "SRD"}. */
    public static final Currency SRD = new Currency("SRD", Value.SRD);

    /** The value {@code "SSP"}. */
    public static final Currency SSP = new Currency("SSP", Value.SSP);

    /** The value {@code "STD"}. */
    public static final Currency STD = new Currency("STD", Value.STD);

    /** The value {@code "STN"}. */
    public static final Currency STN = new Currency("STN", Value.STN);

    /** The value {@code "SVC"}. */
    public static final Currency SVC = new Currency("SVC", Value.SVC);

    /** The value {@code "SYP"}. */
    public static final Currency SYP = new Currency("SYP", Value.SYP);

    /** The value {@code "SZL"}. */
    public static final Currency SZL = new Currency("SZL", Value.SZL);

    /** The value {@code "THB"}. */
    public static final Currency THB = new Currency("THB", Value.THB);

    /** The value {@code "TJS"}. */
    public static final Currency TJS = new Currency("TJS", Value.TJS);

    /** The value {@code "TMT"}. */
    public static final Currency TMT = new Currency("TMT", Value.TMT);

    /** The value {@code "TND"}. */
    public static final Currency TND = new Currency("TND", Value.TND);

    /** The value {@code "TOP"}. */
    public static final Currency TOP = new Currency("TOP", Value.TOP);

    /** The value {@code "TRY"}. */
    public static final Currency TRY = new Currency("TRY", Value.TRY);

    /** The value {@code "TTD"}. */
    public static final Currency TTD = new Currency("TTD", Value.TTD);

    /** The value {@code "TWD"}. */
    public static final Currency TWD = new Currency("TWD", Value.TWD);

    /** The value {@code "TZS"}. */
    public static final Currency TZS = new Currency("TZS", Value.TZS);

    /** The value {@code "UAH"}. */
    public static final Currency UAH = new Currency("UAH", Value.UAH);

    /** The value {@code "UGX"}. */
    public static final Currency UGX = new Currency("UGX", Value.UGX);

    /** The value {@code "USD"}. */
    public static final Currency USD = new Currency("USD", Value.USD);

    /** The value {@code "UYU"}. */
    public static final Currency UYU = new Currency("UYU", Value.UYU);

    /** The value {@code "UZS"}. */
    public static final Currency UZS = new Currency("UZS", Value.UZS);

    /** The value {@code "VES"}. */
    public static final Currency VES = new Currency("VES", Value.VES);

    /** The value {@code "VND"}. */
    public static final Currency VND = new Currency("VND", Value.VND);

    /** The value {@code "VUV"}. */
    public static final Currency VUV = new Currency("VUV", Value.VUV);

    /** The value {@code "WST"}. */
    public static final Currency WST = new Currency("WST", Value.WST);

    /** The value {@code "XAF"}. */
    public static final Currency XAF = new Currency("XAF", Value.XAF);

    /** The value {@code "XCD"}. */
    public static final Currency XCD = new Currency("XCD", Value.XCD);

    /** The value {@code "XOF"}. */
    public static final Currency XOF = new Currency("XOF", Value.XOF);

    /** The value {@code "XPF"}. */
    public static final Currency XPF = new Currency("XPF", Value.XPF);

    /** The value {@code "YER"}. */
    public static final Currency YER = new Currency("YER", Value.YER);

    /** The value {@code "ZAR"}. */
    public static final Currency ZAR = new Currency("ZAR", Value.ZAR);

    /** The value {@code "ZMW"}. */
    public static final Currency ZMW = new Currency("ZMW", Value.ZMW);

    /** The value {@code "ZWL"}. */
    public static final Currency ZWL = new Currency("ZWL", Value.ZWL);

    private static final Map<String, Currency> constants =
            Map.ofEntries(
                    Map.entry("AED", AED),
                    Map.entry("AFN", AFN),
                    Map.entry("ALL", ALL),
                    Map.entry("AMD", AMD),
                    Map.entry("ANG", ANG),
                    Map.entry("AOA", AOA),
                    Map.entry("ARS", ARS),
                    Map.entry("AUD", AUD),
                    Map.entry("AWG", AWG),
                    Map.entry("AZN", AZN),
                    Map.entry("BAM", BAM),
                    Map.entry("BBD", BBD),
                    Map.entry("BDT", BDT),
                    Map.entry("BGN", BGN),
                    Map.entry("BHD", BHD),
                    Map.entry("BIF", BIF),
                    Map.entry("BMD", BMD),
                    Map.entry("BND", BND),
                    Map.entry("BOB", BOB),
                    Map.entry("BRL", BRL),
                    Map.entry("BSD", BSD),
                    Map.entry("BTN", BTN),
                    Map.entry("BWP", BWP),
                    Map.entry("BYN", BYN),
                    Map.entry("BZD", BZD),
                    Map.entry("CAD", CAD),
                    Map.entry("CDF", CDF),
                    Map.entry("CHF", CHF),
                    Map.entry("CLP", CLP),
                    Map.entry("CNH", CNH),
                    Map.entry("CNY", CNY),
                    Map.entry("COP", COP),
                    Map.entry("CRC", CRC),
                    Map.entry("CUC", CUC),
                    Map.entry("CUP", CUP),
                    Map.entry("CVE", CVE),
                    Map.entry("CZK", CZK),
                    Map.entry("DJF", DJF),
                    Map.entry("DKK", DKK),
                    Map.entry("DOP", DOP),
                    Map.entry("DZD", DZD),
                    Map.entry("EGP", EGP),
                    Map.entry("ERN", ERN),
                    Map.entry("ETB", ETB),
                    Map.entry("EUR", EUR),
                    Map.entry("FJD", FJD),
                    Map.entry("FKP", FKP),
                    Map.entry("GBP", GBP),
                    Map.entry("GEL", GEL),
                    Map.entry("GHS", GHS),
                    Map.entry("GIP", GIP),
                    Map.entry("GMD", GMD),
                    Map.entry("GNF", GNF),
                    Map.entry("GTQ", GTQ),
                    Map.entry("GYD", GYD),
                    Map.entry("HKD", HKD),
                    Map.entry("HNL", HNL),
                    Map.entry("HRK", HRK),
                    Map.entry("HTG", HTG),
                    Map.entry("HUF", HUF),
                    Map.entry("IDR", IDR),
                    Map.entry("ILS", ILS),
                    Map.entry("INR", INR),
                    Map.entry("IQD", IQD),
                    Map.entry("IRR", IRR),
                    Map.entry("ISK", ISK),
                    Map.entry("JMD", JMD),
                    Map.entry("JOD", JOD),
                    Map.entry("JPY", JPY),
                    Map.entry("KES", KES),
                    Map.entry("KGS", KGS),
                    Map.entry("KHR", KHR),
                    Map.entry("KMF", KMF),
                    Map.entry("KPW", KPW),
                    Map.entry("KRW", KRW),
                    Map.entry("KWD", KWD),
                    Map.entry("KYD", KYD),
                    Map.entry("KZT", KZT),
                    Map.entry("LAK", LAK),
                    Map.entry("LBP", LBP),
                    Map.entry("LKR", LKR),
                    Map.entry("LRD", LRD),
                    Map.entry("LSL", LSL),
                    Map.entry("LYD", LYD),
                    Map.entry("MAD", MAD),
                    Map.entry("MDL", MDL),
                    Map.entry("MGA", MGA),
                    Map.entry("MKD", MKD),
                    Map.entry("MMK", MMK),
                    Map.entry("MNT", MNT),
                    Map.entry("MOP", MOP),
                    Map.entry("MRU", MRU),
                    Map.entry("MUR", MUR),
                    Map.entry("MVR", MVR),
                    Map.entry("MWK", MWK),
                    Map.entry("MXN", MXN),
                    Map.entry("MYR", MYR),
                    Map.entry("MZN", MZN),
                    Map.entry("NAD", NAD),
                    Map.entry("NGN", NGN),
                    Map.entry("NIO", NIO),
                    Map.entry("NOK", NOK),
                    Map.entry("NPR", NPR),
                    Map.entry("NZD", NZD),
                    Map.entry("OMR", OMR),
                    Map.entry("PAB", PAB),
                    Map.entry("PEN", PEN),
                    Map.entry("PGK", PGK),
                    Map.entry("PHP", PHP),
                    Map.entry("PKR", PKR),
                    Map.entry("PLN", PLN),
                    Map.entry("PYG", PYG),
                    Map.entry("QAR", QAR),
                    Map.entry("RON", RON),
                    Map.entry("RSD", RSD),
                    Map.entry("RUB", RUB),
                    Map.entry("RWF", RWF),
                    Map.entry("SAR", SAR),
                    Map.entry("SBD", SBD),
                    Map.entry("SCR", SCR),
                    Map.entry("SDG", SDG),
                    Map.entry("SEK", SEK),
                    Map.entry("SGD", SGD),
                    Map.entry("SHP", SHP),
                    Map.entry("SLL", SLL),
                    Map.entry("SOS", SOS),
                    Map.entry("SRD", SRD),
                    Map.entry("SSP", SSP),
                    Map.entry("STD", STD),
                    Map.entry("STN", STN),
                    Map.entry("SVC", SVC),
                    Map.entry("SYP", SYP),
                    Map.entry("SZL", SZL),
                    Map.entry("THB", THB),
                    Map.entry("TJS", TJS),
                    Map.entry("TMT", TMT),
                    Map.entry("TND", TND),
                    Map.entry("TOP", TOP),
                    Map.entry("TRY", TRY),
                    Map.entry("TTD", TTD),
                    Map.entry("TWD", TWD),
                    Map.entry("TZS", TZS),
                    Map.entry("UAH", UAH),
                    Map.entry("UGX", UGX),
                    Map.entry("USD", USD),
                    Map.entry("UYU", UYU),
                    Map.entry("UZS", UZS),
                    Map.entry("VES", VES),
                    Map.entry("VND", VND),
                    Map.entry("VUV", VUV),
                    Map.entry("WST", WST),
                    Map.entry("XAF", XAF),
                    Map.entry("XCD", XCD),
                    Map.entry("XOF", XOF),
                    Map.entry("XPF", XPF),
                    Map.entry("YER", YER),
                    Map.entry("ZAR", ZAR),
                    Map.entry("ZMW", ZMW),
                    Map.entry("ZWL", ZWL));

    private final String value;
    private final Value variant;

    private Currency(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown Currency holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Currency of(String value) {
        Currency constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new Currency(value, Value._UNKNOWN);
    }

    /**
     * The value as sent.
     *
     * @return the value
     */
    @JsonValue
    public String asString() {
        return value;
    }

    /**
     * Whether this version of the SDK knows the value.
     *
     * @return whether it is known
     */
    public boolean isKnown() {
        return variant != Value._UNKNOWN;
    }

    /**
     * The value as an enum to switch on, unknown values included.
     *
     * @return the enum, {@code _UNKNOWN} when unknown
     */
    public Value value() {
        return variant;
    }

    /**
     * The value as an enum of the known values only.
     *
     * @return the enum
     * @throws com.meteroid.exceptions.InvalidDataException when this version of the SDK does not
     *     know the value
     */
    public Known known() {
        if (!isKnown()) {
            throw new com.meteroid.exceptions.InvalidDataException("unknown Currency: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Currency && Objects.equals(value, ((Currency) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /** The values this version of the SDK knows. */
    public enum Known {
        /** The {@code AED} constant. */
        AED,
        /** The {@code AFN} constant. */
        AFN,
        /** The {@code ALL} constant. */
        ALL,
        /** The {@code AMD} constant. */
        AMD,
        /** The {@code ANG} constant. */
        ANG,
        /** The {@code AOA} constant. */
        AOA,
        /** The {@code ARS} constant. */
        ARS,
        /** The {@code AUD} constant. */
        AUD,
        /** The {@code AWG} constant. */
        AWG,
        /** The {@code AZN} constant. */
        AZN,
        /** The {@code BAM} constant. */
        BAM,
        /** The {@code BBD} constant. */
        BBD,
        /** The {@code BDT} constant. */
        BDT,
        /** The {@code BGN} constant. */
        BGN,
        /** The {@code BHD} constant. */
        BHD,
        /** The {@code BIF} constant. */
        BIF,
        /** The {@code BMD} constant. */
        BMD,
        /** The {@code BND} constant. */
        BND,
        /** The {@code BOB} constant. */
        BOB,
        /** The {@code BRL} constant. */
        BRL,
        /** The {@code BSD} constant. */
        BSD,
        /** The {@code BTN} constant. */
        BTN,
        /** The {@code BWP} constant. */
        BWP,
        /** The {@code BYN} constant. */
        BYN,
        /** The {@code BZD} constant. */
        BZD,
        /** The {@code CAD} constant. */
        CAD,
        /** The {@code CDF} constant. */
        CDF,
        /** The {@code CHF} constant. */
        CHF,
        /** The {@code CLP} constant. */
        CLP,
        /** The {@code CNH} constant. */
        CNH,
        /** The {@code CNY} constant. */
        CNY,
        /** The {@code COP} constant. */
        COP,
        /** The {@code CRC} constant. */
        CRC,
        /** The {@code CUC} constant. */
        CUC,
        /** The {@code CUP} constant. */
        CUP,
        /** The {@code CVE} constant. */
        CVE,
        /** The {@code CZK} constant. */
        CZK,
        /** The {@code DJF} constant. */
        DJF,
        /** The {@code DKK} constant. */
        DKK,
        /** The {@code DOP} constant. */
        DOP,
        /** The {@code DZD} constant. */
        DZD,
        /** The {@code EGP} constant. */
        EGP,
        /** The {@code ERN} constant. */
        ERN,
        /** The {@code ETB} constant. */
        ETB,
        /** The {@code EUR} constant. */
        EUR,
        /** The {@code FJD} constant. */
        FJD,
        /** The {@code FKP} constant. */
        FKP,
        /** The {@code GBP} constant. */
        GBP,
        /** The {@code GEL} constant. */
        GEL,
        /** The {@code GHS} constant. */
        GHS,
        /** The {@code GIP} constant. */
        GIP,
        /** The {@code GMD} constant. */
        GMD,
        /** The {@code GNF} constant. */
        GNF,
        /** The {@code GTQ} constant. */
        GTQ,
        /** The {@code GYD} constant. */
        GYD,
        /** The {@code HKD} constant. */
        HKD,
        /** The {@code HNL} constant. */
        HNL,
        /** The {@code HRK} constant. */
        HRK,
        /** The {@code HTG} constant. */
        HTG,
        /** The {@code HUF} constant. */
        HUF,
        /** The {@code IDR} constant. */
        IDR,
        /** The {@code ILS} constant. */
        ILS,
        /** The {@code INR} constant. */
        INR,
        /** The {@code IQD} constant. */
        IQD,
        /** The {@code IRR} constant. */
        IRR,
        /** The {@code ISK} constant. */
        ISK,
        /** The {@code JMD} constant. */
        JMD,
        /** The {@code JOD} constant. */
        JOD,
        /** The {@code JPY} constant. */
        JPY,
        /** The {@code KES} constant. */
        KES,
        /** The {@code KGS} constant. */
        KGS,
        /** The {@code KHR} constant. */
        KHR,
        /** The {@code KMF} constant. */
        KMF,
        /** The {@code KPW} constant. */
        KPW,
        /** The {@code KRW} constant. */
        KRW,
        /** The {@code KWD} constant. */
        KWD,
        /** The {@code KYD} constant. */
        KYD,
        /** The {@code KZT} constant. */
        KZT,
        /** The {@code LAK} constant. */
        LAK,
        /** The {@code LBP} constant. */
        LBP,
        /** The {@code LKR} constant. */
        LKR,
        /** The {@code LRD} constant. */
        LRD,
        /** The {@code LSL} constant. */
        LSL,
        /** The {@code LYD} constant. */
        LYD,
        /** The {@code MAD} constant. */
        MAD,
        /** The {@code MDL} constant. */
        MDL,
        /** The {@code MGA} constant. */
        MGA,
        /** The {@code MKD} constant. */
        MKD,
        /** The {@code MMK} constant. */
        MMK,
        /** The {@code MNT} constant. */
        MNT,
        /** The {@code MOP} constant. */
        MOP,
        /** The {@code MRU} constant. */
        MRU,
        /** The {@code MUR} constant. */
        MUR,
        /** The {@code MVR} constant. */
        MVR,
        /** The {@code MWK} constant. */
        MWK,
        /** The {@code MXN} constant. */
        MXN,
        /** The {@code MYR} constant. */
        MYR,
        /** The {@code MZN} constant. */
        MZN,
        /** The {@code NAD} constant. */
        NAD,
        /** The {@code NGN} constant. */
        NGN,
        /** The {@code NIO} constant. */
        NIO,
        /** The {@code NOK} constant. */
        NOK,
        /** The {@code NPR} constant. */
        NPR,
        /** The {@code NZD} constant. */
        NZD,
        /** The {@code OMR} constant. */
        OMR,
        /** The {@code PAB} constant. */
        PAB,
        /** The {@code PEN} constant. */
        PEN,
        /** The {@code PGK} constant. */
        PGK,
        /** The {@code PHP} constant. */
        PHP,
        /** The {@code PKR} constant. */
        PKR,
        /** The {@code PLN} constant. */
        PLN,
        /** The {@code PYG} constant. */
        PYG,
        /** The {@code QAR} constant. */
        QAR,
        /** The {@code RON} constant. */
        RON,
        /** The {@code RSD} constant. */
        RSD,
        /** The {@code RUB} constant. */
        RUB,
        /** The {@code RWF} constant. */
        RWF,
        /** The {@code SAR} constant. */
        SAR,
        /** The {@code SBD} constant. */
        SBD,
        /** The {@code SCR} constant. */
        SCR,
        /** The {@code SDG} constant. */
        SDG,
        /** The {@code SEK} constant. */
        SEK,
        /** The {@code SGD} constant. */
        SGD,
        /** The {@code SHP} constant. */
        SHP,
        /** The {@code SLL} constant. */
        SLL,
        /** The {@code SOS} constant. */
        SOS,
        /** The {@code SRD} constant. */
        SRD,
        /** The {@code SSP} constant. */
        SSP,
        /** The {@code STD} constant. */
        STD,
        /** The {@code STN} constant. */
        STN,
        /** The {@code SVC} constant. */
        SVC,
        /** The {@code SYP} constant. */
        SYP,
        /** The {@code SZL} constant. */
        SZL,
        /** The {@code THB} constant. */
        THB,
        /** The {@code TJS} constant. */
        TJS,
        /** The {@code TMT} constant. */
        TMT,
        /** The {@code TND} constant. */
        TND,
        /** The {@code TOP} constant. */
        TOP,
        /** The {@code TRY} constant. */
        TRY,
        /** The {@code TTD} constant. */
        TTD,
        /** The {@code TWD} constant. */
        TWD,
        /** The {@code TZS} constant. */
        TZS,
        /** The {@code UAH} constant. */
        UAH,
        /** The {@code UGX} constant. */
        UGX,
        /** The {@code USD} constant. */
        USD,
        /** The {@code UYU} constant. */
        UYU,
        /** The {@code UZS} constant. */
        UZS,
        /** The {@code VES} constant. */
        VES,
        /** The {@code VND} constant. */
        VND,
        /** The {@code VUV} constant. */
        VUV,
        /** The {@code WST} constant. */
        WST,
        /** The {@code XAF} constant. */
        XAF,
        /** The {@code XCD} constant. */
        XCD,
        /** The {@code XOF} constant. */
        XOF,
        /** The {@code XPF} constant. */
        XPF,
        /** The {@code YER} constant. */
        YER,
        /** The {@code ZAR} constant. */
        ZAR,
        /** The {@code ZMW} constant. */
        ZMW,
        /** The {@code ZWL} constant. */
        ZWL
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code AED} constant. */
        AED,
        /** The {@code AFN} constant. */
        AFN,
        /** The {@code ALL} constant. */
        ALL,
        /** The {@code AMD} constant. */
        AMD,
        /** The {@code ANG} constant. */
        ANG,
        /** The {@code AOA} constant. */
        AOA,
        /** The {@code ARS} constant. */
        ARS,
        /** The {@code AUD} constant. */
        AUD,
        /** The {@code AWG} constant. */
        AWG,
        /** The {@code AZN} constant. */
        AZN,
        /** The {@code BAM} constant. */
        BAM,
        /** The {@code BBD} constant. */
        BBD,
        /** The {@code BDT} constant. */
        BDT,
        /** The {@code BGN} constant. */
        BGN,
        /** The {@code BHD} constant. */
        BHD,
        /** The {@code BIF} constant. */
        BIF,
        /** The {@code BMD} constant. */
        BMD,
        /** The {@code BND} constant. */
        BND,
        /** The {@code BOB} constant. */
        BOB,
        /** The {@code BRL} constant. */
        BRL,
        /** The {@code BSD} constant. */
        BSD,
        /** The {@code BTN} constant. */
        BTN,
        /** The {@code BWP} constant. */
        BWP,
        /** The {@code BYN} constant. */
        BYN,
        /** The {@code BZD} constant. */
        BZD,
        /** The {@code CAD} constant. */
        CAD,
        /** The {@code CDF} constant. */
        CDF,
        /** The {@code CHF} constant. */
        CHF,
        /** The {@code CLP} constant. */
        CLP,
        /** The {@code CNH} constant. */
        CNH,
        /** The {@code CNY} constant. */
        CNY,
        /** The {@code COP} constant. */
        COP,
        /** The {@code CRC} constant. */
        CRC,
        /** The {@code CUC} constant. */
        CUC,
        /** The {@code CUP} constant. */
        CUP,
        /** The {@code CVE} constant. */
        CVE,
        /** The {@code CZK} constant. */
        CZK,
        /** The {@code DJF} constant. */
        DJF,
        /** The {@code DKK} constant. */
        DKK,
        /** The {@code DOP} constant. */
        DOP,
        /** The {@code DZD} constant. */
        DZD,
        /** The {@code EGP} constant. */
        EGP,
        /** The {@code ERN} constant. */
        ERN,
        /** The {@code ETB} constant. */
        ETB,
        /** The {@code EUR} constant. */
        EUR,
        /** The {@code FJD} constant. */
        FJD,
        /** The {@code FKP} constant. */
        FKP,
        /** The {@code GBP} constant. */
        GBP,
        /** The {@code GEL} constant. */
        GEL,
        /** The {@code GHS} constant. */
        GHS,
        /** The {@code GIP} constant. */
        GIP,
        /** The {@code GMD} constant. */
        GMD,
        /** The {@code GNF} constant. */
        GNF,
        /** The {@code GTQ} constant. */
        GTQ,
        /** The {@code GYD} constant. */
        GYD,
        /** The {@code HKD} constant. */
        HKD,
        /** The {@code HNL} constant. */
        HNL,
        /** The {@code HRK} constant. */
        HRK,
        /** The {@code HTG} constant. */
        HTG,
        /** The {@code HUF} constant. */
        HUF,
        /** The {@code IDR} constant. */
        IDR,
        /** The {@code ILS} constant. */
        ILS,
        /** The {@code INR} constant. */
        INR,
        /** The {@code IQD} constant. */
        IQD,
        /** The {@code IRR} constant. */
        IRR,
        /** The {@code ISK} constant. */
        ISK,
        /** The {@code JMD} constant. */
        JMD,
        /** The {@code JOD} constant. */
        JOD,
        /** The {@code JPY} constant. */
        JPY,
        /** The {@code KES} constant. */
        KES,
        /** The {@code KGS} constant. */
        KGS,
        /** The {@code KHR} constant. */
        KHR,
        /** The {@code KMF} constant. */
        KMF,
        /** The {@code KPW} constant. */
        KPW,
        /** The {@code KRW} constant. */
        KRW,
        /** The {@code KWD} constant. */
        KWD,
        /** The {@code KYD} constant. */
        KYD,
        /** The {@code KZT} constant. */
        KZT,
        /** The {@code LAK} constant. */
        LAK,
        /** The {@code LBP} constant. */
        LBP,
        /** The {@code LKR} constant. */
        LKR,
        /** The {@code LRD} constant. */
        LRD,
        /** The {@code LSL} constant. */
        LSL,
        /** The {@code LYD} constant. */
        LYD,
        /** The {@code MAD} constant. */
        MAD,
        /** The {@code MDL} constant. */
        MDL,
        /** The {@code MGA} constant. */
        MGA,
        /** The {@code MKD} constant. */
        MKD,
        /** The {@code MMK} constant. */
        MMK,
        /** The {@code MNT} constant. */
        MNT,
        /** The {@code MOP} constant. */
        MOP,
        /** The {@code MRU} constant. */
        MRU,
        /** The {@code MUR} constant. */
        MUR,
        /** The {@code MVR} constant. */
        MVR,
        /** The {@code MWK} constant. */
        MWK,
        /** The {@code MXN} constant. */
        MXN,
        /** The {@code MYR} constant. */
        MYR,
        /** The {@code MZN} constant. */
        MZN,
        /** The {@code NAD} constant. */
        NAD,
        /** The {@code NGN} constant. */
        NGN,
        /** The {@code NIO} constant. */
        NIO,
        /** The {@code NOK} constant. */
        NOK,
        /** The {@code NPR} constant. */
        NPR,
        /** The {@code NZD} constant. */
        NZD,
        /** The {@code OMR} constant. */
        OMR,
        /** The {@code PAB} constant. */
        PAB,
        /** The {@code PEN} constant. */
        PEN,
        /** The {@code PGK} constant. */
        PGK,
        /** The {@code PHP} constant. */
        PHP,
        /** The {@code PKR} constant. */
        PKR,
        /** The {@code PLN} constant. */
        PLN,
        /** The {@code PYG} constant. */
        PYG,
        /** The {@code QAR} constant. */
        QAR,
        /** The {@code RON} constant. */
        RON,
        /** The {@code RSD} constant. */
        RSD,
        /** The {@code RUB} constant. */
        RUB,
        /** The {@code RWF} constant. */
        RWF,
        /** The {@code SAR} constant. */
        SAR,
        /** The {@code SBD} constant. */
        SBD,
        /** The {@code SCR} constant. */
        SCR,
        /** The {@code SDG} constant. */
        SDG,
        /** The {@code SEK} constant. */
        SEK,
        /** The {@code SGD} constant. */
        SGD,
        /** The {@code SHP} constant. */
        SHP,
        /** The {@code SLL} constant. */
        SLL,
        /** The {@code SOS} constant. */
        SOS,
        /** The {@code SRD} constant. */
        SRD,
        /** The {@code SSP} constant. */
        SSP,
        /** The {@code STD} constant. */
        STD,
        /** The {@code STN} constant. */
        STN,
        /** The {@code SVC} constant. */
        SVC,
        /** The {@code SYP} constant. */
        SYP,
        /** The {@code SZL} constant. */
        SZL,
        /** The {@code THB} constant. */
        THB,
        /** The {@code TJS} constant. */
        TJS,
        /** The {@code TMT} constant. */
        TMT,
        /** The {@code TND} constant. */
        TND,
        /** The {@code TOP} constant. */
        TOP,
        /** The {@code TRY} constant. */
        TRY,
        /** The {@code TTD} constant. */
        TTD,
        /** The {@code TWD} constant. */
        TWD,
        /** The {@code TZS} constant. */
        TZS,
        /** The {@code UAH} constant. */
        UAH,
        /** The {@code UGX} constant. */
        UGX,
        /** The {@code USD} constant. */
        USD,
        /** The {@code UYU} constant. */
        UYU,
        /** The {@code UZS} constant. */
        UZS,
        /** The {@code VES} constant. */
        VES,
        /** The {@code VND} constant. */
        VND,
        /** The {@code VUV} constant. */
        VUV,
        /** The {@code WST} constant. */
        WST,
        /** The {@code XAF} constant. */
        XAF,
        /** The {@code XCD} constant. */
        XCD,
        /** The {@code XOF} constant. */
        XOF,
        /** The {@code XPF} constant. */
        XPF,
        /** The {@code YER} constant. */
        YER,
        /** The {@code ZAR} constant. */
        ZAR,
        /** The {@code ZMW} constant. */
        ZMW,
        /** The {@code ZWL} constant. */
        ZWL,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
