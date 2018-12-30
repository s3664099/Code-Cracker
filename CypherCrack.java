import java.util.Scanner;

/**
 * @author David
 *
 */
public class CypherCrack {
	
	Scanner input = new Scanner(System.in);
	String word;
	int[] number = new int[30];
	Letters letters = new Letters();
	int key=1;
	int count = 0;
	
	public void run()
	{	
		letters.setLetters();
		
		System.out.println("Please enter the code");
		word = input.nextLine();
		
		word = word.toLowerCase();
		
		checkWord();
		
		boolean end = false;
		
		do
		{
			changeLetters();
			System.out.println(count+") "+word);
			System.out.println();
			System.out.println("Again?");
			String answer = input.nextLine();
			
			if (answer.equals("n"))
			{
				end = true;
			}
			
		} while(!end);
		
	}
	
	//UMYTMHUZSRGZ  
	
	public void changeLetters()
	{
		for (int i=0; i<word.length(); i++)
		{
			number[i]=number[i]+key;
			if (number[i]>25)
			{
				number[i]=0;
			} else if (number[i]<0) {
				number[i]=25;
			}
			word = word.substring(0,i)+letters.getLetter(number[i])+word.substring(i+1);
		}
		count++;
	}
	
	public void checkWord()
	{
		for (int i=0;i<word.length();i++)
		{
			for (int j=0;j<26;j++)
			{
				if(word.substring(i,i+1).equals(letters.getLetter(j)))
				{
					number[i]=j;
				}
			}
		}	
	}

}
