import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    private static int current = 0;
    private static int apiModelPropertyCount = 0;
    public static void main(String[] args) throws IOException {
//        String path = "E:\\Project\\ideaPro\\msun-his-app-mzemr\\msun-his-app-mzemr-server\\src\\main\\java\\com\\msun\\his\\app\\mzemr\\server";
        String path = "C:\\Users\\24226\\Desktop\\test\\folder0";
        getFiles(path);
        System.out.println("处理文件总数：" + current);

    }
    private static void getFiles(String path) throws IOException {
        File file = new File(path);
        if(file.isDirectory()){
            //获取文件夹下所有文件
            File[] files = file.listFiles();
            for (File f : files) {
                if(f.isDirectory()){
                    getFiles(f.getPath());
                }else{
                    //处理文件
                    processFile(f);
                }
            }
        }else{
            processFile(file);
        }
    }

    private static void processFile(File file) throws IOException {
        if(isDTOorVO(file.getName())){
            //对于DTO VO对象增加ApiModel注解
//            addApiModel(file);
            //添加ApiModelProperty属性
            addApiModelProperty(file);
        }


        //处理Controller对象
        if(isController(file.getName())){
            //给所有方法增加@Api
        }
    }

    private static void addApiParam(File f) throws IOException {
        //读取文件内容
        String content = Files.lines(Paths.get(f.getAbsolutePath())).collect(Collectors.joining(System.lineSeparator()));
        //匹配出所有属性字段
        String regex = "(private|protected|public)?\\s+([a-z]|[A-Z]|>|<)+\\s+([a-z]|[A-Z])+\\s*;";

//        Files.write(Paths.get(f.getAbsolutePath()),newContent.toString().getBytes(StandardCharsets.UTF_8));
    }

    private static void addApiModelProperty(File f) throws IOException {
        System.out.println(apiModelPropertyCount++ + ": 当前处理的文件---" + f.getAbsolutePath());
        //读取文件内容
        String content = Files.lines(Paths.get(f.getAbsolutePath())).collect(Collectors.joining(System.lineSeparator()));

        StringBuffer newContent = new StringBuffer(content);

        if(!content.contains("io.swagger.annotations.ApiModelProperty")){
            //如果不包含该注解，则首先导入依赖
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiModelProperty;\n");
        }

        //匹配包含注释的属性

        String commentRegex = Files.lines(Paths.get("E:\\Project\\ideaPro\\SourceCode\\src\\main\\resources\\regexStr")).collect(Collectors.joining(System.lineSeparator()));
        //属性替换原则
        String regexResult = "$1\n\t@ApiModelProperty(value = \"$2\")\n\tprivate";
        Pattern pattern = Pattern.compile(commentRegex);
        Matcher matcher = pattern.matcher(newContent.toString());
        String result = matcher.replaceAll(regexResult);
        result = result.trim();
        Files.write(Paths.get(f.getAbsolutePath()),result.getBytes(StandardCharsets.UTF_8));
    }
    /**
     * 为所有DTO VO对象增加@ApiModel属性
     * @param
     */
    private static void addApiModel(File f) throws IOException {
        //读取文件内容，并实现@ApiModel添加
        String content = Files.lines(Paths.get(f.getAbsolutePath())).collect(Collectors.joining(System.lineSeparator()));

        if(!content.contains("@ApiModel(")){
            System.out.println(current++ + ": 当前处理的文件---" + f.getAbsolutePath());

            //如果不存在@ApiModel注解，则新增注解
            StringBuffer newContent = new StringBuffer(content);

            //导入相关依赖
            int indexOfImport = newContent.indexOf("import");
            newContent.insert(indexOfImport,"import io.swagger.annotations.ApiModel;\n");

            String fill = isDTO(f.getName()) ? "参数DTO" : "参数VO";

            //添加注解
            int index = newContent.indexOf("public class ");
            newContent.insert(index ,"@ApiModel(description = \"" + fill + "\")\n");

            Files.write(Paths.get(f.getAbsolutePath()),newContent.toString().getBytes(StandardCharsets.UTF_8));
        }

    }

    private static boolean isVO(String fileName){
        return isJavaFile(fileName) && (fileName.contains("VO.java") || fileName.contains("Vo.java") );
    }
    private static boolean isDTO(String fileName){
        return isJavaFile(fileName) && (fileName.contains("DTO.java") || fileName.contains("Dto.java"));
    }
    private static boolean isDTOorVO(String fileName){
        return isVO(fileName) || isDTO(fileName);
    }
    private static boolean isJavaFile(String fileName){
        return fileName.contains(".java");
    }
    private static boolean isController(String fileName){
        return isJavaFile(fileName) && fileName.contains("Controller");
    }
}