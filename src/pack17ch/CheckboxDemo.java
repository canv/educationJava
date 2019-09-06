package pack17ch;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CheckboxDemo extends Application {

    private CheckBox cbSmartphone;
    private CheckBox cbTablet;
    private CheckBox cbDesktop;
    private CheckBox cbNotebook;

    private Label response;
    private Label selected;

    @Override
    public void start(Stage stage){

        stage.setTitle("Check Boxes demo");
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
        rootNode.setAlignment(Pos.CENTER);

        Scene firstScene = new Scene(rootNode, 310, 200);
        stage.setScene(firstScene);

        Label heading = new Label("What Computers do tou own?");

        response = new Label("");
        selected = new Label("");

        cbSmartphone = new CheckBox("Smartphone");
        cbTablet = new CheckBox("Tablet");
        cbDesktop = new CheckBox("Desktop");
        cbNotebook = new CheckBox("Notebook");

        cbSmartphone.setOnAction(event -> {
            if(cbSmartphone.isSelected())response.setText("Smartphone was selected");
            else response.setText("Smartphone was cleared");
            showAll();
        });
        cbTablet.setOnAction(event -> {
            if(cbTablet.isSelected())response.setText("Tablet was selected");
            else response.setText("Tablet was cleared");
            showAll();
        });
        cbDesktop.setOnAction(event -> {
            if(cbDesktop.isSelected())response.setText("Desktop was selected");
            else response.setText("Desktop was cleared");
            showAll();
        });
        cbNotebook.setOnAction(event -> {
            if(cbNotebook.isSelected())response.setText("Notebook was selected");
            else response.setText("Notebook was cleared");
            showAll();
        });

        rootNode.getChildren().addAll(heading,cbSmartphone,
                cbTablet,cbNotebook,cbDesktop,response,selected);

        stage.show();
        showAll();
    }

    private void showAll() {
        String computers = "";
        if (cbSmartphone.isSelected()) computers = "Smartphone ";
        if (cbTablet.isSelected()) computers += "Tablet ";
        if (cbDesktop.isSelected()) computers += "Desktop ";
        if (cbNotebook.isSelected()) computers += "Notebook ";
        selected.setText("Computers selected: " + computers);
    }

    public static void main(String[] args) {
        launch(args);
    }
}