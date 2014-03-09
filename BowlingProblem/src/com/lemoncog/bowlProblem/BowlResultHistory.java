package com.lemoncog.bowlProblem;

import java.util.ArrayList;
import java.util.List;

public class BowlResultHistory {

	private class Frame
	{
		private List<BowlResult> mRoundResults = new ArrayList<BowlResult>();
		
		public void addResult(BowlResult result)
		{
			mRoundResults.add(result);
		}
		
		private int getTotalScore()
		{
			int score = 0;
			
			for(int i = 0; i < mRoundResults.size(); i++)
			{
				score += mRoundResults.get(i).getScore();
			}
			
			return score;
		}

		public int getRoundCount() {
			return mRoundResults.size();
		}
	}
	
	private List<Frame> mFrameHistory = new ArrayList<BowlResultHistory.Frame>();
	

	public void start() {
		mFrameHistory.add(new Frame());
	}
	
	public void addHistory(BowlResult bowlResult) 
	{
		getActiveFrame().addResult(bowlResult);
	}
	
	private Frame getActiveFrame()
	{
		return mFrameHistory.get(mFrameHistory.size()-1);
	}

	public int getFrameScore() {
		return getActiveFrame().getTotalScore();
	}

	public int getRoundCount() {
		return getActiveFrame().getRoundCount();
	}

}
