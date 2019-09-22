package pack17ch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HomeWork1 extends Application {
    private Label response;

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Use JavaFX Buttons and Events");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);

        Scene firstScene = new Scene(rootNode,300,100);
        primaryStage.setScene(firstScene);
        response =  new Label("Push a Button");

        Button buttonRun = new Button("Run");
        Button buttonExit = new Button("Exit");

        buttonRun.setOnAction(event -> response.setText("Yeeeey! Go more!"));

        buttonExit.setOnAction(event -> Platform.exit());

        rootNode.getChildren().addAll(buttonRun,buttonExit,response);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
