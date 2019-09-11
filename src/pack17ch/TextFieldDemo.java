package pack17ch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {
    private TextField textField;
    private Label response;

    @Override
    public void start(Stage stage){
        stage.setTitle("Text field demo");

        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);

        Scene firstScene = new Scene(rootNode, 230, 140);

        stage.setScene(firstScene);
        response = new Label("Enter Name: ");

        Button buttonGetText = new Button("Get Name");

        textField = new TextField();
        textField.setPromptText("Enter a name there");
        textField.setPrefColumnCount(15);
        textField.setOnAction((ae)->
                response.setText("EnterPressed. Name is: " +
                        textField.getText()));

        buttonGetText.setOnAction((ae)->
                response.setText("Button pressed. Name is: " +
                        textField));
        Separator separator = new Separator();
        separator.setPrefWidth(180);

        rootNode.getChildren()
                .addAll(textField,buttonGetText,separator,response);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
