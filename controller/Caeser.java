package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CaeserFrame;
import view.MainFrame;

public class Caeser implements ActionListener {
	
	private MainFrame frame;
	private int key = 0;
	
	public Caeser(MainFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//The new frame is created, and the text to be manipulated is passed through
		new CaeserFrame(frame.getCypher(), key);
	}
	
	

}
