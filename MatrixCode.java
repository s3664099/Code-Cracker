import java.util.Scanner;

public class MatrixCode {
	
	private int rows;
	private int columns;
	String[][] matrix;
	String[] temprows;
	String[] tempcol;
	Scanner input = new Scanner(System.in);
	
	public void run()
	{
		System.out.println("How many rows?");
		rows = input.nextInt();
		String enter = input.nextLine();
		
		System.out.println("How many columns?");
		columns = input.nextInt();
		enter = input.nextLine();
		
		matrix = new String[rows][columns];
		tempcol = new String[columns];
		temprows = new String[rows];
		
		enterMatrix();
		System.out.println();
		printMatrix();
		
		boolean cont = false;
		
		do {
			System.out.println("Shift Row (r) or Column (c)");
			String shift = input.nextLine();
		
			System.out.println("Shift what");
			int SwapOne = input.nextInt();
			enter = input.nextLine();
		
			System.out.println("with what");
			int SwapTwo = input.nextInt();
			enter = input.nextLine();
			
			if (shift.contentEquals("r"))
			{
				shiftRow(SwapOne-1, SwapTwo-1);
			} else if (shift.contentEquals("c")) {
				shiftColumn(SwapOne-1, SwapTwo-1);
			} else {
				System.out.println("Please enter R or C");
			}
			
			printMatrix();
			
			System.out.println("Go Again");
			String query = input.nextLine();
			
			if (query.equalsIgnoreCase("n"))
			{
				cont = true;
			}
			
		} while (!cont);

	}
	
	public void enterMatrix()
	{
		for (int i=0;i<rows;i++)
		{
			for (int j=0;j<columns;j++)
			{
				System.out.println("Letter:");
				matrix[i][j] = input.nextLine();
			}
		}
	}
	
	public void printMatrix()
	{
		System.out.print("  ");
		for (int i=0;i<columns;i++)
		{
			System.out.print((i+1)+" ");
		}
		System.out.println();
		
		for (int i=0;i<rows;i++)
		{
			System.out.print((i+1)+" ");
			for (int j=0;j<columns;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void shiftRow(int SwapOne, int SwapTwo)
	{
		for (int i=0; i<columns; i++)
		{
			tempcol[i]=matrix[SwapTwo][i];
			matrix[SwapTwo][i]=matrix[SwapOne][i];
			matrix[SwapOne][i]=tempcol[i];
		}
	}
	
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
