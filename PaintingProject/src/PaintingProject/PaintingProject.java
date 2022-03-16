/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingProject;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;


/**
 *
 * @author Grant
 */
public class PaintingProject extends Application {//this page should be the first thing the user sees. Planning to have some sort of login first, but createcanvas will be first for now
   CreateCanvas newCanvas;
    @Override
    public void start(Stage primaryStage) {
        try {
         
       
        
   TextField Textheight = new TextField();
   TextField TextWidth = new TextField();
   Label HeightDescribe = new Label("Please enter height");
   Label WidthDescribe = new Label("Please enter width");
   Label Nothing = new Label("");
   Button B = new Button("Make Canvas");
   GridPane root = new GridPane();
   StackPane pane = new StackPane();
   root.addColumn(0, HeightDescribe,Textheight);
   root.addColumn(1, WidthDescribe, TextWidth);
   root.addColumn(2,Nothing, B);
     Group StartingGroup = new Group(pane);
   Scene StartingScene = new Scene(StartingGroup,1000,700);
      Canvas canvas = new Canvas(800,500);//width of height of the actual canvas. Planning to call newCanvas into this.
        GraphicsContext gc = canvas.getGraphicsContext2D();//this can be considered as the brush
        gc.setStroke(Color.BLACK);//sets the inital color of brush.
        gc.setLineWidth(1);//width of the brush
        StartingScene.setOnMousePressed(e->{
            gc.beginPath();
            gc.lineTo(e.getSceneX(),e.getSceneY());//when you click on the mouse, a black dot will appear at the scene coords (aka, where your mouse is at right now)
            gc.stroke();
        });
        StartingScene.setOnMouseDragged(e->{
            gc.lineTo(e.getSceneX(),e.getSceneY());//dragging the mouse makes lines
            gc.stroke();
        });
        root.setTranslateY(600);//sets the position of the canvas - planning to make this newCanvas.getheight+100
        pane.getChildren().add(canvas);
      pane.getChildren().add(root);
  // Scene Controls = new Scene(root,200,200);
   primaryStage.setScene(StartingScene);
   primaryStage.setTitle("Enter your measurements");
   primaryStage.show();
   Stage CStage = new Stage();
 //  CStage.setScene(Controls);
 //  CStage.setTitle("Controls");
 //  CStage.show();
   B.setOnAction(e->SetupCanvas(Textheight,TextWidth));
        }catch(Exception e){
            e.printStackTrace();
        }
        
   
   
   
   
   
   
        
        
  
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    public void SetupCanvas(TextField fieldwidth, TextField fieldheight){
        Stage StageCanvas;
        Scene ShowCanvas;
       TexttoDouble Translation = new TexttoDouble(fieldwidth, fieldheight);
       newCanvas = new CreateCanvas(Translation.getwidth(),Translation.getheight());
       
        
        
    }
}
