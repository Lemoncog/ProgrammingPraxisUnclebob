package com.lemoncog.bowlProblem;

public class BowlResult {

	private boolean mIsStrike;
	private boolean mIsSpare;
	private boolean mIsOpenFrame;
	private int mScore;
	
	public void setScore(int score) {
		mScore = score;
	}
	
	public int getScore() {
		return mScore;
	}

	public boolean isStrike() {
		return mIsStrike;
	}

	public void setStrike(boolean strike) {
		mIsStrike = strike;
	}
	
	public void setIsSpare(boolean isSpare) {
		mIsSpare = isSpare;
	}

	public boolean isSpare() {
		return mIsSpare;
	}
	
	public void setIsOpenFrame(boolean isOpenFrame) {
		mIsOpenFrame = isOpenFrame;
	}

	public boolean isOpenFrame() {
		return mIsOpenFrame;
	}

}
