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
		Color bgC = Common.color_green;
		Color mbC = Common.color_pink;
		Color sC= Common.color_yell;
		
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
		mainPanel.setLayout(new GridLayout(4,1));
		mainPanel.setBackground(bgC);
		
		JLabel filler = new JLabel("");				
		filler.setVerticalAlignment(JLabel.CENTER);
		filler.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(filler);
		
		JLabel title = new JLabel("Which Bin?");				
		title.setFont(f1);
		title.setForeground(mbC);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(title);
		
		JLabel subTitle = new JLabel("Reduce, Reuse, Recycle");	
		subTitle.setFont(f2);
		subTitle.setForeground(sC);
		subTitle.setVerticalAlignment(JLabel.CENTER);
		subTitle.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(subTitle);		
		

        
        JPanel buttonPanel = new JPanel();
        
		buttonPanel.setBackground(bgC);
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
