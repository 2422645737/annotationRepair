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

        //匹配包含注释的属性
        String commentRegex = "";
        //Files.lines(Paths.get("E:\\Project\\ideaPro\\SourceCode\\src\\main\\resources\\regexStr")).collect(Collectors.joining(System.lineSeparator()));
        //属性替换原则
        String regexResult = "$1\n\t@ApiModelProperty(value = \"$2\")\n\tprivate";
        Pattern pattern = Pattern.compile(commentRegex);
        Matcher matcher = pattern.matcher(newContent.toString());
        String result = matcher.replaceAll(regexResult);
        result = result.trim();


        writeFile(result,file);
    }
}
