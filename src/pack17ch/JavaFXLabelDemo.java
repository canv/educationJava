package pack17ch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXLabelDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Use a JavaFX Label");
        FlowPane rootNode = new FlowPane();
        Scene firstScene = new Scene(rootNode,300,200);
        primaryStage.setScene(firstScene);

        Label myLabel = new Label("JavaFX is work");
        rootNode.getChildren().add(myLabel);

        primaryStage.show();
    }
}
