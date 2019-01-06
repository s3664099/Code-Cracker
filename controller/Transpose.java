package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.SetMatrixFrame;

public class Transpose implements ActionListener {

	private MainFrame frame;
	
	public Transpose(MainFrame frame) {

		this.frame = frame;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		//Fires up a frame to set up the matrix for the
		//double transposition
		new SetMatrixFrame(frame.getCypher());

	}

}
