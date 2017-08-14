package puzzle;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Thread.sleep;

public class puzzleFrame extends Application {

    Thread runner;
    GridPane root;
    Scene scene;
    String[] inputStrings;
    String startString;

    Stage primaryStage;

    StackPane[] stackPanes;
    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.root = new GridPane();
        //root.getChildren().add(btn);

        this.scene = new Scene(root, 300, 300);

        primaryStage.setTitle("8 Puzzle");
        primaryStage.setScene(scene);

        this.startString = "1348627_5";

        draw(this.startString);


        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Solver solver = new Solver();

        inputStrings = solver.solve();


        //animate_solution();

        this.change("12345678_", "12345_786");

        this.primaryStage.show();

    }

    public void change(String newPosition, String oldPosition){
        boolean foundFirst = false;
        int firstPos, secondPos;
        firstPos = 0;
        secondPos = 0;
        for(int i = 0; i < newPosition.length(); i++){
            if(newPosition.charAt(i) != oldPosition.charAt(i)){
                if(!foundFirst){
                    firstPos = i;
                } else{
                    secondPos = i;
                }
            }
        }

        System.out.println("Moving block " + firstPos + " to " + secondPos);
        Path path = new Path();
        path.getElements().add(new MoveTo(secondPos * 100,secondPos % 3 * 100));
        //path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        //path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(this.stackPanes[firstPos]);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

    }

    public void animate_solution(){
        for(int i = 0; i < this.inputStrings.length; i++){
            draw(this.inputStrings[i]);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw (String inputString){
        Rectangle[] rectangles = new Rectangle[9];

        stackPanes = new StackPane[9];

        System.out.println("Attempting to draw: " + inputString);

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++) {
                rectangles[i+j] = new Rectangle(0, 0, 100, 100);

                String symbol = String.valueOf(inputString.charAt(3 * i + j));


                Text text;

                if(symbol.matches("_")){
                    rectangles[i+j].setFill(Color.DARKGRAY);
                    text = new Text("");
                } else{
                    if (i % 2 == 0) {
                        if(j % 2 == 0){
                            rectangles[i+j].setFill(Color.LIGHTBLUE);
                        } else{
                            rectangles[i+j].setFill(Color.LIGHTGRAY);
                        }
                    } else {
                        if(j % 2 == 0){
                            rectangles[i+j].setFill(Color.LIGHTGRAY);
                        } else{
                            rectangles[i+j].setFill(Color.LIGHTBLUE);
                        }
                    }
                    text = new Text(symbol);
                }
                text.setFont(Font.font("Arial", 20));

                //Set rectangle border colour
                rectangles[i+j].setStroke(Color.DARKGRAY);

                //Add text and rectangle to stack
                StackPane stack = new StackPane();
                stack.getChildren().addAll(rectangles[i+j], text);

                stackPanes[i+j] = stack;

                System.out.println("Placing block at: " + rectangles[i+j].getX() +"x, "+ rectangles[i+j].getY() + "y.");
                this.root.add(stackPanes[i+j], j, i);
                this.root.requestLayout();
            }
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
