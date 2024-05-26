package impl;

import interfaces.RepairStrategy;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ApiParamRepairStrategy implements RepairStrategy {
    @Override
    public void repair(File file) {
        //读取文件内容
        String content = readFile(file);
        //匹配出所有属性字段
        String regex = "(private|protected|public)?\\s+([a-z]|[A-Z]|>|<)+\\s+([a-z]|[A-Z])+\\s*;";

//        Files.write(Paths.get(f.getAbsolutePath()),newContent.toString().getBytes(StandardCharsets.UTF_8));
    }
}
