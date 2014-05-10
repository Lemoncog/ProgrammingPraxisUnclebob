package com.lemoncog.bowlingKataTest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.lemoncog.bowlingKata.BowlingGame;

public class GameTests {
	
	private BowlingGame game;

	@Before
	public void setUp()
	{
		game = new BowlingGame();	
	}

	@Test
	public void testGameScoreIsExpectedSingleRound() 
	{
		int expectedScore = 5;
		
		game.roll(expectedScore);
		
		int actualScore = game.score();
		
		Assert.assertEquals(expectedScore, actualScore);
	}
	
	@Test
	public void testGameScoreIsExpectedTwoRounds()
	{
		int expectedScore = 10;
		
		game.roll(4);
		game.roll(6);
		
		int actualScore = game.score();
		
		Assert.assertEquals(expectedScore, actualScore);
	}
	
	@Test
	public void testGameScoreIsExpectedSpareNextRoll3()
	{
		int expectedScore = 16;
		
		game.roll(4);
		game.roll(6);
		game.roll(3);
		
		int actualScore = game.score();
		
		Assert.assertEquals(expectedScore, actualScore);
	}
	
	@Test
	public void testGameScoreIsExpected_ThirdRound_2Spares()
	{
		int expectedScore = 29;
		
		game.roll(4);
		game.roll(6);
		game.roll(3);
		game.roll(7);
		
		game.roll(3);
		
		int actualScore = game.score();
		
		Assert.assertEquals(expectedScore, actualScore);
	}
	
	@Test
	public void testFirstStrikeIsExpected()
	{
		int expectedScore = (10+5+3)+5+3; 
				
		game.roll(10);
		game.roll(5);
		game.roll(3);
		
		int actualScore = game.score();
		
		Assert.assertEquals(expectedScore, actualScore);
	}
	
	@Test
	public void testStrikeThirdRound()
	{
		int expectedScore = (5+3)+(1+4)+(10+4+2)+(4+2);
		
		game.roll(5);
		game.roll(3);
		
		game.roll(1);
		game.roll(4);
		
		game.roll(10);
		
		game.roll(4);
		game.roll(2);
		
		int actualScore = game.score();
		
		Assert.assertEquals(expectedScore, actualScore);
	}
	
	@Test
	public void testPerfectGame()
	{
		int expectedScore = 300;
		
		for(int i = 0; i < 12; i++)
		{
			game.roll(10);
		}
		
		int actualScore = game.score();
		
		Assert.assertEquals(expectedScore, actualScore);
	}
}
