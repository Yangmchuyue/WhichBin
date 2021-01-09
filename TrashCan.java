import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.util.Random;

public class TrashCan extends JPanel{
    // class fields
    private static int LEVEL1 = 15000;
    private static int LEVEL2 = 10000;
    private static int LEVEL3 = 5000;
    private static int LEVEL4 = 4000;
    private static int LEVEL5 = 3000;

    private static int MAX1 = 400;
    private static int MAX2 = 700;
    private static int MAX3 = 1000;
    private static int MAX4 = 15000; // change thses later.

    // instance fields
    // private Trash trash; // stores a Trash
    private Timer timer;
    private TimerTask timerTask;
    private Random random;
    private int randomNumber;
    private int stop;

    public static void main (String[] arguments) {
        TrashCan trashcan = new TrashCan();
        trashcan.getRandomNumber();
    }

    public TrashCan() {
        super();
        random = new Random();
        randomNumber = 0;
        timer = new Timer();
        stop = LEVEL1;
        timerTask = new TimerTask() {
            public void run() {
                System.out.println ("Game Over!");} // REPLACE THIS WITH JOPTION PANEL
            };
        }
        // trash =  newTrash(1, "image name"); // REPLACE THIS

    // start
    public void startLevel() {
        setRandomNumber();
        // [display image here]
        setTime();
        startTimer();
    }


    // end -> called by Gracie

    // Random Number
    public int getRandomNumber(){
        return randomNumber;
    }

    public void setRandomNumber() {
        randomNumber = random.nextInt(49);
    }

    // Timer
    public void startTimer(){
        timer.schedule(timerTask, stop);
    }

    public void endTimer(){
        timer.cancel();
    }

    // Milliseconds
    // sets the time the player has (and the overall time)
    public void setTime() {
        // int score = Scoreboard.getScore();
        int score = 500;
        if (score < MAX1 ) {
            System.out.println ("less than max1");
            stop = LEVEL1;
        }
        else if (score < MAX2) {
            System.out.println ("less than max2");
            stop = LEVEL2;
        }
        else if (score < MAX3) {
            System.out.println ("less than max3");
            stop = LEVEL3;
        }
        else if (score < MAX4) {
            System.out.println ("less than max4");
            stop = LEVEL4;
        }
        else {
            System.out.println ("less than max5");
            stop = LEVEL5;
        }
    }

    //public Trash getTrash(){
      //  return trash;
    //}

    //public void makeTrash(){
        // make a new trash
    //}
}


// Designerspics.com
// Iso Republic
// Free Nature Stock
// freestocks.org