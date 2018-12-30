package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Shift;
import model.CypherText;

@SuppressWarnings("serial")
public class CaeserFrame extends JFrame {
	
	private int key;
	private JButton button;
	private CypherText text;
	
	public CaeserFrame (CypherText text, int key)
	{
		//Creates the panel
		super("Caeser Cypher Encoder and Decoder");
		
		this.key = key;
		this.text = text;
		
		setSize(400,150);
		
		setLayout(new GridLayout(3,3));
		
		//Displays the key at the top - shows how far the cyoher
		//has moved
		add(new JLabel("Key:"));
		add(new JLabel(""+key));
		add(new JLabel());
		add(new JLabel());
		
		//Displays the cypher text in the middle
		add(new JLabel(text.getCypherText()));
		add(new JLabel());
		
		//The button for shifting the cypher left
		button = new JButton("Shift Left");
		button.addActionListener(new Shift("left", text, this, key));
		add(button);
		add(new JLabel());
		
		//The button for shifting the cypher right
		button = new JButton("Shift Right");
		button.addActionListener(new Shift("right", text, this, key));
		add(button);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	//updates the value of the transposition key
	public void setKey(int key)
	{
		this.key = this.key+key;
	}
	
	public void updateFrame(String text, int key)
	{
		setKey(key);
		this.text.setCypherText(text);
		setVisible(false);
		setVisible(true);
		
	}

}
