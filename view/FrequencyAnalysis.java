package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.SwitchLetters;
import model.CypherText;
import model.LetterCount;

@SuppressWarnings("serial")
public class FrequencyAnalysis extends JFrame {

	CypherText text;
	String mainText;
	LetterCount count = new LetterCount();
	String letters;
	CentrePanel centre;
	JLabel letterFrequency;
	
	//this text was used for testing purposes to make sure the array list worked 
	//mainText="GFS WMY OG LGDVS MF SFNKYHOSU ESLLMRS, PC WS BFGW POL DMFRQMRS, PL OG CPFU M UPCCSKSFO HDMPFOSXO GC OIS LMES DMFRQMRS DGFR SFGQRI OG CPDD GFS LISSO GK LG, MFU OISF WS NGQFO OIS GNNQKKSFNSL GC SMNI DSOOSK. WS NMDD OIS EGLO CKSJQSFODY GNNQKKPFR DSOOSK OIS 'CPKLO', OIS FSXO EGLO GNNQKKPFR DSOOSK OIS 'LSNGFU' OIS CGDDGWPFR EGLO GNNQKKPFR DSOOSK OIS 'OIPKU', MFU LG GF, QFOPD WS MNNGQFO CGK MDD OIS UPCCSKSFO DSOOSKL PF OIS HDMPFOSXO LMEHDS. OISF WS DGGB MO OIS NPHISK OSXO WS WMFO OG LGDVS MFU WS MDLG NDMLLPCY POL LYEAGDL. WS CPFU OIS EGLO GNNQKKPFR LYEAGD MFU NIMFRS PO OG OIS CGKE GC OIS 'CPKLO' DSOOSK GC OIS HDMPFOSXO LMEHDS, OIS FSXO EGLO NGEEGF LYEAGD PL NIMFRSU OG OIS CGKE GC OIS 'LSNGFU' DSOOSK, MFU OIS CGDDGWPFR EGLO NGEEGF LYEAGD PL NIMFRSU OG OIS CGKE GC OIS 'OIPKU' DSOOSK, MFU LG GF, QFOPD WS MNNGQFO CGK MDD LYEAGDL GC OIS NKYHOGRKME WS WMFO OG LGDVS.";
			
	
	//A collection that makes up the text. Since the text is long
	//(or is usually long) then this is used to display the text
	//on the panel
	ArrayList<String> textLines = new ArrayList<String>();
	
	public FrequencyAnalysis(CypherText text)
	{
		super("Frequency Analysis");
		setLayout(new BorderLayout());
		setSize(800,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		mainText = text.getCypherText();
		
		setText();
		
		addPanels();
		
		//Creates the button to allow letters to be switched
		JButton button = new JButton("Switch Letters");
		button.addActionListener(new SwitchLetters(this, count));
		add(button,BorderLayout.NORTH);
		

		setVisible(true);
	}
	
	//This method calls the LetterCount class to set the message and the
	//Frequency of the letters to be displayed
	private void setText()
	{
		count.splitText(mainText);
		countLetters();

	}
	
	//This method produces the frequency that the letters appear in the message
	private void countLetters()
	{
		count.countLetters();
		letters = count.listLetters();
	}
	
	private void addPanels()
	{
		centre = new CentrePanel(count);
		letterFrequency = new JLabel(letters);
		add(centre, BorderLayout.CENTER);
		add(letterFrequency, BorderLayout.SOUTH);
		
	}
	
	public void updateFrame(LetterCount count)
	{
		this.count = count;
		countLetters();
		remove(centre);
		remove(letterFrequency);
		addPanels();
		revalidate();
		repaint();
	}
	
}
