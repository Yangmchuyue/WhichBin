import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

public class Common 
{
	private MainFrame mainFrame;
	
	// color from: ref: https://coolors.co/
	public static final Color color_maastricht_blue = new Color(1, 22, 39);
	public static final Color color_baby_powder = new Color(253, 255, 252);
	public static final Color color_maximum_blue_green = new Color(46, 196, 182);
	public static final Color color_rose_madder = new Color(231, 29, 54);
	public static final Color color_bright_yellow = new Color(255, 159, 28);
	
	public void initialize() throws IOException
	{
		
		// initialize special colours
		mainFrame = new MainFrame(this);
		
	}

	private void hideAllFrames()
	{
		mainFrame.setVisible(false);	
	}
	
	public void showMainFrame()
	{
		hideAllFrames();
		mainFrame.setVisible(true);	
	}
}
