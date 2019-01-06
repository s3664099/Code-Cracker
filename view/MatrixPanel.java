package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.MatrixCode;

@SuppressWarnings("serial")
public class MatrixPanel extends JPanel {

	public MatrixPanel(MatrixCode matrix) {

		//Initiates the number of rows and columns in the matrix
		//There is one extra row and column so the numbers can be included
		int rows = matrix.getRows()+1;
		int columns = matrix.getColumn()+1;
		
		//establishes a grid based upon the number of rows and columns
		setLayout(new GridLayout(rows,columns));
		
		//cycles throw the rows and columns and populates them
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
			{
				if (i==0)
				{
					addLabel(""+j);
				} else if(j==0){
					addLabel(""+i);
				}else {
					addLabel(matrix.getCell(i, j));
				}
			}
		}
	}
	
	//Adds the label with a larger font size to enable reading
	public void addLabel(String text)
	{
		
		JLabel label = new JLabel(text);
		label.setFont(label.getFont().deriveFont(24.0f));
		add(label);
	}

}
