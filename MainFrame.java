import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class MainFrame  extends JFrame implements ActionListener
{
	private JButton playButton; 
	private JButton scoreButton;
	private JButton exitButton; 
	Common comm;
	
	public MainFrame(Common comm) 
	{
		this.comm = comm;
		// Colours
		Color bgC = Common.color_green;
		Color mbC = Common.color_pink;
		Color sC= Common.color_yell;
		
		// MainFrame Settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500); 
		setResizable(false);
		setLocationRelativeTo(null); //center frame on screen	
		
		// Buttons
		playButton  = new JButton("", new ImageIcon("button_play.png"));	
		scoreButton  = new JButton("", new ImageIcon("button_score.png"));
		exitButton = new JButton("", new ImageIcon("button_exit.png"));		

		//Button Settings
		playButton.setContentAreaFilled(false);
		scoreButton.setContentAreaFilled(false);
		exitButton.setContentAreaFilled(false);

		//Fonts
		Font f1 = new Font("Gill Sans",Font.BOLD,45);
		Font f2 = new Font("Gill Sans",Font.BOLD,25);
		
		// Menubar
		JMenuBar mb = new JMenuBar();
		mb.setBackground(Common.color_d_brown);
        JMenu about = new JMenu("About");
        mb.add(about);
		
        // Panel for labels
		//JPanel mainPanel = new JPanel();	
		ImagePanel mainPanel = new ImagePanel(new ImageIcon("a_bg.png").getImage());
		mainPanel.setLayout(new GridLayout(4,1));
		mainPanel.setBackground(bgC);
		
		// Empty Label
		JLabel filler = new JLabel("");				
		filler.setVerticalAlignment(JLabel.CENTER);
		filler.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(filler);
		
		// Title Label
		JLabel title = new JLabel("Which Bin?");				
		title.setFont(f1);
		title.setForeground(mbC);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(title);
		
		// Subtitle Label
		JLabel subTitle = new JLabel("Reduce, Reuse, Recycle");	
		subTitle.setFont(f2);
		subTitle.setForeground(sC);
		subTitle.setVerticalAlignment(JLabel.CENTER);
		subTitle.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(subTitle);		
		

        // Button Panel
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
		add(borderLayout.NORTH, mb);
		add(borderLayout.CENTER, mainPanel);
		add(borderLayout.SOUTH, buttonPanel);
		
        setVisible(true); // Make MainFrame visible
		
		// JMenu Listener
		about.addMenuListener(new MenuListener() 
		{

			public void menuSelected(MenuEvent e) 
			{
				//System.out.println("menuSelected");
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f, "Welcome to WhichBin? Version 1.0");
			}

			public void menuDeselected(MenuEvent e) 
			{
				//System.out.println("menuDeselected");
			}

			public void menuCanceled(MenuEvent e) 
			{
				//System.out.println("menuCanceled");
			}
		});

        

	}		
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == playButton)
		{
			comm.showGameFrame();
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
}

class ImagePanel extends JPanel 
{
    private Image image;

    public ImagePanel(String image) 
	{
        this(new ImageIcon(image).getImage());
    }

    public ImagePanel(Image image) 
	{
        this.image = image;
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);

        setMinimumSize(size);
        setMaximumSize(size);

        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) 
	{
        g.drawImage(image, 0, 0, null);
    }
}
