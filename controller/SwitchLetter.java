package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LetterCount;
import view.FrequencyAnalysis;
import view.SetMatrixFrame;

public class SwitchLetter implements ActionListener {
	
	SetMatrixFrame setFrame;
	LetterCount count;
	FrequencyAnalysis frame;

	public SwitchLetter(SetMatrixFrame setFrame, FrequencyAnalysis frame, LetterCount count) {
		
		this.frame = frame;
		this.count = count;
		this.setFrame = setFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String firstLetter = setFrame.getFirstLetter();
		String secondLetter = setFrame.getSecondLetter();
		
		count.changeLetter(firstLetter, secondLetter);
		
		setFrame.dispose();
		
		frame.updateFrame(count);

	}

}
