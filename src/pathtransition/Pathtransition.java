
package pathtransition;


import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Pathtransition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 250);
        
        
        // Creo el circulo y el rectangulo
        Circle circulo = new Circle(130, 100, 50, Color.web("WHITE", 0));
        circulo.setStroke(Color.web("black", 1));
        Rectangle rectangulo = new Rectangle(8,16);
        rectangulo.setFill(Color.BLUE);
        
        // Los añado al panel
        pane.getChildren().add(circulo);
        pane.getChildren().add(rectangulo);
        
        // Creo el path
        PathTransition pathAnimation = new javafx.animation.PathTransition(Duration.millis(4000), circulo, rectangulo);
        pathAnimation.setOrientation(javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathAnimation.setCycleCount(Timeline.INDEFINITE);
        pathAnimation.setInterpolator(Interpolator.LINEAR);
        pathAnimation.play();
        
        // EVENTOS
        pane.setOnMousePressed(event ->{
            
            pathAnimation.pause();
        });
        
        pane.setOnMouseReleased(event -> {
            
            pathAnimation.play();
        });
        
        primaryStage.setTitle("PathTransition in Aniation.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}
