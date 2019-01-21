package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.LetterCount;

@SuppressWarnings("serial")
public class CentrePanel extends JPanel {
		
	public CentrePanel(LetterCount count)
	{
		ArrayList<String> textLines = count.getMessage();
		
		setLayout(new GridLayout(textLines.size(),1));
		
		for (String text:textLines)
		{
			add(new JLabel(text));
		}
		
		setVisible(true);
	}
	
}
