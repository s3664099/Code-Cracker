package model;

public class Letters {
	
	String[] letters = new String[26];
	
	//A class that contains all the letters of the alphabet
	public Letters()
	{
		letters[0]="a";
		letters[1]="b";
		letters[2]="c";
		letters[3]="d";
		letters[4]="e";
		letters[5]="f";
		letters[6]="g";
		letters[7]="h";
		letters[8]="i";
		letters[9]="j";
		letters[10]="k";
		letters[11]="l";
		letters[12]="m";
		letters[13]="n";
		letters[14]="o";
		letters[15]="p";
		letters[16]="q";
		letters[17]="r";
		letters[18]="s";
		letters[19]="t";
		letters[20]="u";
		letters[21]="v";
		letters[22]="w";
		letters[23]="x";
		letters[24]="y";
		letters[25]="z";
	}
	
	//this returns the letter at position i
	public String getLetter(int i)
	{
		return letters[i];
	}

}
