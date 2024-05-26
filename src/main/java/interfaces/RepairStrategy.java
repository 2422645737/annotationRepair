package interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public interface RepairStrategy {
    /**
     * 修复方法
     */
    void repair(File file);

    /**
     * 读取文件内容
     * @param file
     * @return
     */
    default String readFile(File file){
        //读取文件内容
        try {
            return Files.lines(Paths.get(file.getAbsolutePath())).collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取文件内容
     * @param file
     * @return
     */
    default void writeFile(String content,File file){
        //读取文件内容
        try {
            Files.write(Paths.get(file.getAbsolutePath()),content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
