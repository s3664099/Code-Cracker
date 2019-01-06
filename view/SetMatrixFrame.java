package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MatrixSubmit;
import controller.SwitchSubmit;
import model.CypherText;
import model.MatrixCode;

@SuppressWarnings("serial")
public class SetMatrixFrame extends JFrame {

	private JTextField rowField;
	private JTextField columnField;
	
	//This is a second constructor set up to reduce code reuse.
	//This uses the matrix generation frame to also enable the rows and 
	//Columns to be switched
	public SetMatrixFrame(String type, MatrixCode matrix, DoubleTransposeFrame frame)
	{
		super("Switch "+type);
		
		setGrid("Switch "+type, "With "+type);
		
		//While the button is similar, the listener is substantially different
		//So a new button has to be generated
		JButton submit = new JButton("submit");
		submit.addActionListener(new SwitchSubmit(this, matrix, type, frame));
		this.getRootPane().setDefaultButton(submit);
		add(submit);
		
		setVisible(true);
	}
	
	//This creates the box for when the Double Transposition Frame is established
	//This sets the number of rows and columns for the matrix
	public SetMatrixFrame(CypherText cypher) {

		super("Set Matrix");
								
		setGrid("Rows","Columns");
		
		//Adds a submit button to set up the matrix
		//Also sets this button as the button that is fired if enter is pressed
		JButton submit = new JButton("submit");
		submit.addActionListener(new MatrixSubmit(this, cypher));
		this.getRootPane().setDefaultButton(submit);
		add(submit);
		
		setVisible(true);
	}
	
	public void setGrid(String labelOne, String labelTwo)
	{
		setSize(100,150);
		
		setLayout(new GridLayout(3,2));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Adds the field (and label) to set the number of rows
		rowField = new JTextField(10);
		add(new JLabel(labelOne));
		add(rowField);
		
		//Adds the field (and label) to set the number of columns
		columnField = new JTextField(10);
		add(new JLabel(labelTwo));
		add(columnField);
	}
	
	public int getRows()
	{
		return Integer.parseInt(rowField.getText());
	}
	
	public int getColumns()
	{
		return Integer.parseInt(columnField.getText());
	}

}
