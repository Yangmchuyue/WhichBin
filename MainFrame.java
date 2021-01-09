import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame  extends JFrame implements ActionListener
{
	private JButton playButton;
	private JButton scoreButton;
	private JButton exitButton;

	public MainFrame() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);	
		setLocationRelativeTo(null); //center frame on screen
		
		playButton  = new JButton("", new ImageIcon("button_play.png"));	
		scoreButton  = new JButton("", new ImageIcon("button_score.png"));
		exitButton = new JButton("", new ImageIcon("button_exit.png"));		
		
		Font f1 = new Font("TimesRoman",Font.BOLD,45);
		Font f2 = new Font("TimesRoman",Font.BOLD,25);
		
		// make menu bar in mainFrame
		JMenuBar mb = new JMenuBar();
		mb.setBackground(Common.color_d_brown);
        JMenu about = new JMenu("About");
        mb.add(about);
		
        // make mainPanel in mainFrame with title
		JPanel mainPanel = new JPanel();	
		mainPanel.setLayout(new VerticalFlowLayout());
		mainPanel.setBackground(Common.color_brown);
		
		
		JLabel title = new JLabel("Which Bin?");				
		title.setFont(f1);
		title.setForeground(Common.color_red);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(title);
		
		JLabel label = new JLabel("Reduce, Reuse, Recycle");	
		label.setFont(f2);
		label.setForeground(Common.color_blue);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(label);		
		

        
        JPanel buttonPanel = new JPanel();
        
		buttonPanel.setBackground(Common.color_brown);
		buttonPanel.add(playButton); 
		playButton.addActionListener(this); 
		buttonPanel.add(scoreButton); 
		scoreButton.addActionListener(this);		
		buttonPanel.add(exitButton); 
		exitButton.addActionListener(this); 		
        
		
		// add components to mainFrame using borderlayout
        BorderLayout borderLayout = new BorderLayout(500, 500);	
        
		getContentPane().add(borderLayout.NORTH, mb);
		getContentPane().add(borderLayout.CENTER, mainPanel);
		getContentPane().add(borderLayout.SOUTH, buttonPanel);
		

			
        setVisible(true);		
        

	}		
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == playButton)
		{
			//comm.showGameFrame();
		}
		if(e.getSource() == scoreButton)
		{
			//comm.showScorePanel();
		}		
		if(e.getSource() == exitButton)
		{
			System.exit(0);
		}		
	}
		public static void main(String[] args)
	{
		MainFrame mf = new MainFrame();
	}
}
