package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FrequencyAnalysis;
import view.MainFrame;

public class Frequency implements ActionListener {

	private MainFrame frame;
	
	public Frequency(MainFrame frame) {

		this.frame = frame;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		//Fires up a frame to set up the matrix for the
		//double transposition
		new FrequencyAnalysis(frame.getCypher());

	}

}
