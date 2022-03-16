/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingProject;
import javafx.application.Application;

import javafx.scene.Scene;


import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

/**
 *
 * @author Grant
 */
public class CreateCanvas {
    Scene Startingscene;
    double width;
    double height;
    Stage CanvasStage = new Stage();
    public CreateCanvas(double parawidth, double paraheight){//this class should be used to make the canvas in paintingproject
        width = parawidth;
        height = paraheight;
        ShowCanvas();
    }
    public void ShowCanvas(){//attempted to use this to make new scene. it failed. Will attempt again.
        TextField Textheight = new TextField();
   TextField TextWidth = new TextField();
   Label HeightDescribe = new Label("Please enter height");
   Label WidthDescribe = new Label("Please enter width");
   Label Nothing = new Label("");
   Button B = new Button("Make Canvas");
   GridPane root = new GridPane();
   root.addColumn(0, HeightDescribe,Textheight);
   root.addColumn(1, WidthDescribe, TextWidth);
   root.addColumn(2,Nothing, B);
   Group StartingGroup = new Group(root);
   Startingscene = new Scene(StartingGroup,width,height);
   CanvasStage.setScene(Startingscene);
   CanvasStage.setTitle("Hello there");
  
    }
    public Stage getStage(){
        return CanvasStage;
    }
    
}
