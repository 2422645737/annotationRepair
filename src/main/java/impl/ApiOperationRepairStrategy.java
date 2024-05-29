package impl;

import entity.AbstractRegexMatcher;
import interfaces.RepairStrategy;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiOperationRepairStrategy extends AbstractRegexMatcher implements RepairStrategy {
    public ApiOperationRepairStrategy(String pattern) {
        super(pattern);
    }

    @Override
    public void repair(File file) {
        //读取文件内容
        StringBuffer newContent = new StringBuffer(readFile(file));
        //如果不存在，首先添加依赖
        if(newContent.indexOf("import io.swagger.annotations.ApiOperation;") == -1){
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiOperation;\n");
        }
        writeFile(replace(newContent.toString()),file);
    }
}