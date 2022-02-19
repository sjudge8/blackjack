package com.judge.blackjack;

public class App {

	public static void main(String[] args) {
		test();
	}
	
	private static void test()
	{
		Deck testdeck = new Deck();
		System.out.println(testdeck);
		
		testdeck.shuffleDeck();
		System.out.println(testdeck);
		System.out.println("Full deck is size " + testdeck.getCards().size());
		
		for(int i = 0; i < 10; i++)
		{
			Card tmpcard = testdeck.drawCard();
			System.out.println(tmpcard);
		}
		
		System.out.println(testdeck);
		System.out.println("Deck after drawings is size " + testdeck.getCards().size());
	}
}
