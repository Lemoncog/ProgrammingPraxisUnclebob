package com.lemoncog.bowlProblem;

public class BowlingFrameTracker implements FrameTracker {

	private FrameProgress mProgress;
	private BowlResultHistory mBowlResultHistory;
	
	public BowlingFrameTracker() {
		mProgress = new FrameProgress();
		mBowlResultHistory = new BowlResultHistory();
		mBowlResultHistory.start();
	}
	
	@Override
	public BowlResult bowlResult(int pinsHit) {

		BowlResult bowlResult = new BowlResult();
		bowlResult.setStrike(isStrike(pinsHit));
		bowlResult.setIsSpare(isSpare(pinsHit));
		bowlResult.setIsOpenFrame(isOpenFrame(pinsHit));
		bowlResult.setScore(pinsHit);

		return bowlResult;
	}
	
	private boolean isOpenFrame(int pinsHit)
	{
		return getProgress().isRound(1) && (getBowlResultHistory().getRoundCount() + pinsHit) < 10;
	}

	private boolean isStrike(int pinsHit) {
		return getProgress().isRound(0) && (getBowlResultHistory().getRoundScore() + pinsHit) == 10;
	}
	
	private boolean isSpare(int pinsHit)
	{
		return getProgress().isRound(1) && (getBowlResultHistory().getRoundScore() + pinsHit) == 10;
	}

	@Override
	public void setProgress(FrameProgress progress) {
		mProgress = progress;
	}
	
	public FrameProgress getProgress() {
		return mProgress;
	}
	
	public BowlResultHistory getBowlResultHistory() {
		return mBowlResultHistory;
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
