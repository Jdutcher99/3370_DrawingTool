package PaintingProject;
import java.io.File;
import java.io.IOException;
import java.util.*;




import javafx.scene.paint.Color;



import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;

import javafx.scene.shape.*;
public class ArtLookUp {//first, this class looks at (name).txt to see the pngs that is associate with that name. Batman.txt has Joker, Bane, and Alfred, Lonehero for example
    String name;//second, the class prints out an Arraylist containing these names in front of the screen. Use a loop of labels for this.
    //lastly a TextField will appear infront of the user asking what png should be uploaded and a special createcanvas will make a canvas using the art's width and height as the canvas' width and height
    ArtLookUp(String paraName){
        name = paraName;
    }

public void SearchArt(GridPane ArtPane) throws IOException{
    String nextArt ="";
    ArrayList<String> List = new ArrayList<>();
    
    Scanner fileIn = new Scanner(new File("TextFolder/"+name+".txt"));
while(fileIn.hasNext()){
    nextArt = fileIn.nextLine();
    List.add(nextArt);
}

fileIn.close();
PrintArtArray(ArtPane, List);
}
private void PrintArtArray(GridPane ArtPane, ArrayList<String> ParaList){
 
   
   
    Label Hereitis = new Label("Here is your art:");
    


for(int i = 0; i < 16;i++){

    Rectangle R = new Rectangle();
    R.setX(0);
    R.setX(0);
    R.setWidth(100);
    R.setHeight(20);
    R.setFill(Color.WHITE);
    

    ArtPane.add(R, 3, i);
}
    
    

ArtPane.add(Hereitis, 3, 0);
for(int i = 0; i < ParaList.size();i++){
    
    Label PrintArt = new Label(ParaList.get(i));
    
    ArtPane.add(PrintArt, 3, i+1);
}
}
}
