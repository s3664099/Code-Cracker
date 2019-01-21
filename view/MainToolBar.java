package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.Caeser;
import controller.Frequency;
import controller.Transpose;

@SuppressWarnings("serial")
public class MainToolBar extends JToolBar {
	
	private JButton button;
	private MainFrame frame;
	
	public MainToolBar(MainFrame frame)
	{
		
		this.frame = frame;
		
		//This button creates a new screen to manipulate
		//the text using the Caeser Cypher. The frame is passed through.		
		AddButton("Caeser Cypher", new Caeser(frame));
		
		//Adds a button to fire up the Double Transposition frame
		AddButton("Double Transposition", new Transpose(frame));
		
		//Adds a button to fire up the Frequency Analysis frame
		AddButton("Frequency Analysis", new Frequency(frame));
		
	}
	
	//This method adds a new button to the tool bar
	//The listener and title are passed through
	public void AddButton(String title, ActionListener type)
	{
		button = new JButton(title);
		button.addActionListener(type);
		enableButton(frame, button);
	}
	
	//Method to check to see whether the cypher object is empty
	private void enableButton(MainFrame frame, JButton button)
	{
		if (frame.getCypher() == null)
		{
			//if it is, the button is disabled
			button.setEnabled(false);
		} else {
			//otherwise the button is enabled
			button.setEnabled(true);
		}
		add(button);
	}

}
