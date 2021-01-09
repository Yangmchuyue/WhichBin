import java.awt.Color;
import java.io.IOException;

//import javax.swing.JFrame;

public class Common 
{
	private MainFrame mainFrame;
	private GameFrame gameFrame;

	public static final Color color_brown = new Color(238, 226, 220);
	public static final Color color_red = new Color(172, 59, 97);
	public static final Color color_d_brown = new Color(237, 199, 183);
	public static final Color color_blue = new Color(18, 60, 105);
	
	public static final Color color_green = new Color(76, 149, 108);
	public static final Color color_pink = new Color(255, 201, 185);
	public static final Color color_yell = new Color(254, 254, 227);
		
	
	public void initialize() throws IOException
	{
		mainFrame = new MainFrame(this);	
		gameFrame = new GameFrame(this);
	}

	private void hideAllFrames()
	{
		mainFrame.setVisible(false);	
		gameFrame.setVisible(false);
	}
	
	public void showMainFrame()
	{
		hideAllFrames();
		mainFrame.setVisible(true);	
	}
	
	public void showGameFrame()
	{
		hideAllFrames();
		gameFrame.setVisible(true);	
	}	
	
}
