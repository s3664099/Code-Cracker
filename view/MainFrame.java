package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.SubmitButton;
import model.CypherText;

//Create the main box where the initial text is entered
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JTextArea textEnter;
	private CypherText text;
	private MainToolBar toolbar;
	
	public MainFrame()
	{
		super("Code Cracker");
		
		setLayout(new BorderLayout());
		
		setSize(500,300);

		addToolBar();
		
		//A text area is created and added to the frame
		textEnter = new JTextArea();
		add(textEnter, BorderLayout.CENTER);
		
		//The submit button is added to the bottom
		//This button will take the text from the text area
		//And create an object where the text is stored so that it
		//Can be manipulated
		JButton submit = new JButton("Submit Text");
		submit.addActionListener(new SubmitButton(this));
		add(submit, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	//The method to extract the text from the text box
	public String getText()
	{
		return textEnter.getText();
	}
	
	//Creates a cypher text object to be passed around to the various methods
	public void setCypher(CypherText text)
	{
		this.text = text;
		
		//Revalidates the panel to activate the buttons'
		//now that the Cyphertext Object is no longer null
		remove(toolbar);
		addToolBar();
		revalidate();
		repaint();
		
	}
	
	//method to add the toolbar to the top of the frame
	private void addToolBar()
	{
		//The toolbar is generated and added to the frame
		//At the top. A copy of the frame is passed through
		//to the toolbar
		toolbar = new MainToolBar(this);
		add(toolbar, BorderLayout.NORTH);
	}
	
	//gets the CypherText object for manipulation
	public CypherText getCypher()
	{
		return text;
	}
	
}
