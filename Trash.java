import java.util.*;
import javax.swing.*;

public class Trash{

    // Instance Fields
    private int imageNumber;
    private String imageName;

    // Constructor
    public Trash (int imageNumber, String imageName){
        this.imageNumber = imageNumber;
        this.imageName = imageName;
    }

    // Accesor Methods
    public int getImageNumber(){
        return imageNumber;
    }

    public String getImageName(){
        return imageName;
    }

    // Mutator Methods
    public void setImageNumber(int imageNumber){
        this.imageNumber = imageNumber;
    }   

    public void setImageName(String imageName){
        this.imageName = imageName;
    }   
}
