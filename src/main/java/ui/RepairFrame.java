package ui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import enums.RepairEnum;
import enums.TranslateConst;
import factory.RepairStrategyFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.apache.commons.lang3.StringUtils;
import translate.TransApi;
import utils.FileTypeUtil;

public class RepairFrame {
    @FXML
    private CheckBox checkApiOperation;
    @FXML
    private TextArea logArea;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button selectButton;
    @FXML
    private CheckBox checkApiModel;

    @FXML
    private CheckBox checkApiModelProperty;
    @FXML
    private CheckBox checkTranslate;
    @FXML
    private CheckBox checkApiParam;
    @FXML
    private TextField dirLocaltion;
    private Integer count;

    private TransApi api;
    @FXML
    void initialize() {
        this.logArea.setText("");
    }

    @FXML
    void repair(MouseEvent event) {
        //清空控制台
        this.logArea.setText("");
        this.count = 0;

        if(StringUtils.isEmpty(this.dirLocaltion.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("提示");
            alert.setContentText("请指定路径");
            alert.showAndWait();
        }
        getFiles(this.dirLocaltion.getText());
    }

    @FXML
    void selectFile(MouseEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("打开文件夹");
        File file = directoryChooser.showDialog(null);
        if(null != file){
            this.dirLocaltion.setText(file.getAbsolutePath());
            this.dirLocaltion.setEditable(true);
        }

    }

    /**
     * 递归处理文件
     * @param path
     */
    private void getFiles(String path){
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

    /**
     * 文件处理
     * @param file
     */
    private void processFile(File file){
        this.logArea.appendText(++count + " - 当前扫描的文件：" + file.getAbsolutePath() + "\n");
        //非java文件直接跳过
        if(!FileTypeUtil.isJavaFile(file.getName())){
            return;
        }
        //处理DTO和VO对象
        if(FileTypeUtil.isDTOorVO(file.getName())){
            if(checkApiModel.isSelected()){
                //处理ApiModel注解
                RepairStrategyFactory.build(RepairEnum.API_MODEL).repair(file);
            }
            if(checkApiModelProperty.isSelected()){
                //处理ApiModelProperty属性
                RepairStrategyFactory.build(RepairEnum.API_MODEL_PROPERTY).repair(file);
            }
        }

        //处理Controller对象/API对象
        if(FileTypeUtil.isController(file.getName()) || FileTypeUtil.isAPI(file.getName())){
            if(checkApiParam.isSelected()){
                //处理ApiParam注解
                RepairStrategyFactory.build(RepairEnum.API_PARAM).repair(file);
            }
            if(checkApiOperation.isSelected()){
                //处理ApiOperation注解
                RepairStrategyFactory.build(RepairEnum.API_OPERATION).repair(file);
            }
        }
    }

}