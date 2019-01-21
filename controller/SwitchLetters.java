package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LetterCount;
import view.FrequencyAnalysis;
import view.SetMatrixFrame;

public class SwitchLetters implements ActionListener {

	LetterCount count;
	FrequencyAnalysis frame;
	
	public SwitchLetters(FrequencyAnalysis frame, LetterCount count) {
		
		this.count = count;
		this.frame = frame;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new SetMatrixFrame(frame, count);

	}

}
