package impl;

import entity.AbstractRegexMatcher;
import interfaces.RepairStrategy;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApiModelPropertyRepairStrategy extends AbstractRegexMatcher implements RepairStrategy {

    public ApiModelPropertyRepairStrategy(String pattern) {
        super(pattern);
    }

    @Override
    public void repair(File file) {
        //读取文件内容
        StringBuffer newContent = new StringBuffer(readFile(file));

        //如果当前文件中没有依赖，则首先添加依赖
        if(newContent.indexOf("io.swagger.annotations.ApiModelProperty") == -1){
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiModelProperty;\n");
        }
        writeFile(replace(newContent.toString()),file);
    }
}