import java.util.*;
import javax.swing.*;

public class Trash{

    // Instance Fields
    private int imageNumber;
    private String imageName;

    // Constructor
    public Trash(int imageNumber, String imageName){
        this.imageNumber = imageNumber;
        this.imageName = imageName;
    }

    // Accesors
    public int getImageNumber(){
        return imageNumber;
    }

    public String getImageName(){
        return imageName;
    }

    // Mutators
    public void setImageNumber(int imageNumber){
        this.imageNumber = imageNumber;
    }   

    public void setImageName(int imageName){
        this.imageName = imageName;
    }   


}