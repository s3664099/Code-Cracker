import java.util.Scanner;

public class LetterCount {
	
	String word;
	int[] noLetter = new int[26];
	int[] noLetterSorted = new int[26];
	int[] noLetterUsed = new int[26];
	Scanner input = new Scanner(System.in);
	Letters letters = new Letters();
	
	public void run()
	{
		for (int i=0;i<noLetterSorted.length;i++)
		{
			noLetterSorted[i]=0;
			noLetterUsed[i]=-1;
		}
		
		letters.setLetters();
		
		resetCount();
		
		System.out.println("Please enter the word");
		word = input.nextLine();
		//word = word.toLowerCase();
		displayWord();
		countLetters();
		//sort();
		listLetters();
		
		System.out.println("\n\n");
		
		boolean end = false;
		
		do
		{
			changeLetter();
			
			System.out.println("Continue?");
			String query = input.nextLine();
			if (query.contentEquals("n"))
			{
				end = true;
			}
			
		}while(!end);
		
	}
	
	//GFS WMY OG LGDVS MF SFNKYHOSU ESLLMRS, PC WS BFGW POL DMFRQMRS, PL OG CPFU M UPCCSKSFO HDMPFOSXO GC OIS LMES DMFRQMRS DGFR SFGQRI OG CPDD GFS LISSO GK LG, MFU OISF WS NGQFO OIS GNNQKKSFNSL GC SMNI DSOOSK. WS NMDD OIS EGLO CKSJQSFODY GNNQKKPFR DSOOSK OIS 'CPKLO', OIS FSXO EGLO GNNQKKPFR DSOOSK OIS 'LSNGFU' OIS CGDDGWPFR EGLO GNNQKKPFR DSOOSK OIS 'OIPKU', MFU LG GF, QFOPD WS MNNGQFO CGK MDD OIS UPCCSKSFO DSOOSKL PF OIS HDMPFOSXO LMEHDS. OISF WS DGGB MO OIS NPHISK OSXO WS WMFO OG LGDVS MFU WS MDLG NDMLLPCY POL LYEAGDL. WS CPFU OIS EGLO GNNQKKPFR LYEAGD MFU NIMFRS PO OG OIS CGKE GC OIS 'CPKLO' DSOOSK GC OIS HDMPFOSXO LMEHDS, OIS FSXO EGLO NGEEGF LYEAGD PL NIMFRSU OG OIS CGKE GC OIS 'LSNGFU' DSOOSK, MFU OIS CGDDGWPFR EGLO NGEEGF LYEAGD PL NIMFRSU OG OIS CGKE GC OIS 'OIPKU' DSOOSK, MFU LG GF, QFOPD WS MNNGQFO CGK MDD LYEAGDL GC OIS NKYHOGRKME WS WMFO OG LGDVS. 
	
	public void displayWord()
	{	int j=0;
		for (int i=0;i<(word.length()/80);i++)
		{
			if (word.length()>((i+1)*20)-1)
			{
				System.out.println(word.substring(i*80, ((i+1)*80)));
				j=i;
			} else if (word.length()>(i*80) && word.length()<(((i+1)*80))) {
				System.out.println(word.substring(i*80));
			} else {
				continue;
			}
		}
		System.out.println(word.substring((j+1)*80)+"\n");
	}
	
	public void changeLetter()
	{
		System.out.println("Change letter:");
		String letterOne = input.nextLine();
		System.out.println("With letter");
		String letterTwo = input.nextLine();
		
		for (int i=0;i<word.length();i++)
		{
			if (letterOne.equalsIgnoreCase(word.substring(i, i+1)))
			{
				word = word.substring(0,i)+letterTwo+word.substring(i+1);
			} else if (letterTwo.equalsIgnoreCase(word.substring(i, i+1))) {
				word = word.substring(0,i)+letterOne+word.substring(i+1);
			}
		}		

		displayWord();
		
		resetCount();
		countLetters();
		//sort();
		listLetters();
		System.out.println();
	}
	
	public void listLetters()
	{
		for (int i=0;i<noLetter.length;i++)
		{
			System.out.print(letters.getLetter(i)+": "+noLetter[i]+"  ");
			
			if (i==13)
			{
				System.out.println();
			}
		}
	}
	
	public void sort()
	{
		int num1=0;
		int num2=0;
		for (int i=0;i<noLetter.length;i++)
		{
			num1=noLetter[i];
			for (int j=0;j<noLetter.length;j++)
			{
				if (noLetter[j]>noLetterSorted[i])
				{
					noLetterSorted[i]=j;
					num2=j;
				}
			}
			noLetter[i]=noLetterSorted[num2];
			num1=noLetter[num2];
		
		}
	}
	
	public void countLetters()
	{
		for (int i=0;i<word.length();i++)
		{
			for (int j=0;j<25;j++)
			{
				
				if(word.substring(i,i+1).equalsIgnoreCase(letters.getLetter(j)))
				{
					noLetter[j]++;
				}
			}
		}
	}
	
	public void resetCount()
	{
		for (int i=0;i<noLetter.length;i++)
		{
			noLetter[i]=0;
		}
	}

}
