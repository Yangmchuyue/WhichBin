import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TrashCan extends JPanel{
    // class fields
    private static int LEVEL1 = 15000;
    private static int LEVEL2 = 10000;
    private static int LEVEL3 = 5000;
    private static int LEVEL4 = 4000;
    private static int LEVEL5 = 3000;

    private static int MAX1 = 400;
    private static int MAX2 = 800;
    private static int MAX3 = 1200;
    private static int MAX4 = 1600;

    private static String[] allTrash = {
            "0BlackPlastic.png", "0BubbleWrap.png", "0Candle.png", "0ColdCup.png", "0DrinkPouch.png", "0Mug.png", "0PopsicleStick.png", "0QTip.png",
            "1Book.png", "1Bottle.png", "1FoodContainer.png", "1GlassBottle.png", "1Tray.png", "1ZipLock.png",
            "2Banana.png", "2Corn.png", "2EggShell.png", "2Plant.png", "2TeaBag.png", "2UsedTissue.png"
    };

    // instance fields
    private Trash trash; // stores a Trash
    private Timer timer;
    private TimerTask timerTask;
    private Random random;
    private int randomNumber;
    private int stop;
    private JPanel displayholder;
    private JButton display;

    /**public static void main (String[] arguments) {
     TrashCan trashcan = new TrashCan();
     trashcan.getRandomNumber();
     } **/

    public TrashCan() {
        super(new FlowLayout());
        displayholder = new JPanel();
        this.add(displayholder);
        display = new JButton("", new ImageIcon("images/0BlackPlastic.png"));
        display.setMaximumSize(new Dimension(400, 400));
        displayholder.add(display);

        random = new Random();
        randomNumber = 0;
        timer = new Timer();
        stop = LEVEL1;
        timerTask = new TimerTask() {
            public void run() {
                System.out.println ("Game Over!");} // REPLACE THIS WITH JOPTION PANEL
        };
        startLevel(0);
    }
    trash =  newTrash(1, "image name"); // REPLACE THIS

    // start
    public void startLevel(int score) {
        System.out.println("Level Starting!");
        setRandomNumber();
        display = new JButton("", new ImageIcon(allTrash[randomNumber]));
        display.setMaximumSize(new Dimension(400, 400));
        displayholder.add(display);
        setTime(score);
        startTimer();
    }

    // end -> called by Gracie
    public void endLevel(){
        endTimer();
        System.out.println("Guess Submitted. Timer Ends.");
    }

    // Random Number
    public int getRandomNumber(){
        return randomNumber;
    }

    public void setRandomNumber() {
        randomNumber = random.nextInt(19);
    }

    // Timer
    public void startTimer(){
        timer.schedule(timerTask, stop);
    }

    public void endTimer(){
        timer.cancel();
    }

    // Milliseconds
    public void setTime(int score) {
        if (score <= MAX1 ) {
            stop = LEVEL1;
        }
        else if (score <= MAX2) {
            stop = LEVEL2;
        }
        else if (score <= MAX3) {
            stop = LEVEL3;
        }
        else if (score <= MAX4) {
            stop = LEVEL4;
        }
        else {
            stop = LEVEL5;
        }
    }

    public Trash getTrash(){
      return trash;
    }

    public void makeTrash(){
        trash = new Trash(randomNumber, allTrash[randomNumber]);
    }
}


// Designerspics.com
// Iso Republic
// Free Nature Stock
// freestocks.org