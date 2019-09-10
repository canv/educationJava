package pack17ch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

    private Label response;

    @Override
    public void start(Stage stage){
        stage.setTitle("List view demo");

        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        Scene firstScene = new Scene(rootNode,200,120);
        stage.setScene(firstScene);
        response = new Label("Select computer type");

        ObservableList<String> computerTypes =
                FXCollections.observableArrayList
                       ("Smartphone",
                                "Tablet",
                                "Notebook",
                                "Desktop");
        ListView<String> lvComputers = new ListView<>(computerTypes);

        lvComputers.setPrefSize(100,70);

        MultipleSelectionModel<String> lvSelModel =
                lvComputers.getSelectionModel();

        lvSelModel.selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                        -> response.setText("Computer selected is " + newValue)
        );

        rootNode.getChildren().addAll(lvComputers,response);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}