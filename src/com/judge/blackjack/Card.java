package com.judge.blackjack;

public class Card
{
	enum Rank
	{
	    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
	    	TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
		
		private final int value;
	    
	    private Rank(int value)
	    {
	    	this.value = value;
	    }
	    
	    public int getValue()
	    {
	    	return value;
	    }
	}
	
	enum Suit
	{
		SPADES, CLUBS, DIAMONDS, HEARTS
	}

	private Rank rank;
	private Suit suit;
	private int value;
	
	public Card(Suit suit, Rank rank)
	{
		this.rank = rank;
		this.suit = suit;
		this.value = rank.getValue();
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	private String getSuitString()
	{
		if(this.suit.equals(Suit.SPADES))
		{
			return "S";
		}
		else if(this.suit.equals(Suit.CLUBS))
		{
			return "C";
		}
		else if(this.suit.equals(Suit.DIAMONDS))
		{
			return "D";
		}
		else if(this.suit.equals(Suit.HEARTS))
		{
			return "H";
		}
		else
		{
			//this shouldnt be reachable
			throw new IllegalArgumentException("Card.getSuitString() failed");
		}
	}
	
	private String getRankString()
	{
		if(rank.value < 10)
		{
			return String.valueOf(value);
		}
		else if(rank.equals(Rank.TEN))
		{
			return "10";
		}
		else if(rank.equals(Rank.JACK))
		{
			return "J";
		}
		else if(rank.equals(Rank.QUEEN))
		{
			return "Q";
		}
		else if(rank.equals(Rank.KING))
		{
			return "K";
		}
		else if(rank.equals(Rank.ACE))
		{
			return "A";
		}
		else
		{
			//this shouldnt be reachable
			throw new IllegalArgumentException("Card.getValueString() failed");
		}
	}
	
	public String toString()
	{
			String display = getRankString() + getSuitString();
			
			if(display.length() == 2)
				return "| " + display + " |";
			else if(display.length() == 3)
				return "|" + display + " |";
			else
				throw new IllegalArgumentException("Card.toString() failed. Length of Rank+Suit is wrong.");

	}
}