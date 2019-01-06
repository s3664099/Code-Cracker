package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MatrixCode;
import view.DoubleTransposeFrame;
import view.SetMatrixFrame;

public class SwitchSubmit implements ActionListener {

	SetMatrixFrame setFrame;
	MatrixCode matrix;
	String type;
	DoubleTransposeFrame frame;
	
	public SwitchSubmit(SetMatrixFrame setFrame, MatrixCode matrix, String type, 
			DoubleTransposeFrame frame) {

		this.setFrame = setFrame;
		this.matrix = matrix;
		this.type = type;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int swapThis;
		int withThis;
		
		//Gets the data from the dialogue box and converts them to integers
		//If tehy are not an integer then an error is generated
		try 
		{
			swapThis = setFrame.getRows()-1;
			withThis = setFrame.getColumns()-1;
			
		} catch (NumberFormatException o) {
			
			//Generates a warning if they are not numbers
			JOptionPane.showMessageDialog(frame, "Please Enter a Number!", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Checks to see if we are moving rows or columns
		if (type.equals("row"))
		{
			//Checks to see whether the data is correct. If a result of true is
			//received, the data is invalid and the user needs to re-enter it
			if(checkData(swapThis, matrix.getRows()) || checkData(withThis,matrix.getRows()))
			{
				return;
			} else {
				
				//The rows are then swapped and the frame updated
				matrix.shiftRow(swapThis, withThis);
				frame.updateFrame(matrix);
				setFrame.dispose();
			}
		} else if(type.equals("column")) {
			
			//Once again, the data is checked to see whether it is within range
			if(checkData(swapThis, matrix.getColumn()) || checkData(withThis,matrix.getColumn()))
			{
				return;
			} else {
				
				//If it is within range, the columns are swapped and the frame updated
				matrix.shiftColumn(swapThis, withThis);
				frame.updateFrame(matrix);
				setFrame.dispose();
			}
		}
			

	}
	
	//This method checks to see whether the data is within range
	//Namely that the requested row or column isn't less than 1 (since 0 are the
	//headings) and isn't greater than the greatest number of rows or columns.
	//An error is generated if the entry is invalid
	public boolean checkData(int data, int range)
	{
		if (data<0 || data>range)
		{
			JOptionPane.showMessageDialog(frame, "Entry outside of range!", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return true;
		}
		
		return false;
	}

}
