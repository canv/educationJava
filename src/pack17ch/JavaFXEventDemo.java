package pack17ch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXEventDemo extends Application {
    private Label response;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Use JavaFX Buttons and Events");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);

        Scene firstScene = new Scene(rootNode,300,100);
        primaryStage.setScene(firstScene);
        response =  new Label("Push a Button");

        Button buttonUp = new Button("Up");
        Button buttonDown = new Button("Down");

        buttonUp.setOnAction(event -> response.setText("You pressed Up."));

        buttonDown.setOnAction(event -> response.setText("You pressed Down."));

        rootNode.getChildren().addAll(buttonUp,buttonDown,response);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
