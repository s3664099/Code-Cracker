package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CypherText;
import view.MainFrame;

//Creates the listener on the submit button
public class SubmitButton implements ActionListener {
	
	//A copy of the main frame is created and stored in the listener
	private MainFrame frame;
	
	public SubmitButton(MainFrame frame)
	{
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		//The text is extracted from the text area in the frame
		String cypher = frame.getText();
		
		//A new cypher text object is created and the
		//Text is stored in the object
		CypherText text = new CypherText(cypher);
		
		//The cypher text is then passed through to the main frame
		frame.setCypher(text);
		
	}

}
