package com.lemoncog.bowlProblem;

public class FrameProgress {

	private int mFrame;
	private int mRound;
	
	public void setRound(int round) {
		mRound = round;
	}
	
	public int getRound() {
		return mRound;
	}
	
	public void setFrame(int frame) {
		mFrame = frame;
	}
	
	public int getFrame() {
		return mFrame;
	}

	public boolean isRound(int round) {
		return getRound() == round;
	}

}
