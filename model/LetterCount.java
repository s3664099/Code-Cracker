package model;
import java.util.ArrayList;

public class LetterCount {
	
	String mainText;
	int[] noLetter = new int[26];
	int[] noLetterSorted = new int[26];
	int[] noLetterUsed = new int[26];
	Letters letters = new Letters();
	ArrayList<String> textLines = new ArrayList<String>();
		
	//This method splits the text into lines of 40 columns each
	public void splitText(String mainText)
	{
		//clears the ArrayList
		textLines.clear();
		
		this.mainText = mainText;
		//These variables determine the position in the text
		//and the length of the lines. The position is basically
		//the row they are at.
		int position = 1;
		int lineLength = 80;
		int i;
		
		for (i=0;i<mainText.length(); i++)
		{
			//Checks to see if the end of the row had been reached
			if (i==lineLength*position)
			{
				//if so, it splits the text and adds it to the array list
				textLines.add(mainText.substring(lineLength*(position-1), 
						(lineLength*position)-1));
				position++;
			}
		}
		
		//The final section of the text, which is no doubt less than the length of the line
		//is added to the array list.
		textLines.add(mainText.substring(lineLength*(position-1),i-1));
				
	}
	
	public ArrayList<String> getMessage()
	{
		return textLines;
	}
	
	//This method goes through the message and counts the frequency of the letters
	public void countLetters()
	{
		//This cycles through each of the letters in the message
		for (int i=0;i<mainText.length();i++)
		{
			//This compares the selected letter with each of the letters in the alphabet
			for (int j=0;j<25;j++)
			{
				
				//If there is a match, then the number of the particular letter is increased
				//by one
				if(mainText.substring(i,i+1).equalsIgnoreCase(letters.getLetter(j)))
				{
					noLetter[j]++;
				}
			}
		}
	}
	
	//This method returns a string containing the frequency of each of the letters
	public String listLetters()
	{
		String letterFrequency = "";
		
		//Goes through each of the letters and add the letter and the frequency
		//to the string
		for (int i=0;i<noLetter.length;i++)
		{
			letterFrequency = letterFrequency.concat(letters.getLetter(i)+":"+noLetter[i]+" ");
		}
		
		//The count is reset as we are returning the details as a String
		//This enables the count to be used again when needed
		resetCount();
		
		return letterFrequency;
	}
	
	//Resets the letter count so that it can be redone
	private void resetCount()
	{
		for (int i=0;i<noLetter.length;i++)
		{
			noLetter[i]=0;
		}
	}
	
	//This method will change the letters from one to another
	public void changeLetter(String letterOne, String letterTwo)
	{
		
		//First the main text is cycled through
		for (int i=0;i<mainText.length();i++)
		{
			//if the first letter is encounters
			if (letterOne.equalsIgnoreCase(mainText.substring(i, i+1)))
			{
				//that letter is changed to the second letter
				mainText = mainText.substring(0,i)+letterTwo+mainText.substring(i+1);
			} else if (letterTwo.equalsIgnoreCase(mainText.substring(i, i+1))) {

				//and when the second letter is encountered it is changed
				//to the first
				mainText = mainText.substring(0,i)+letterOne+mainText.substring(i+1);
			}
		}
		
		//The text is once again split
		splitText(mainText);
		
	}
			
}
