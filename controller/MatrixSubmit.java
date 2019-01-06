package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CypherText;
import view.DoubleTransposeFrame;
import view.SetMatrixFrame;

public class MatrixSubmit implements ActionListener {

	SetMatrixFrame frame;
	CypherText cypher;
	
	public MatrixSubmit(SetMatrixFrame frame, CypherText cypher) {
		
		this.frame = frame;
		this.cypher = cypher;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		int rows;
		int columns;
		String text = cypher.getCypherText();
		
		//takes the rows and columns submitted in the panel
		//And checks to see if they are numbers
		try 
		{
			rows = frame.getRows();
			columns = frame.getColumns();
			
		} catch (NumberFormatException e) {
			
			//Generates a warning if they are not numbers
			JOptionPane.showMessageDialog(frame, "Please Enter a Number!", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Checks to see whether the rows and columns will enable the cypher text
		//to comfortably fit inside
		if (rows*columns<text.length())
		{
			//Generates a warning if the text is too long
			JOptionPane.showMessageDialog(frame, "Text too long for requested matrix size!", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//if the text is shorter than the matrix then extra letters are added to the text
		if (rows*columns>text.length())
		{	
			for(int i = text.length(); i<rows*columns; i++)
			{
				text=text.concat("x");
			}
			
			cypher.setCypherText(text);
		}
		
		//Gets rid of the matrix setup frame;
		frame.dispose();
		
		new DoubleTransposeFrame(rows,columns, cypher);
		

	}

}
