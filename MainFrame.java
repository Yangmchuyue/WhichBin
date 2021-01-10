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
	
	private JButton exitButton; 
	Common comm;
	GameFrame gameFrame;
	
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
		playButton  = new JButton("", new ImageIcon("images/button_play.png"));	
		exitButton = new JButton("", new ImageIcon("images/button_exit.png"));		

		//Button Settings
		playButton.setContentAreaFilled(false);
		exitButton.setContentAreaFilled(false);

		//Fonts
		Font f1 = new Font("Gill Sans",Font.BOLD,28);
		Font f2 = new Font("Gill Sans",Font.BOLD,20);
		
		// Menubar
		JMenuBar mb = new JMenuBar();
		mb.setBackground(Common.color_d_brown);
        JButton about = new JButton("About");
        mb.add(about);
		JButton howTo = new JButton("How To Play");
		mb.add(howTo);
		
        // Panel for Labels
		ImagePanel mainPanel = new ImagePanel(new ImageIcon("images/a_bg.png").getImage());
		mainPanel.setLayout(new GridLayout(4,1));
		mainPanel.setBackground(bgC);
		
		// Empty Label
		JLabel filler = new JLabel("");				
		filler.setVerticalAlignment(JLabel.CENTER);
		filler.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(filler);
		
		// Title Label
		JLabel title = new JLabel("Which Bin");				
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
		buttonPanel.add(exitButton); 
		exitButton.addActionListener(this); 		
        
		// Adds components to mainFrame using borderlayout
        BorderLayout borderLayout = new BorderLayout(500, 500);	
		add(borderLayout.NORTH, mb);
		add(borderLayout.CENTER, mainPanel);
		add(borderLayout.SOUTH, buttonPanel);
		
        setVisible(true); // Makes MainFrame visible
		
		// JMenu Listener for howTo
		howTo.addActionListener(new ActionListener() 
		{

			@Override
            public void actionPerformed(ActionEvent e) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "How To Play: " + 
						"\n A piece of trash will show up at the top of the screen." +
						"\n Your mission is to pick the bin the trash should go into: Garbage, Recycling or Compost." +
						"\n Hurry and choose the correct one before the time runs out, otherwise it's GAME OVER." +
						"\n Try to become an eco-Wiz as the time limit becomes shorter and shorter!");
					howTo.setSelected(false);
			}
		});

		// JMenu Listener for about
		about.addActionListener(new ActionListener() 
		{
			@Override
            public void actionPerformed(ActionEvent e) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Welcome to Which Bin? Version 1.0!" + 
					"\n Built by Cindy G, Grace F, Gracie Z, and Maggie Y." +
					"\n This game features the audio clip \"Village Dreaming [Loop]\" by Visager, " +
					"\n available under a Creative Commons Attribution License: " +
					"\n https://creativecommons.org/licenses/by/4.0/" + 
					"\n Music Source and Visager's Music: " + 
					"\n https://freemusicarchive.org/search/?quicksearch=visager");
					about.setSelected(false);
			}
		});		
	}		
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == playButton)
		{
			comm.setGameFrame(new GameFrame(comm));
			setVisible(false);
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