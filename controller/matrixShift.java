package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MatrixCode;
import view.DoubleTransposeFrame;
import view.SetMatrixFrame;

public class matrixShift implements ActionListener {

	String type;
	MatrixCode matrix;
	DoubleTransposeFrame frame;
	
	public matrixShift(String type, MatrixCode matrix, DoubleTransposeFrame frame) {

		this.type = type;
		this.matrix = matrix;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		new SetMatrixFrame(type, matrix, frame);
		
	}

}
