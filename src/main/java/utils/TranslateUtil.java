package utils;

import enums.TranslateConst;
import org.apache.commons.lang3.StringUtils;
import translate.TransApi;

public class TranslateUtil {
    private static final TransApi api = new TransApi(TranslateConst.APP_ID, TranslateConst.SECURITY_KEY);

    public static String translate(String source){
        if(StringUtils.isEmpty(source)){
            return source;
        }
        String result = api.getTransResult(source, "auto", "zh");
        return result;
    }

}