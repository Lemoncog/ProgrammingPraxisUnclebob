package com.lemoncog.bowlProblem;

public interface FrameTracker {

	BowlResult bowlResult(int pinsHit);
	void setProgress(FrameProgress progress);
	FrameProgress getProgress();
	void newFrame();
	void newRound();

}
