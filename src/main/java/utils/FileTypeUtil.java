package utils;

public class FileTypeUtil {
    public static boolean isVO(String fileName){
        return isJavaFile(fileName) && (fileName.toLowerCase().contains("vo.java"));
    }
    public static boolean isDTO(String fileName){
        return isJavaFile(fileName) && (fileName.toLowerCase().contains("dto.java"));
    }
    public static boolean isDTOorVO(String fileName){
        return isVO(fileName) || isDTO(fileName);
    }
    public static boolean isJavaFile(String fileName){
        return fileName.contains(".java");
    }
    public static boolean isController(String fileName){
        return isJavaFile(fileName) && fileName.toLowerCase().contains("controller.java");
    }
    public static boolean isAPI(String fileName){
        return isJavaFile(fileName) && fileName.toLowerCase().contains("api.java");
    }
}
