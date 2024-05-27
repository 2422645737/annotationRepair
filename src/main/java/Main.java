import enums.RepairEnum;
import factory.RepairStrategyFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.FileTypeUtil;

import java.io.*;
import java.util.Objects;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("RepairFrame.fxml")));
        primaryStage.setTitle("Java注解修复工具");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}