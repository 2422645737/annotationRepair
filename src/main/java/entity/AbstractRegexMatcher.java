package entity;

import cn.hutool.core.collection.CollUtil;
import enums.RegexEnum;
import enums.RepairEnum;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 正则匹配抽象类（不抽象）
 * @fileName: RegexMatcher
 * @author: wanghui
 * @createAt: 2024/05/29 04:45:09
 * @updateBy:
 * @copyright: 众阳健康
 */
public abstract class AbstractRegexMatcher {

    /**
     * 匹配正则和替换正则集合（）
     */
    private List<Pair<String,String>> replaceRegex;

    public AbstractRegexMatcher(String pattern){
        if(RepairEnum.API_PARAM.equals(pattern))replaceRegex = RegexEnum.apiParamRegex;
        if(RepairEnum.API_MODEL.equals(pattern))replaceRegex = RegexEnum.apiModelRegex;
        if(RepairEnum.API_OPERATION.equals(pattern))replaceRegex = RegexEnum.apiOperationRegex;
        if(RepairEnum.API_MODEL_PROPERTY.equals(pattern))replaceRegex = RegexEnum.apiModelPropertyRegex;
    }

    public String replace(String content){
        if(null == replaceRegex)return content;

        for (Pair<String, String> regex : replaceRegex) {
            content = Pattern.compile(regex.getLeft()).matcher(content).replaceAll(regex.getRight());
        }
        return content;
    }
}