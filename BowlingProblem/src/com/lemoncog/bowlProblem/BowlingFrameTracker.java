package com.lemoncog.bowlProblem;

public class BowlingFrameTracker implements FrameTracker {

	private FrameProgress mProgress;
	
	public BowlingFrameTracker() {
		mProgress = new FrameProgress();
	}
	
	@Override
	public BowlResult bowlResult(BowlResultHistory history, int pinsHit) {

		BowlResult bowlResult = new BowlResult();
		bowlResult.setStrike(isStrike(history, pinsHit));
		bowlResult.setIsSpare(isSpare(history, pinsHit));
		bowlResult.setIsOpenFrame(isOpenFrame(history, pinsHit));
		bowlResult.setScore(pinsHit);

		return bowlResult;
	}
	
	private boolean isOpenFrame(BowlResultHistory history, int pinsHit)
	{
		return getProgress().isRound(1) && (history.getRoundCount() + pinsHit) < 10;
	}

	private boolean isStrike(BowlResultHistory history, int pinsHit) {
		return getProgress().isRound(0) && (history.getFrameScore() + pinsHit) == 10;
	}
	
	private boolean isSpare(BowlResultHistory history, int pinsHit)
	{
		return getProgress().isRound(1) && (history.getFrameScore() + pinsHit) == 10;
	}

	@Override
	public void setProgress(FrameProgress progress) {
		mProgress = progress;
	}
	
	public FrameProgress getProgress() {
		return mProgress;
	}
	
	@Override
	public void newFrame() {
		getProgress().setFrame(getProgress().getFrame()+1);
	}

	@Override
	public void newRound() {
		getProgress().setRound(getProgress().getRound()+1);
	}

}
