import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class Scoreboard extends JPanel{
    /*public static void main(String[] args){
     JFrame frame = new JFrame();
     JPanel panel = new Scoreboard();
     frame.add(panel);
     frame.validate();
     frame.pack();
     frame.setSize(200,300);
     frame.setVisible(true);
     }
*/
    //Instance Fields
    private int score;
    private long startTime;
    private JLabel scoreLabel;
    private JLabel timeLabel;

    public Scoreboard(){
        super(new GridLayout(2, 1));
        this.setBackground(new Color(167,230,140));

        score = 0;
        startTime = System.nanoTime();
        scoreLabel = new JLabel("Score: " + getScore());
        scoreLabel.setFont(new Font("Open Sancs", Font.BOLD, 18));
        Border border = BorderFactory.createLineBorder(new Color(40,108,6));
        scoreLabel.setForeground(new Color(40,108,6));
        scoreLabel.setBorder(border);
        scoreLabel.setPreferredSize(new Dimension(150, 100));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(scoreLabel);
        
        timeLabel = new JLabel("Time: " + getTimeElapsed());
        timeLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
        border = BorderFactory.createLineBorder(new Color(40,108,6));
        timeLabel.setForeground(new Color(40,108,6));
        timeLabel.setBorder(border);
        timeLabel.setPreferredSize(new Dimension(150, 100));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(timeLabel);
    }

    //Accessor Methods

    //Returns current score
    public int getScore(){
        return score;
    }

    //Returns the elapsed time in seconds
    //May throw exception
    public int getTimeElapsed(){
        long elapsedTime = System.nanoTime() - startTime;
        int elapsedTimeInSeconds = (int) elapsedTime/1000000000;
        return elapsedTimeInSeconds;
    }

    //Mutator Methods
    public void addToScore(int points){
        score = score + points;
        this.remove(scoreLabel);
        this.remove(timeLabel);
        scoreLabel.setText("Score: " + getScore());
        timeLabel.setText("Time: " + getTimeElapsed());
        this.add(scoreLabel);
        this.add(timeLabel);
        this.revalidate();
        this.repaint();
    }
    public void displayNewTime(){
        this.remove(scoreLabel);
        this.remove(timeLabel);
        scoreLabel.setText("Score: " + getScore());
        timeLabel.setText("Time: " + getTimeElapsed());
        this.add(scoreLabel);
        this.add(timeLabel);
        this.revalidate();
        this.repaint();
    }
    //Test Git Commands
}

