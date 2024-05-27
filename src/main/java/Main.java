import enums.RepairEnum;
import factory.RepairStrategyFactory;
import utils.FileTypeUtil;

import java.io.*;



public class Main {
    public static void main(String[] args) throws IOException {
//        String path = "E:\\Project\\ideaPro\\msun-his-app-mzemr\\msun-his-app-mzemr-server\\src\\main\\java\\com\\msun\\his\\app\\mzemr\\server";
        String path = "C:\\Users\\24226\\Desktop\\test\\folder0";
        getFiles(path);

    }
    private static void getFiles(String path){
        File file = new File(path);
        if(file.isDirectory()){
            //获取文件夹下所有文件
            File[] files = file.listFiles();
            assert files != null;
            for (File f : files) {
                if(f.isDirectory()){
                    getFiles(f.getPath());
                }else{
                    processFile(f);
                }
            }
        }else{
            processFile(file);
        }
    }

    private static void processFile(File file){
        if(FileTypeUtil.isDTOorVO(file.getName())){
            //处理ApiModel注解
            RepairStrategyFactory.build(RepairEnum.API_MODEL).repair(file);

            //处理ApiModelProperty属性
            RepairStrategyFactory.build(RepairEnum.API_MODEL_PROPERTY).repair(file);
        }

        //处理Controller对象
        if(FileTypeUtil.isController(file.getName())){
            //处理ApiParam注解
            RepairStrategyFactory.build(RepairEnum.API_PARAM).repair(file);
        }
    }


}