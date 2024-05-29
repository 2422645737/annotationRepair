package impl;

import entity.AbstractRegexMatcher;
import interfaces.RepairStrategy;
import utils.FileTypeUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApiModelRepairStrategy extends AbstractRegexMatcher implements RepairStrategy{
    public ApiModelRepairStrategy(String pattern) {
        super(pattern);
    }

    @Override
    public void repair(File file) {
        StringBuffer newContent = new StringBuffer(readFile(file));
        String fill = FileTypeUtil.isDTO(file.getName()) ? "参数DTO" : "参数VO";

        //处理没有ApiModel注解的情况
        if(newContent.indexOf("import io.swagger.annotations.ApiModel") == -1){
            //导入相关依赖
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiModel;\n");
            //在类定义上方添加注解
            int index = newContent.indexOf("public class ");
            newContent.insert(index ,"@ApiModel(description = \"" + fill + "\")\n");
        }
        //执行正则替换
        String result = replace(newContent.toString());

        //处理有ApiModel注解，但是注解不规范的情况，例如ApiModel("")
        String commentRegex = "@ApiModel\\(\\s*\"([^\"]*)\"\\)";
        String regexResult = "@ApiModel(description = \"" + fill + "\")";
        result = Pattern.compile(commentRegex).matcher(result).replaceAll(regexResult);
        //TODO: 处理单独只有一个@ApiModel的情况
        writeFile(result,file);
    }
}