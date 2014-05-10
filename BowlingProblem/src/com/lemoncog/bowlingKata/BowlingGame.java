package com.lemoncog.bowlingKata;

public class BowlingGame {

	private int[] mRoundScores = new int[23];
	private int mRoundIndex = 0;

	public void roll(int score) {

		mRoundScores[mRoundIndex] = score;
		mRoundIndex++;
	}

	public int score() {
		int totalScore = 0;

		for (int i = 0; i < mRoundScores.length; i++) {
			totalScore += mRoundScores[i];

			if (isStrike(i) & !isLastFrame(i)) {
				totalScore += mRoundScores[i + 1] + mRoundScores[i + 2];
			} else if (isLastRoundASpare(i)) {
				totalScore += mRoundScores[i];
			}
		}

		return totalScore;
	}
	
	public boolean isLastFrame(int index)
	{
		return index >= 9;
	}

	public boolean isStrike(int index) {
		return mRoundScores[index] == 10;
	}

	public boolean isLastRoundASpare(int index) {
		int roundScore = 0;

		if (index > 1) {
			roundScore = mRoundScores[index - 2] + mRoundScores[index - 1];
		}

		return roundScore == 10;
	}
}
