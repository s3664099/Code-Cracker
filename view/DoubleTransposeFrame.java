package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.CypherText;
import model.MatrixCode;

@SuppressWarnings("serial")
public class DoubleTransposeFrame extends JFrame {
	
	MatrixPanel matrixPanel;
	MatrixCode matrix;

	public DoubleTransposeFrame(int rows, int columns, CypherText cypher) {

		super("Double Transposition");
		
		setLayout(new BorderLayout());
		
		setSize(400,400);
		
		MatrixCode matrix = new MatrixCode(rows,columns,cypher);
		
		addMatrixPanel(matrix);
		
		add(new MatrixToolBar(matrix,this), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	//Sets up a panel that will display the matrix
	private void addMatrixPanel(MatrixCode matrix)
	{
		matrixPanel = new MatrixPanel(matrix);
		add(matrixPanel, BorderLayout.CENTER);
	}
	
	//Updates the matrix panel when the rows or columns are shifted
	public void updateFrame(MatrixCode matrix)
	{
		remove(matrixPanel);
		addMatrixPanel(matrix);
		revalidate();
		repaint();
	}

}
