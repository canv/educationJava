package pack17ch;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;

class JavaFXSkel extends Application {
    public static void main(String[] args) {
        System.out.println("start JavaFX app");
        launch(args);
    }

    @Override
    public void init(){
        System.out.println("in init() body");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("in start() body");

        primaryStage.setTitle("JavaFX frame");
        FlowPane rootNode = new FlowPane();
        Scene myScene = new Scene(rootNode,300,200);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }

    @Override
    public void stop(){
        System.out.println("in stop() body");
    }
}