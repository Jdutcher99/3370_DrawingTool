/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingProject;

import java.io.IOException;

import javax.sound.sampled.SourceDataLine;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.shape.*;


/**
 *
 * @author Grant
 */
public class PaintingProject extends Application {//this page should be the first thing the user sees. Planning to have some sort of login first, but createcanvas will be first for now
   CreateCanvas newCanvas;
   Button LoginAttempt = new Button("Log in");
   TextField enteredusername = new TextField();
           TextField enteredpassword = new TextField();
    @Override
    public void start(Stage primaryStage) {
        try {
            Stage CanvasStage = new Stage();
            Stage LoginStage = new Stage();
           
            TextField Textheight = new TextField();
            TextField TextWidth = new TextField();
            Label HeightDescribe = new Label("Please enter height");
            Label WidthDescribe = new Label("Please enter width");//from 38 to 76 it's a whole lot of visuals and giving it life.
            
           
            Button B = new Button("Make Canvas");
            GridPane root = new GridPane();//hint: you can add buttons to represent pics
            StackPane pane = new StackPane();
            root.addColumn(0, HeightDescribe,Textheight);
            root.addColumn(1, WidthDescribe, TextWidth);
            root.addColumn(2, B);
              Group StartingGroup = new Group(pane);
            Scene StartingScene = new Scene(StartingGroup,600,200);
         
               pane.getChildren().add(root);
           
            primaryStage.setScene(StartingScene);
            primaryStage.setTitle("Time to draw");
            primaryStage.show();
           

          enteredusername = new TextField();
          enteredpassword = new TextField();
          
          Label Username = new Label("Username");
          Label Password = new Label("Password");
          LoginAttempt = new Button("Log in");
         
          
         
          root.add(Username,0,2);
          root.add(enteredusername,0,3);
          root.add(Password,1,2);
          root.add(enteredpassword,1,3);
          root.add(LoginAttempt,2,3);
            
          
            LoginAttempt.setOnAction(e->{//when you click this button, logincheck to see if you've entered correctly
            boolean loginattempt = false;
             try {
             
              loginattempt =LoginCheck(enteredusername,enteredpassword);
              
            } catch (IOException e1) {
             
              e1.printStackTrace();
            }
             Result(root,loginattempt);
            
            }
            );

            B.setOnAction(e->{
            SetupCanvas(Textheight,TextWidth);//when you click this button, this sets up the actual canvas based on what you wrote in
            CanvasStage.setScene(newCanvas.getScene());
            CanvasStage.setTitle("A new Canvas!");
            CanvasStage.show();
            }
            );
           
            
            
              
   
 
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
       
       TexttoDouble Translation = new TexttoDouble(fieldwidth, fieldheight);
       newCanvas = new CreateCanvas(Translation.getwidth(),Translation.getheight());
       
    }
   
    public boolean LoginCheck(TextField user, TextField pass) throws IOException{

CheckUserPass Checking = new CheckUserPass(user,pass);

return Checking.getAnswer();
    }
    public void Result(GridPane pararoot,boolean flag){
     
Label LoginSuccess = new Label("You are worthy");//prints out whether the login was successful or not.
Label LoginFailure = new Label("You are unworthy");
Rectangle R = new Rectangle();
R.setX(0);
R.setX(0);
R.setWidth(150);
R.setHeight(20);
R.setFill(Color.RED);
pararoot.add(R,0,5);
if(flag){
pararoot.add(LoginSuccess,0,5);//this should do something else when login is successful, what's the point of a log in?
}else{
  pararoot.add(LoginFailure,0,5);
}
    }
}
