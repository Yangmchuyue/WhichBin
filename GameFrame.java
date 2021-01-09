import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class GameFrame extends JFrame{
    
    //Instance Fields
    private Scoreboard scoreboard;
    private TrashCan trashPrompt;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JPanel guessPanel;
    private JButton garbage;
    private JButton recycling;
    private JButton compost;
    
    //Constructor
    public GameFrame(Common comm){
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null); //center frame on screen

        gamePanel = new JPanel(new BorderLayout());
        scoreboard = new Scoreboard();
        trashPrompt = new TrashCan(comm);


        menuPanel = new JPanel(new FlowLayout());
        JButton button = new JButton("", new ImageIcon("button_back.png"));
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame(); // Closes this GameFrame
				comm.showMainFrame();
            }
        });
        menuPanel.add(button);


        guessPanel = new JPanel(new GridLayout(1,3, 10, 50));
        garbage = new JButton("", new ImageIcon("images/Garbage.png"));
        garbage.setContentAreaFilled(false);
        garbage.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = trashPrompt.endLevel(); 
                System.out.println("Guess: " + 0);
                if(guess == 0){
                    scoreboard.addToScore(100);
                    trashPrompt.startLevel(scoreboard.getScore()); // starts the next level
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                        "Game Over! That does not belong in the garbage bin. Better luck next time!", "GAME OVER!", JOptionPane.ERROR_MESSAGE);
                        closeFrame();
                        comm.showMainFrame();
                }
            }
        });
        guessPanel.add(garbage);
        recycling = new JButton("", new ImageIcon("images/Recycle.png"));
        recycling.setContentAreaFilled(false);
        recycling.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = trashPrompt.endLevel();
                System.out.println("Guess: " + 1);
                if(guess == 1){
                    scoreboard.addToScore(100);
                    trashPrompt.startLevel(scoreboard.getScore()); 
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                        "Game Over! That does not belong in the recycling bin. Better luck next time!", "GAME OVER!", JOptionPane.ERROR_MESSAGE);
                    closeFrame();
                    comm.showMainFrame();
                }
            }
        });
        guessPanel.add(recycling);
        compost = new JButton("", new ImageIcon("images/GreenBin.png"));
        compost.setContentAreaFilled(false);
        compost.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = trashPrompt.endLevel();
                System.out.println("Guess: " + 2);
                if(guess == 2){
                    scoreboard.addToScore(100);
                    trashPrompt.startLevel(scoreboard.getScore());
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                        "Game Over! That does not belong in the green bin. Better luck next time!", "GAME OVER!", JOptionPane.ERROR_MESSAGE);
                    closeFrame();
                    comm.showMainFrame();
                }
            }
        });
        guessPanel.add(compost);

        gamePanel.add(guessPanel, BorderLayout.CENTER);
        gamePanel.add(scoreboard, BorderLayout.EAST);
        gamePanel.add(trashPrompt, BorderLayout.NORTH);
        gamePanel.add(menuPanel, BorderLayout.SOUTH);
        this.add(gamePanel);
        this.validate();
        this.setVisible(true);
    }

    //Accessors
    public Scoreboard getScoreboard(){
        return scoreboard;
    }
    
    public TrashCan getTrashPrompt(){
        return trashPrompt;
    }
    
    //Mutators
    public void closeFrame(){
        super.dispose();
    }

}