package model;

public class CaeserTextShift {

	private String text;
	private Letters letters = new Letters(); //The object containing the letters
	private int[] number; //An array the size of the text containing the location of the letters
	private int nonLetter=27; //This represents a non-letter
	
	public CaeserTextShift(String text)
	{
		this.text = text;
		
		//The length of the text field is determined and an integer is
		//recorded for each position
		number = new int[text.length()];
		
		//the default value is 27, representing a non letter
		//this is to prevent the program from crashing if a letter isn't
		//in the aphabet.
		for (int i=0; i<number.length; i++)
		{
			number[i]=nonLetter;
		}
	}
	
	//The method for shifting each of the letters in the word
	//The key is passed through, either one to the left, or one to the right
	public String ShiftWord(int shiftKey)
	{
		//cycles through each character in the text
		for(int i=0; i<text.length(); i++)
		{
			//Checks to see if it is a letter
			if (number[i]!=nonLetter)
			{	
				//If it is, shifts the letter based on the direction
				number[i]=number[i]+shiftKey;
				
				//if the letter is z, then it becomes an a
				//thus cycling back to the beginning of the alphabet
				if (number[i]>25)
				{
					number[i]=0;
				//if the letter is an a, it becomes a z
				//thus cycling to the end of the alphabet
				} else if (number[i]<0) {
					number[i]=25;
				}
				//the text is updated with the new letters
				//The text is broken down into the string prior to the letter and the
				//string after the letter. The particular letter is changed.
				text = text.substring(0,i)+letters.getLetter(number[i])+text.substring(i+1);
			}
		}
				
		return text;
		
	}
	
	//This method checks the letters in the word
	public void checkWord()
	{
		//Each of the characters in the text is examined
		for (int i=0;i<text.length();i++)
		{
			//The character is compared to each of the letters of the alphabet
			for (int j=0;j<26;j++)
			{
				//If the character corresponds to a letter, the position of the letter
				//in the alphabet is recorded.
				if(text.substring(i,i+1).equals(letters.getLetter(j)))
				{
					number[i]=j;
				} 
			}
		}	
	}
}
