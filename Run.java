/*
 *@author Gracie Zhang
 */
import java.awt.*;
import java.awt.event.*;
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

/*
 * 
 *
Done: 
•	at least 2 frames( or one frame and 2 panels that will replace each other)
•	a way to go from one frame to another
•	at least 2 classes
•	evidences of inheritance
•	evidences of encapsulation
•	at least one overloaded constructor (class User)
•	at least one static variable ( not counting global variables in a main class) (Common.java colors)
•	evidences of polymorphism (search)
•	at least one static methods ( not counting main) (algorithm.java)
•	an exit button

Proceeding:
•	read and write from/to file functionality

To do:




*/
