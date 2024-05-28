package impl;

import interfaces.RepairStrategy;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiOperationRepairStrategy implements RepairStrategy {
    @Override
    public void repair(File file) {
        //读取文件内容
        String content = readFile(file);

        StringBuffer newContent = new StringBuffer(content);
        //如果不存在，首先添加依赖
        if(!content.contains("import io.swagger.annotations.ApiOperation;")){
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiOperation;\n");
        }

        //处理ApiOperation(value = "abc")数据
        String commentRegex = "@ApiOperation\\(\\s*\"([^\"]+)\"\\s*\\)";
        String regexResult = "@ApiOperation(value = \"$1\",notes = \"$1\")";
        Pattern pattern = Pattern.compile(commentRegex);
        Matcher matcher = pattern.matcher(newContent.toString());
        String result = matcher.replaceAll(regexResult);

        //处理@ApiOperation("abc")
        commentRegex = "@ApiOperation\\(value\\s*=\\s*(\"[^\"]*\")\\)";
        regexResult = "@ApiOperation(value = $1,notes = $1)";
        pattern = Pattern.compile(commentRegex);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll(regexResult);
        result = result.trim();

        //TODO: 处理ApiOperation缺失的情况

        writeFile(result,file);
    }
}