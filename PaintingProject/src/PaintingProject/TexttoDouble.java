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
public class TexttoDouble {
    double width;
    double height;
    public TexttoDouble(TextField widthfield, TextField heightfield){//this class translate the strings you'ved entered from the GUI into doubles
       this.width =  Double.parseDouble(widthfield.getText());
       this.height = Double.parseDouble(heightfield.getText());
   }
    public double getwidth(){
        return width;
    }
    public double getheight(){
        return height;
    }
    
    
    
    
}
