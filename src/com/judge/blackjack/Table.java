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

		//if the draw pile is empty we need to re-fill it from the discard pile
		if (drawPile.size() == 0)
		{
			drawPile = discardPile.clone();
			drawPile.shuffleDeck();
			discardPile.emptyDeck();
		}
					
		card = drawPile.removeCard();
		activeCards.addCard(card);
		return card;
	}
	
	public void clear()
	{
		int activeSize = activeCards.size();
		for(int i = 0; i < activeSize; i++)
		{
			discardPile.addCard(activeCards.removeCard());
		}
	}
}
