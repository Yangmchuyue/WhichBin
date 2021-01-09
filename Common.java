import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

public class Common 
{
	private MainFrame mainFrame;
	private int size_x, size_y;

	public static final Color color_brown = new Color(238, 226, 220);
	public static final Color color_red = new Color(172, 59, 97);
	public static final Color color_d_brown = new Color(237, 199, 183);
	public static final Color color_blue = new Color(18, 60, 105);
		
	
	public void initialize() throws IOException
	{
		// initialize special colours
		mainFrame = new MainFrame();
		//setSize(mainFrame);
		
	}

	private void hideAllFrames()
	{
		mainFrame.setVisible(false);	
	}
	
	public void showMainFrame()
	{
		//hideAllFrames();
		mainFrame.setVisible(true);	
	}
}
