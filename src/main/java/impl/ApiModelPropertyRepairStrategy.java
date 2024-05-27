package impl;

import interfaces.RepairStrategy;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApiModelPropertyRepairStrategy implements RepairStrategy {

    @Override
    public void repair(File file) {
        System.out.println( "当前处理的文件---" + file.getAbsolutePath());
        //读取文件内容
        String content = readFile(file);

        //转换为可编辑的StringBuffer
        StringBuffer newContent = new StringBuffer(content);

        //如果当前文件中没有依赖，则首先添加依赖
        if(!content.contains("io.swagger.annotations.ApiModelProperty")){
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiModelProperty;\n");
        }

        //处理没有ApiModelProperty注解的情况（有/**/标准注释）
        String commentRegex = "(\\/\\*\\*\\r\\n\\s*\\*([^\\r\\n]*)\\r\\n\\s*\\*\\/)\\r\\n\\s*private";
        String regexResult = "$1\r\n\t@ApiModelProperty(value = \"$2\")\r\n\tprivate";
        Pattern pattern = Pattern.compile(commentRegex);
        Matcher matcher = pattern.matcher(newContent.toString());
        String result = matcher.replaceAll(regexResult);
        result = result.trim();

        //处理ApiModelProperty(hidden = true)的情况（有/**/注释）
        commentRegex = "(\\/\\*\\*\\r\\n\\s*\\*([^\\r\\n]*)\\r\\n\\s*\\*\\/)\\r\\n\\s*@ApiModelProperty\\(hidden\\s=\\strue\\)";
        regexResult = "$1\n\t@ApiModelProperty(value = \"$2\",hidden = true)";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);
        result = result.trim();
        //处理ApiModelProperty(hidden = true)的情况（无/**/注释）
        commentRegex = "@ApiModelProperty\\(hidden\\s=\\strue\\)\\r\\n\\s*((private|protected|public)?\\s+([a-z]|[A-Z]|>|<)+\\s+(([a-z]|[A-Z])+)\\s*;)";
        regexResult = "@ApiModelProperty(value = \"$4\",hidden = true)\n\t$1";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);
        result = result.trim();

        writeFile(result,file);
    }
}
