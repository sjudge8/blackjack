package com.judge.blackjack;

public class App {

	public static void main(String[] args) {
		Game gm = new Game(4, 3);
		gm.simulate();
	}
	
	private static void test()
	{
		Deck testdeck = new Deck();
		System.out.println(testdeck);
		
		for(int i = 0; i < 47; i++)
		{
			Card tmpcard = testdeck.removeCard();
			System.out.println(tmpcard);
		}
		
		System.out.println(testdeck);
		
		Game gm = new Game(4, 3);
		gm.simulate();
	}
}
