package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.Caeser;

public class MainToolBar extends JToolBar {
	
	private JButton button;
	
	public MainToolBar(MainFrame frame)
	{
		//This button creates a new screen to manipulate
		//the text using the Caeser Cypher. The frame is passed through.
		button = new JButton("Caeser Cypher");
		button.addActionListener(new Caeser(frame));
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
