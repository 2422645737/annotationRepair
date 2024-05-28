package impl;

import interfaces.RepairStrategy;
import utils.FileTypeUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApiModelRepairStrategy implements RepairStrategy {
    @Override
    public void repair(File file) {
        String content = readFile(file);
        StringBuffer newContent = new StringBuffer(content);
        String fill = FileTypeUtil.isDTO(file.getName()) ? "参数DTO" : "参数VO";

        //处理没有ApiModel注解的情况
        if(!content.contains("import io.swagger.annotations.ApiModel")){
            System.out.println("当前处理的文件---" + file.getAbsolutePath());
            //导入相关依赖
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiModel;\n");

            //在类定义上方添加注解
            int index = newContent.indexOf("public class ");
            newContent.insert(index ,"@ApiModel(description = \"" + fill + "\")\n");

        }
        //处理有ApiModel注解，但是注解不规范的情况，例如ApiModel("abc")
        String commentRegex = "@ApiModel\\(\\s*\"([^\"]+)\"\\)";
        String regexResult = "@ApiModel(description = \"$1\")";
        Pattern pattern = Pattern.compile(commentRegex);
        Matcher matcher = pattern.matcher(newContent.toString());
        String result = matcher.replaceAll(regexResult);
        result = result.trim();

        //处理有ApiModel注解，但是注解不规范的情况，例如ApiModel("")
        commentRegex = "@ApiModel\\(\\s*\"([^\"]*)\"\\)";
        regexResult = "@ApiModel(description = \"" + fill + "\")";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);
        result = result.trim();

        //TODO: 处理单独只有一个@ApiModel的情况

        writeFile(result,file);
    }
}
