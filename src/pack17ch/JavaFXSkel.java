package pack17ch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import static packAlternative.AOutput.consoleOut;

class JavaFXSkel extends Application {
    public static void main(String[] args) {
        consoleOut.println("start JavaFX app");
    }

    @Override
    public void init(){
        consoleOut.println("in init() body");
    }

    @Override
    public void start(Stage primaryStage) {
        consoleOut.println("in start() body");

        primaryStage.setTitle("JavaFX frame");

        FlowPane rootNode = new FlowPane();
        Scene firstScene = new Scene(rootNode, 300, 200);
        primaryStage.setScene(firstScene);
        primaryStage.show();

    }

    @Override
    public void stop(){
        consoleOut.println("in stop() body");
    }
}