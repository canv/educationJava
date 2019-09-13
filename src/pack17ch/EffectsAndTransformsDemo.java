package pack17ch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class EffectsAndTransformsDemo extends Application {

    private double angle = 0.0;
    private double scaleFactor = 0.4;
    private double blurVal = 1.0;

    private Reflection reflection = new Reflection();
    private BoxBlur blur = new BoxBlur(1, 1, 1);
    private Rotate rotate = new Rotate();
    private Scale scale = new Scale(scaleFactor, scaleFactor);

    private Button buttonRotate = new Button("Rotate");
    private Button buttonBlur = new Button("Blur");
    private Button buttonScale = new Button("Scale");

    private Label reflect = new Label("Reflection adds visual sparkle");

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Effects demo");

        FlowPane rootNode = new FlowPane(20, 20);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 120);

        myStage.setScene(myScene);

        buttonRotate.getTransforms().add(rotate);
        buttonScale.getTransforms().add(scale);

        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        reflect.setEffect(reflection);

        buttonRotate.setOnAction(event -> {
            angle += 15.0;
            rotate.setAngle(angle);
            rotate.setPivotX(buttonRotate.getWidth() / 2);
            rotate.setPivotY(buttonRotate.getHeight() / 2);
        });

        buttonScale.setOnAction(event -> {
            scaleFactor += 0.1;
            if(scaleFactor>2.0)scaleFactor = 0.4;

            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });

        buttonBlur.setOnAction(event -> {
            if(blurVal==10.0) {
                blurVal = 1.0;
                buttonBlur.setEffect(null);
                buttonBlur.setText("Blur off");
            }else {
                blurVal++;
                buttonBlur.setEffect(blur);
                buttonBlur.setText("Blur on");
            }
            blur.setWidth(blurVal);
            blur.setHeight(blurVal);
        });

        rootNode.getChildren()
                .addAll(buttonRotate,buttonScale,buttonBlur,reflect);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}