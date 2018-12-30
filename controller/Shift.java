package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CaeserTextShift;
import model.CypherText;
import model.Letters;
import view.CaeserFrame;

public class Shift implements ActionListener {

	private String direction; //the direction that the text will be shifted
	private String text;
	private CaeserFrame frame;
	private CypherText cypherText;
	private int key; //the key for the cypher text
	private int shiftKey;
	
	//The direction is hardcoded into this object
	public Shift(String direction, CypherText cypherText, CaeserFrame frame, int key)
	{
		this.direction = direction;
		this.frame = frame;
		this.cypherText = cypherText;
		this.key = key;
		text = cypherText.getCypherText();
		
		//The text is reduced to lower case
		text = text.toLowerCase();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		CaeserTextShift textShift = new CaeserTextShift(text);
		
		//The position of each of the letters in the text is recorded based
		//on the position of the letter in the alphabet
		textShift.checkWord();
		
		//If the left button is pressed the letters are shifted one
		//space to the left
		if (direction.equals("left"))
		{
			shiftKey = -1;
		
		//If the right button is pressed, then the letters are shifted one
		//space to the right
		} else if (direction.equals("right")) {
			
			shiftKey = 1;
		}
		
		//The function to shift the text is called
		text = textShift.ShiftWord(shiftKey);
		
		//The key is update based on the direction moved
		key = key + shiftKey;
		
		//The cypher text object is updated with the new text
		cypherText.setCypherText(text);
		
		//The frame is updated
		frame.dispose();
		frame = new CaeserFrame(cypherText, key);

	}



}
