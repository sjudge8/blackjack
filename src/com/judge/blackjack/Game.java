package com.judge.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private int numPlayers;
	private int numRounds;
	private Deck deck;
	
	public Game(int numPlayers, int numRounds)
	{
		this.numPlayers = numPlayers;
		this.numRounds = numRounds;
		deck = new Deck();
	}
	
	private void simulateRound()
	{
		int highScore = 0, score;
		ArrayList<Integer> winners = new ArrayList<Integer>();
		
		deck.shuffleDeck();
		
		for (int i = 1; i < numPlayers + 1; i++)
		{
			score = simulateHand();
			
			if(score > highScore && score < 22)
			{
				winners.clear();
				winners.add(i);
				highScore = score;
			}
			else if(score == highScore)
			{
				winners.add(i);
			}
		}
		
		printRoundResult(winners);		
		
	}
	
	//returns value of the hand
	private int simulateHand()
	{
		Card card1, card2;
		
		card1 = deck.drawCard();
		card2 = deck.drawCard();
		
		System.out.print(card1);
		System.out.println(card2);
		
		return card1.getValue() + card2.getValue();
	}

	//given a list of the player numbers who wons, print the result
	private void printRoundResult(List<Integer> winners)
	{
		String roundSummary;
		
		if(winners.size() > 1)
		{
			roundSummary = "Players " + winners.remove(0);
			
			for (int winner : winners)
			{
				roundSummary += " and " + winner;
			}
			
			roundSummary += " have tied for the win!";
		}
		else if(winners.size() == 1)
		{
			roundSummary = "Player " + winners.remove(0) + " has won this round!";
		}
		else
		{
			//this shouldn't be a reachable state
			roundSummary = "Error in determining the winner!";
		}
		
		System.out.println(roundSummary + "\n");
	}
	
	public void simulate()
	{
		for (int i = 0; i < numRounds; i++)
		{
			simulateRound();
		}
	}
	
}
