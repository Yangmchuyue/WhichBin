import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame  extends JFrame implements ActionListener
{
	private JButton buttonUserFrame;
	private JButton buttonScheduleFrame;
	private JButton buttonNotifyFrame;
	private JButton exitButton;
	private Common comm;
	
	public MainFrame(Common common) 
	{
		// make mainFrame
		super("Coordinating System");
		comm = common;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //center frame on screen
		
	
		exitButton = new JButton("", new ImageIcon("src\\exitButton.png"));		
		
		// make menu bar in mainFrame
		JMenuBar mb = new JMenuBar();
		mb.setBackground(Common.color_baby_powder);
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        mb.add(file);
        mb.add(help);
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save as");
        file.add(open);
        file.add(save);
		
        // make mainPanel in mainFrame with title
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout());
		mainPanel.setBackground(Common.color_maastricht_blue);
		JLabel label = new JLabel("COORDINATING SYSTEM");
		Font f = new Font("TimesRoman",Font.BOLD,45);
		label.setFont(f);
		label.setForeground(Common.color_maximum_blue_green);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(label);
		
        // make buttonPanel in mainFrame with title
        /*
        JPanel buttonPanel = new JPanel();
        
		buttonPanel.setBackground(Common.color_baby_powder);
		buttonPanel.add(buttonUserFrame); 
		buttonUserFrame.addActionListener(this); 
		buttonPanel.add(buttonScheduleFrame); 
		buttonScheduleFrame.addActionListener(this); 		
		buttonPanel.add(buttonNotifyFrame); 
		buttonNotifyFrame.addActionListener(this); 
		buttonPanel.add(exitButton);
        exitButton.addActionListener(this);
        */
		
		// add components to mainFrame using borderlayout
        BorderLayout borderLayout = new BorderLayout(500, 500);	
        /*	
		getContentPane().add(borderLayout.NORTH, mb);
		getContentPane().add(borderLayout.CENTER, mainPanel);
		getContentPane().add(borderLayout.SOUTH, buttonPanel);
        setVisible(true);		
        */

	}		
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == buttonUserFrame)
		{
			//comm.showUserListFrame();
		}
	}
	public static void main(String[] args)
	{
		Common common = new Common();
		MainFrame mf = new MainFrame(common);
	}
}
