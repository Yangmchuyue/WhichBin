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
            "images/0BlackPlastic.png", "images/0BubbleWrap.png", "images/0Candle.png", "images/0ColdCup.png", "images/0DrinkPouch.png", "images/0Mug.png", "images/0PopsicleStick.png", "images/0QTip.png",
            "images/1Book.png", "images/1Bottle.png", "images/1FoodContainer.png", "images/1GlassBottle.png", "images/1Tray.png", "images/1ZipLock.png",
            "images/2Banana.png", "images/2Corn.png", "images/2EggShell.png", "images/2Plant.png", "images/2TeaBag.png", "images/2UsedTissue.png"
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
    Common comm;
    /**public static void main (String[] arguments) {
     TrashCan trashcan = new TrashCan();
     trashcan.getRandomNumber();
     } **/

    public TrashCan(Common comm) {
        
        super(new FlowLayout());
        this.comm = comm;
        displayholder = new JPanel();
        this.add(displayholder);
        display = new JButton("", new ImageIcon("images/0BlackPlastic.png"));
        display.setMaximumSize(new Dimension(400, 400));
        displayholder.add(display);
        displayholder.validate();
    
        random = new Random();
        randomNumber = 0;
        trash =  new Trash(0, "images/0BlackPlastic.png");
        // timer = new Timer();
        stop = LEVEL1;
        //timerTask = new TimerTask() {
        //    public void run() {
        //        System.out.println ("Game Over!");} // REPLACE THIS WITH JOPTION PANEL
        //};
        startLevel(0);
    }


    // start
    public void startLevel(int score) {
        System.out.println("Level Starting!");
        setRandomNumber();
        displayholder.remove(display);
        display = new JButton("", new ImageIcon(allTrash[randomNumber]));
        makeTrash();
        display.setMaximumSize(new Dimension(400, 400));
        displayholder.add(display);
        displayholder.revalidate();
        displayholder.repaint();
        this.revalidate();
        this.repaint();
        setTime(score);
        startTimer();
    }

    // end
    public int endLevel(){
        endTimer();
        System.out.println("Guess Submitted1. Timer Ends.");
        int gotten = getNumber();
        System.out.println(gotten);
        System.out.println("Guess Submitted2. Timer Ends.");
        return gotten;
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
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                System.out.println ("Game Over Again! For Realz!");
                /*
                JOptionPane.showMessageDialog(new JFrame(),
                        "It's trash can  not trash cannot.", "Game Over", JOptionPane.ERROR_MESSAGE);
                */

                String[] options = {"OK"}; 
                int x = JOptionPane.showOptionDialog(null, "It's trash can  not trash cannot.",
                        "Game Over",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                if(x == 0)
                {
                    comm.closeGameFrame();
                }                


            }
        };
        timer.schedule(timerTask, stop);
        //timer.schedule(timerTask, 1000);
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

    public int getNumber(){
        String name = trash.getImageName();
        int first = name.charAt(7) - '0';
        return first;

    }
}