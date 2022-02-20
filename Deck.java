package com.judge.blackjack;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck
{

	private ArrayList<Card> cards;

	public Deck()
	{
		cards = new ArrayList<Card>(52);

		for (Card.Suit suit : Card.Suit.values())
		{
			for (Card.Rank rank : Card.Rank.values())
			{
				cards.add(new Card(suit, rank));
			}
		}
		
		shuffleDeck();
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
	
	public Card removeCard()
	{
		return cards.remove(0);
	}
	
	public void addCard(Card card)
	{
		cards.add(card);
	}
	
	public Deck emptyDeck()
	{
		cards = new ArrayList<Card>();
		return this;
	}
	
	public int size()
	{
		return cards.size();
	}

	public Deck clone()
	{
		Deck destination = new Deck().emptyDeck();
		
		for (Card c : cards)
		{
			destination.addCard(c);
		}
		
		return destination;
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
