package model;

public class MatrixCode {
	
	private int rows;
	private int columns;
	String[][] matrix;
	String[] temprows;
	String[] tempcol;
	
	public MatrixCode(int rows, int columns, CypherText cypher)
	{
		this.rows = rows;
		this.columns = columns;

		matrix = new String[rows][columns];
		temprows = new String[rows];
		tempcol = new String[columns];
		
		enterMatrix(cypher.getCypherText());
	}
	
	//Method fills the matrix with the text
	public void enterMatrix(String text)
	{
		//sets the counter for the text
		int k = 0;
		
		//cycles through the rows
		for (int i=0;i<rows;i++)
		{
			//cycles through the columns
			for (int j=0;j<columns;j++)
			{
				//fills the cells with the text
				matrix[i][j] = text.substring(k,k+1);
				k++;
			}
		}
	}
	
	//Returns the matrix as a String
	//TODO make this tighter and cleaner
	public String getMatrix()
	{
		String text="  ";

		//sets the numbers along the top
		for (int i=0;i<columns;i++)
		{
			text = text.concat((i+1)+" ");
		}
		
		text = String.format("%s%n",text);
		
		//cycles through the rows and columns and
		//generates the matrix
		for (int i=0;i<rows;i++)
		{
			text = text.concat((i+1)+" ");
			for (int j=0;j<columns;j++)
			{
				text = text.concat(matrix[i][j]+" ");
			}

			text = String.format("%s%n",text);
		}
		
		return text;
	}
	
	public int getRows()
	{
		return rows;
	}
	
	public int getColumn()
	{
		return columns;
	}
	
	public String getCell(int row, int column)
	{
		return matrix[row-1][column-1];
	}
	
	//This method switches the values of the rows
	public void shiftRow(int SwapOne, int SwapTwo)
	{
		for (int i=0; i<columns; i++)
		{
			//The data in row two is placed into a temporary row
			temprows[i]=matrix[SwapTwo][i];
			
			//the data from row two is overwritten with the data from row one
			matrix[SwapTwo][i]=matrix[SwapOne][i];
			
			//the data in row one is overwritten with the data from the temporary row
			matrix[SwapOne][i]=temprows[i];
		}
	}
	
	//This method does the same as above, except we are working with the columns
	public void shiftColumn(int SwapOne, int SwapTwo)
	{
		for (int i=0; i<rows; i++)
		{
			temprows[i]=matrix[i][SwapTwo];
			matrix[i][SwapTwo]=matrix[i][SwapOne];
			matrix[i][SwapOne]=temprows[i];
		}
	}
	

}
