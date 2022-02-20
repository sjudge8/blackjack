package com.judge.blackjack;

//this class is for tracking the state of the cards on the table
public class Table {

	private Deck drawPile;
	private Deck discardPile;
	private Deck activeCards;
	
	public Table()
	{
		drawPile = new Deck();
		discardPile = new Deck().emptyDeck();
		activeCards = new Deck().emptyDeck();
	}
	
	public Card drawCard()
	{
		Card card;

		//draw next card if one is available, otherwise shuffle and use discardPile
		if (drawPile.size() > 0)
		{
			card = drawPile.removeCard();
			activeCards.addCard(card);
			return card;
		}
		else
		{
			drawPile = discardPile.clone();
			drawPile.shuffleDeck();
			return drawPile.removeCard();
		}
	}
	
	public void clear()
	{
		for(int i = 0; i < activeCards.size(); i++)
		{
			discardPile.addCard(activeCards.removeCard());
		}
	}
}
