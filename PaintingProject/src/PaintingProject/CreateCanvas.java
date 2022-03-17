/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingProject;


import javafx.scene.Scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
//import javafx.scene.text.Text;
//import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;



/**
 *
 * @author Grant
 */
public class CreateCanvas {
   private Scene StartingScene;
   private double width;
   private double height;
    public CreateCanvas(double parawidth, double paraheight){//this class should be used to make the canvas in paintingproject
        width = parawidth;
        height = paraheight;
        ShowCanvas();
    }
    private void ShowCanvas(){//attempted to use this to make new scene. it failed. Will attempt again.
       
        
        
  
        StackPane pane = new StackPane();
       
          Group StartingGroup = new Group(pane);
         StartingScene = new Scene(StartingGroup,width,height);
           Canvas canvas = new Canvas(width,height);//width of height of the actual canvas. Planning to call newCanvas into this.
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
             
             
         
             pane.getChildren().add(canvas);
         //  pane.getChildren().add(root);
        
        
  
    }
    public Scene getScene(){
        return StartingScene;
    }
    
}
