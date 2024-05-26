package utils;

public class FileTypeUtil {
    public static boolean isVO(String fileName){
        return isJavaFile(fileName) && (fileName.contains("VO.java") || fileName.contains("Vo.java") );
    }
    public static boolean isDTO(String fileName){
        return isJavaFile(fileName) && (fileName.contains("DTO.java") || fileName.contains("Dto.java"));
    }
    public static boolean isDTOorVO(String fileName){
        return isVO(fileName) || isDTO(fileName);
    }
    public static boolean isJavaFile(String fileName){
        return fileName.contains(".java");
    }
    public static boolean isController(String fileName){
        return isJavaFile(fileName) && fileName.contains("Controller");
    }
}
