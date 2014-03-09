package com.lemoncog.bowlProblem;

public interface FrameTracker {

	BowlResult bowlResult(BowlResultHistory history, int pinsHit);
	void setProgress(FrameProgress progress);
	FrameProgress getProgress();
	void newFrame();
	void newRound();

}
