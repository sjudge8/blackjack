package com.judge.blackjack;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck
{

	private ArrayList<Card> cards = new ArrayList<Card>(52);

	public Deck()
	{
		for (Card.Suit suit : Card.Suit.values())
		{
			for (Card.Rank rank : Card.Rank.values())
			{
				cards.add(new Card(suit, rank));
			}
		}
	}
	
	public void shuffleDeck()
	{
		ArrayList<Card> tmpDeck = new ArrayList<Card>();
		
		while(cards.size() > 0)
		{
			int randomNum = ThreadLocalRandom.current().nextInt(0, cards.size());
			tmpDeck.add(cards.remove(randomNum));
		}
		
		cards = tmpDeck;
	}
	
	public Card drawCard()
	{
		//draw next card if one is available, otherwise reshuffle deck
		if (cards.size() > 0)
		{
			return cards.remove(0);
		}
		else
		{
			shuffleDeck();
			return cards.remove(0);
		}
	}
		
	public ArrayList<Card> getCards()
	{
		return cards;
	}

	public String toString()
	{
		String output = "";
		
		for(int i=0; i < cards.size(); i++)
		{
			output += cards.get(i);
		}
		
		return output;
	}
}
