/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingProject;


import javafx.scene.Scene;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
   private String Art = "Nothing";
   Image ArtImage;
    public CreateCanvas(double parawidth, double paraheight, String ArtID) throws IOException{//this class should be used to make the canvas in paintingproject
        if(ArtID.equals(Art)){
            width = parawidth;
            height = paraheight;
        }else{
            Art = ArtID;
            CreateFilledCanvas();
        }
        
        
        ShowCanvas();
    }
    private void ShowCanvas(){//attempted to use this to make new scene. it failed. Will attempt again.
        Group StartingGroup;
        ImageView Viewing;
        StackPane pane = new StackPane();
        StartingGroup = new Group(pane);
       if(!Art.equals("Nothing")){//if we are setting an image as a background, we add it to pane to allow editing the image
        Viewing = new ImageView(ArtImage);
        pane.getChildren().add(Viewing);
       }
        
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
    private void CreateFilledCanvas() throws IOException{
        ArtImage = new Image(new FileInputStream("ArtFolder/"+Art+".png"));//this makes the ArtID into an IMG
        width = ArtImage.getWidth();//sets the canvas width/height based on ArtImage
        height= ArtImage.getHeight();


    }
    
}
