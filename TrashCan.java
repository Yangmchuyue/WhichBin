import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import javax.swing.*;
import java.awt.*;


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
    private Trash trash;
    private Timer timer;
    private TimerTask timerTask;
    private Random random;
    private int randomNumber;
    private int stop;
    private JPanel displayholder;
    private JButton display;
    Common comm;

    // Constructor
    public TrashCan(Common comm) {
        
        super(new FlowLayout());
        this.comm = comm;
        displayholder = new JPanel();
        this.add(displayholder);
        display = new JButton("", new ImageIcon(allTrash[0]));

        display.setMaximumSize(new Dimension(400, 400));
        displayholder.add(display);
        displayholder.validate();
    
        random = new Random();
        randomNumber = 0;
        trash =  new Trash(0, allTrash[0]);
        stop = LEVEL1;
        startLevel(0);
    }

    // Start Level
    public void startLevel(int score) {
        setRandomNumber();
        displayholder.remove(display);
        display = new JButton("", new ImageIcon(allTrash[randomNumber]));
        display.setContentAreaFilled(false);

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

    // End Level
    public int endLevel(){
        endTimer();
        int gotten = getNumber();
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
                String[] options = {"OK"}; 
                int x = JOptionPane.showOptionDialog(null, "Game Over! You have taken too long to respond. Better luck next time!",
                        "GAME OVER!",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                if(x == 0)
                {
                    comm.closeGameFrame();
                }                
            }
        };
        timer.schedule(timerTask, stop);
        
    }

    public void endTimer(){
        timer.cancel();
    }

    // Response Time
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

    // Trash Object
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