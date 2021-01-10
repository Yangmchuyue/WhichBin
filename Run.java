import java.io.IOException;
import javax.swing.*;
public class Run
{
	private Common comm;
	
	public Run() throws IOException
	{
		comm = new Common();
		comm.initialize();
		comm.showMainFrame();
	}
	public static void main(String[] args) throws IOException
	{
		Run run = new Run();
	}
}
