import javax.swing.*;
import java.awt.*;
public class Scoreboard extends JPanel{
/**  public static void main(String[] args){
        JFrame frame = new JFrame();
        JPanel panel = new Scoreboard();
        frame.add(panel);
        frame.validate();
        frame.pack();
        frame.setSize(200,300);
        frame.setVisible(true);
    }
 **/
    //Instance Fields
    private int score;
    private long startTime;
    private JButton scoreLabel;
    private JButton timeLabel;

    public Scoreboard(){
        super(new GridLayout(2, 1));
        score = 0;
        startTime = System.nanoTime();
        scoreLabel = new JButton("Score: " + getScore());
        this.add(scoreLabel);
        timeLabel = new JButton("Time: " + getTimeElapsed());
        this.add(timeLabel);
    }

    //Accessor Methods

    //Returns current score
    public int getScore(){
        return score;
    }

    //Returns the elapsed time in seconds
    //May throw exception
    public double getTimeElapsed(){
        long elapsedTime = System.nanoTime() - startTime;
        double elapsedTimeInSeconds = (double) elapsedTime/1000000000;

        return elapsedTimeInSeconds;
    }

    //Mutator Methods
    public void addToScore(int points){
        score = score + points;
        this.remove(scoreLabel);
        this.remove(timeLabel);
        scoreLabel = new JButton("Score: " + getScore());
        timeLabel = new JButton("Time: " + getTimeElapsed());
        this.add(scoreLabel);
        this.add(timeLabel);
        
    }
    public void displayNewTime(){
        this.remove(scoreLabel);
        this.remove(timeLabel);
        scoreLabel = new JButton("Score: " + getScore());
        timeLabel = new JButton("Time: " + getTimeElapsed());
        this.add(scoreLabel);
        this.add(timeLabel);
    }
    //Test Git Commands
}

