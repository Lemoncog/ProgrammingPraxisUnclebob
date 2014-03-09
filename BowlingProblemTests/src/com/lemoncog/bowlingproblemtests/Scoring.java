package com.lemoncog.bowlingproblemtests;
import org.junit.Assert;
import org.junit.Test;

import com.lemoncog.bowlProblem.BowlResult;
import com.lemoncog.bowlProblem.BowlResultHistory;
import com.lemoncog.bowlProblem.BowlingFrameTracker;
import com.lemoncog.bowlProblem.FrameProgress;
import com.lemoncog.bowlProblem.FrameTracker;


public class Scoring {
	@Test
	public void checkIsStrikeFirstRound() {
		FrameTracker frame = new BowlingFrameTracker();
		
		BowlResult result = frame.bowlResult(10);
		Assert.assertTrue(result.isStrike());
		Assert.assertFalse(result.isSpare());
	}
	
	@Test
	public void checkIsNotStrikeFirstRound(){
		FrameTracker frame = new BowlingFrameTracker();
		
		BowlResult result = frame.bowlResult(5);
		Assert.assertFalse(result.isStrike());
		Assert.assertFalse(result.isSpare());
	}
	
	@Test
	public void checkIsStrikeSecondRound()
	{
		FrameTracker frame = createFrameTracker(0,1);
		
		BowlResult result = frame.bowlResult(10);
		Assert.assertFalse(result.isStrike());
		Assert.assertTrue(result.isSpare());
	}
	
	@Test
	public void checkIsOpenFrameSecondRound()
	{
		FrameTracker frame = createFrameTracker(0,1);
		
		BowlResult result = frame.bowlResult(9);
		
		Assert.assertFalse(result.isStrike());
		Assert.assertFalse(result.isSpare());
		Assert.assertTrue(result.isOpenFrame());
	}
	
	@Test
	public void checkIsSpareFirstRound()
	{
		FrameTracker frame = createFrameTracker(0,0);
		
		BowlResult result = frame.bowlResult(10);
		
		Assert.assertFalse(result.isSpare());
	}
	
	@Test
	public void checkIsSpareSecondRound()
	{
	}
	
	@Test
	public void checkBowlingHistoryNewFrame()
	{
		BowlResultHistory history = new BowlResultHistory();
		history.start();
		
		Assert.assertEquals(0, history.getRoundCount());
	}
	
	@Test
	public void checkFrameTrackerNewFrame()
	{
		FrameTracker frameTracker = createFrameTracker(0, 0);
		
		frameTracker.newFrame();
		
		Assert.assertEquals(1, frameTracker.getProgress().getFrame());
	}
	
	@Test
	public void checkFrameTrackerNewRound()
	{
		FrameTracker frameTracker = createFrameTracker(0, 0);
		
		frameTracker.newRound();
		
		Assert.assertEquals(1, frameTracker.getProgress().getRound());		
	}
		
	private FrameTracker createFrameTracker(int startFrame, int startRound)
	{
		FrameTracker frame = new BowlingFrameTracker();
		
		FrameProgress progress = new FrameProgress();
		progress.setFrame(startFrame);
		progress.setRound(startRound);
		frame.setProgress(progress);
		
		return frame;
	}
}
