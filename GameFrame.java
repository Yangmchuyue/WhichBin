import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
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
    private Sound sound;
    
    //Constructor
    public GameFrame(Common comm){
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 500);
        this.setLocationRelativeTo(null); //center frame on screen
        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        contentPanel.setBorder(padding);
        this.setContentPane(contentPanel);
        this.getContentPane().setBackground(new Color(230,242,230));
        
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setBackground(new Color(230,242,230));
        scoreboard = new Scoreboard();
        trashPrompt = new TrashCan(comm);
        trashPrompt.setBackground(new Color(230,242,230));
        sound = new Sound();
        menuPanel = new JPanel(new FlowLayout());
        menuPanel.setBackground(new Color(230,242,230));
        JButton button = new JButton("", new ImageIcon("images/button_back.png"));
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame(); // Closes this GameFrame
				comm.showMainFrame();
            }
        });
        menuPanel.add(button);


        guessPanel = new JPanel(new GridLayout(1,4, 10, 50));
        guessPanel.setBackground(new Color(230,242,230));
        garbage = new JButton("", new ImageIcon("images/Garbage.png"));
        garbage.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = trashPrompt.endLevel(); 
                if(guess == 0){
                    scoreboard.addToScore(100);
                    trashPrompt.startLevel(scoreboard.getScore());
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                        "Game Over! That does not belong in the garbage bin. Better luck next time!", 
                        "GAME OVER!", JOptionPane.ERROR_MESSAGE);
                        closeFrame();
                        comm.showMainFrame();
                }
            }
        });
        guessPanel.add(garbage);
        recycling = new JButton("", new ImageIcon("images/Recycle.png"));
        recycling.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = trashPrompt.endLevel();
                if(guess == 1){
                    scoreboard.addToScore(100);
                    trashPrompt.startLevel(scoreboard.getScore()); 
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                        "Game Over! That does not belong in the recycling bin. Better luck next time!",
                         "GAME OVER!", JOptionPane.ERROR_MESSAGE);
                    closeFrame();
                    comm.showMainFrame();
                }
            }
        });
        guessPanel.add(recycling);
        compost = new JButton("", new ImageIcon("images/GreenBin.png"));
        compost.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = trashPrompt.endLevel();
                if(guess == 2){
                    scoreboard.addToScore(100);
                    trashPrompt.startLevel(scoreboard.getScore());
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                        "Game Over! That does not belong in the green bin. Better luck next time!",
                         "GAME OVER!", JOptionPane.ERROR_MESSAGE);
                    closeFrame();
                    comm.showMainFrame();
                }
            }
        });
        guessPanel.add(compost);
        guessPanel.add(scoreboard);

        gamePanel.add(guessPanel, BorderLayout.CENTER);
        gamePanel.add(trashPrompt, BorderLayout.NORTH);
        gamePanel.add(menuPanel, BorderLayout.SOUTH);
        this.add(gamePanel);
        this.validate();
        this.setVisible(true);
    }

    //Accessor Methods
    public Scoreboard getScoreboard(){
        return scoreboard;
    }
    
    public TrashCan getTrashPrompt(){
        return trashPrompt;
    }
    
    //Mutator Methods
    public void closeFrame(){
        sound.stopSound();
        super.dispose();
    }

}