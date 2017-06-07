package com.mika.credit.facade.front.en.Util;

import com.creditsafe.globaldata.datatypes.CountryCode;
import com.creditsafe.globaldata.datatypes.QueryMatchType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gavin on 16-10-19.
 */
public class PossibleSearchCriteria {
    public static Map<CountryCode, QueryMatchType> criteria;

    static {
        criteria = new HashMap<>();
        criteria.put(CountryCode.DE, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.FR, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.GB, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.IE, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.ES, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.CH, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.LI, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.NL, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.CZ, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.IS, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.LT, QueryMatchType.MATCH_ANY_PARTS);
        criteria.put(CountryCode.MT, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.PL, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.SK, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.BE, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.NO, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.SE, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.PT, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.LU, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.CA, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.US, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.PR, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.AS, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.FM, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.GU, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.MH, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.MP, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.PW, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.VI, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.SI, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.AL, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.BA, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.HR, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.MK, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.BG, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.RO, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.ME, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.RS, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.LV, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.EE, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.UA, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.MD, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.KM, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.AT, QueryMatchType.MATCH_WORDS);
        criteria.put(CountryCode.IT, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.BR, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.HU, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.TW, QueryMatchType.MATCH_BEGINNING);
        criteria.put(CountryCode.KR, QueryMatchType.MATCH_BLOCK_OR_WORDS);
        criteria.put(CountryCode.FI, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.MX, QueryMatchType.CLOSEST_KEYWORDS);
        criteria.put(CountryCode.DK, QueryMatchType.MATCH_BEGINNING);
    }
}
