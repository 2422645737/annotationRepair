package impl;

import interfaces.RepairStrategy;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApiParamRepairStrategy implements RepairStrategy {
    @Override
    public void repair(File file) {
        //读取文件内容
        String content = readFile(file);
        StringBuffer newContent = new StringBuffer(content);
        //如果不存在，首先添加依赖
        if(!content.contains("import io.swagger.annotations.ApiParam;")){
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiParam;\n");
        }

        //处理ApiParam缺失的情况

        //1、在(@RequestBody 前面添加ApiParam
        String commentRegex = "\\(\\s*@RequestBody";
        String regexResult = "(@ApiParam(value = \"请求参数\",example = \"参数示例\") @RequestBody";
        Pattern pattern = Pattern.compile(commentRegex);
        Matcher matcher = pattern.matcher(newContent.toString());
        String result = matcher.replaceAll(regexResult);

        //2、在(@RequestParam 前面添加ApiParam
        commentRegex = "\\(\\s*@RequestParam";
        regexResult = "(@ApiParam(value = \"请求参数\",example = \"参数示例\") @RequestParam";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);

        //3、在(@Validated 前面添加ApiParam
        commentRegex = "\\(\\s*@Validated";
        regexResult = "(@ApiParam(value = \"请求参数\",example = \"参数示例\") @Validated";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);

        //4、在(@NotNull 前面添加ApiParam
        commentRegex = "\\(\\s*@NotNull";
        regexResult = "(@ApiParam(value = \"请求参数\",example = \"参数示例\") @NotNull";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);

        //5、在(@NotBlank 前面添加ApiParam
        commentRegex = "\\(\\s*@NotBlank";
        regexResult = "(@ApiParam(value = \"请求参数\",example = \"参数示例\") @NotBlank";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);

        //修复ApiParam不规范的情况

        //1、修复@ApiParam(value = "abc")
        commentRegex = "@ApiParam\\(\\s*value\\s*=\\s*(\\\"[^\\\"]*\\\")\\s*\\)";
        regexResult = "@ApiParam(value = $1,example = \"参数示例\")";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);

        //2、修复@ApiParam("abc")
        commentRegex = "@ApiParam\\(\\s*(\\\"[^\\\"]+\\\")\\s*\\)";
        regexResult = "@ApiParam(value = $1,example = \"参数示例\")";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);

        //3、修复@ApiParam("")
        commentRegex = "@ApiParam\\(\\s*(\\\"[^\\\"]*\\\")\\s*\\)";
        regexResult = "@ApiParam(value = \"请求参数\",example = \"参数示例\")";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);
        result = result.trim();

        writeFile(result,file);
    }
}