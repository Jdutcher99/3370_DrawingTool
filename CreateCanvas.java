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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;




/**
 *
 * @author Grant
 */
public class CreateCanvas {
   private Scene StartingScene;
   private double width;
   private double height;
   private String Username;
   double Xstamp=0;
   double Ystamp=0;
   private String Art = "Nothing";
   Image ArtImage;
   
   double size;
    public CreateCanvas(double parawidth, double paraheight, String ArtID,String Name) throws IOException{//this class should be used to make the canvas in paintingproject
        if(ArtID.equals(Art)){
            width = parawidth;
            height = paraheight;
        }else{
            Art = ArtID;
            CreateFilledCanvas();
        }
        Username = Name;
        
        ShowCanvas();
    }
    
    private void ShowCanvas()throws IOException{//attempted to use this to make new scene. it failed. Will attempt again.
        Group StartingGroup;
        
        GridPane grid = new GridPane();
        StackPane pane = new StackPane();
        StartingGroup = new Group(pane, grid);
      
        Image StampImage = new Image(new FileInputStream("ArtFolder/paint2.png"));
        
        grid.setVgap(10);
        grid.setHgap(10);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.
                    SOLID, null, null)));
                
      //change size of brush textfield
        TextField bsText = new TextField();
        bsText.setText("Enter size value");
        Button sizeButt = new Button("Enter");
        grid.add(bsText, 0, 0);
        grid.add(sizeButt, 1, 0);
      
      //Color picker
        ColorPicker pick = new ColorPicker();
        grid.add(pick, 4, 0);
      

        StartingScene = new Scene(StartingGroup,width,height);
            Canvas canvas = new Canvas(width,height);//width of height of the actual canvas. Planning to call newCanvas into this.
            canvas.setTranslateY(50);
            GraphicsContext gc = canvas.getGraphicsContext2D();//this can be considered as the brush
            gc.setStroke(Color.BLACK);//sets the inital color of brush.
            gc.setLineWidth(1);//width of the brush
             
            //Changes size of brush
            sizeButt.setOnAction(e -> {
            size = Double.parseDouble(bsText.getText());
            ChangeBrushSize newBrush = new ChangeBrushSize(gc, size);
            });
            
            pick.setValue(Color.BLACK);
            pick.setOnAction(e-> {
                gc.setStroke(pick.getValue());
            });
      
             
             if(!Art.equals("Nothing")){//if we are setting an image as a background, we add it to pane to allow editing the image
                gc.drawImage(ArtImage,0,0);
               }


           StartingScene.setOnMousePressed(e->{
            
                 gc.beginPath();
                 gc.lineTo(e.getSceneX(),e.getSceneY() - 50);//when you click on the mouse, a black dot will appear at the scene coords (aka, where your mouse is at right now)
                 gc.stroke();
             });

             StartingScene.setOnMouseMoved(e->{
                Xstamp = e.getSceneX();
                Ystamp = e.getSceneY() - 50;
             });
             StartingScene.setOnKeyPressed(e ->{
                KeyCode Code = e.getCode();
                String CodeKey = Code.getName();
                if(CodeKey.equals("D")){
                   gc.drawImage(StampImage,Xstamp,Ystamp);
                }

             } );
            
             StartingScene.setOnMouseDragged(e->{
                 gc.lineTo(e.getSceneX(),e.getSceneY() - 50);//dragging the mouse makes lines
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