package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.matrixShift;
import model.MatrixCode;

@SuppressWarnings("serial")
public class MatrixToolBar extends JToolBar {
	
	MatrixCode matrix;
	DoubleTransposeFrame frame;

	public MatrixToolBar(MatrixCode matrix, DoubleTransposeFrame frame) {
		
		this.matrix = matrix;
		this.frame = frame;
		
		addButton("Shift Rows","row");
		addButton("Shift Columns","column");
		
	}
	
	public void addButton(String title, String type)
	{
		JButton button = new JButton(title);
		button.addActionListener(new matrixShift(type, matrix, frame));
		add(button);
	}

}
