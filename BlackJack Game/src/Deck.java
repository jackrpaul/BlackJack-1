import java.util.ArrayList;
import java.util.Collections;
import java.util.*;


public class Deck
	{
		public static int numberOfAces = 0;
		//changed numberOfAcesSelf to numberOfAcesCPU to avoid confusion
		public static int numberOfAcesCPU = 0;
		static ArrayList <Card> deck = new ArrayList <Card> ( );
		static ArrayList <String> selfRank = new ArrayList <String> ( );
		static ArrayList <String> selfSuit = new ArrayList <String> ( );
		
		public static void generateCards()
			{
				deck.add(new Card("Two" , "Clubs" , 2));
				deck.add(new Card("Three" , "Clubs" , 3));
				deck.add(new Card("Four" , "Clubs" , 4));
				deck.add(new Card("Five" , "Clubs" , 5));
				deck.add(new Card("Six" , "Clubs" , 6));
				deck.add(new Card("Seven" , "Clubs" , 7));
				deck.add(new Card("Eight" , "Clubs" , 8));
				deck.add(new Card("Nine" , "Clubs" , 9));
				deck.add(new Card("Ten" , "Clubs" , 10));
				deck.add(new Card("Queen" , "Clubs" , 10));
				deck.add(new Card("King" , "Clubs" , 10));
				deck.add(new Card("Jack" , "Clubs" , 10));
				deck.add(new Card("Ace" , "Clubs" , 11));
				deck.add(new Card("Two" , "Hearts" , 2));
				deck.add(new Card("Three" , "Hearts" , 3));
				deck.add(new Card("Four" , "Hearts" , 4));
				deck.add(new Card("Five" , "Hearts" , 5));
				deck.add(new Card("Six" , "Hearts" , 6));
				deck.add(new Card("Seven" , "Hearts" , 7));
				deck.add(new Card("Eight" , "Hearts" , 8));
				deck.add(new Card("Nine" , "Hearts" , 9));
				deck.add(new Card("Ten" , "Hearts" , 10));
				deck.add(new Card("Queen" , "Hearts" , 10));
				deck.add(new Card("King" , "Hearts" , 10));
				deck.add(new Card("Jack" , "Hearts" , 10));
				deck.add(new Card("Ace" , "Hearts" , 11));
				deck.add(new Card("Two" , "Spades" , 2));
				deck.add(new Card("Three" , "Spades" , 3));
				deck.add(new Card("Four" , "Spades" , 4));
				deck.add(new Card("Five" , "Spades" , 5));
				deck.add(new Card("Six" , "Spades" , 6));
				deck.add(new Card("Seven" , "Spades" , 7));
				deck.add(new Card("Eight" , "Spades" , 8));
				deck.add(new Card("Nine" , "Spades" , 9));
				deck.add(new Card("Ten" , "Spades" , 10));
				deck.add(new Card("Queen" , "Spades" , 10));
				deck.add(new Card("King" , "Spades" , 10));
				deck.add(new Card("Jack" , "Spades" , 10));
				deck.add(new Card("Ace" , "Spades" , 11));
				deck.add(new Card("Two" , "Diamonds" , 2));
				deck.add(new Card("Three" , "Diamonds" , 3));
				deck.add(new Card("Four" , "Diamonds" , 4));
				deck.add(new Card("Five" , "Diamonds" , 5));
				deck.add(new Card("Six" , "Diamonds" , 6));
				deck.add(new Card("Seven" , "Diamonds" , 7));
				deck.add(new Card("Eight" , "Diamonds" , 8));
				deck.add(new Card("Nine" , "Diamonds" , 9));
				deck.add(new Card("Ten" , "Diamonds" , 10));
				deck.add(new Card("Queen" , "Diamonds" , 10));
				deck.add(new Card("King" , "Diamonds" , 10));
				deck.add(new Card("Jack" , "Diamonds" , 10));
				deck.add(new Card("Ace" , "Diamonds" , 11));
				  
				Collections.shuffle(deck);
			}
		
		public static void hitUser()
			{
				Collections.shuffle(deck);

				int numberOfValue = deck.get(0).getValue();
				
				if (numberOfValue == 11)
					{
						numberOfAces++;
						Driver.totalValueUser = Driver.totalValueUser + numberOfValue;

						System.out.println("You were dealt a " + deck.get(0).getSuit() + " of " + deck.get(0).getRank() + ".");
					} 
				else
					{
						Driver.totalValueUser = Driver.totalValueUser + numberOfValue;

						
						System.out.println("You were dealt a " + deck.get(0).getSuit() + " of " + deck.get(0).getRank() + ".");
					}
				System.out.println();

			}
		//changed hitSelf to hitCPU to avoid confusion
		public static void hitCPU()
			{
	Collections.shuffle(deck);
	
	int numberOfValue = deck.get(0).getValue();
	
	selfRank.add(deck.get(0).getRank());
	selfSuit.add(deck.get(0).getSuit());
	
	
		if (numberOfValue == 11)
			{
				numberOfAcesCPU++;
				Driver.totalValueCPU = Driver.totalValueCPU + numberOfValue;
			} 
	else
				{
					Driver.totalValueCPU = Driver.totalValueCPU + numberOfValue;
				}
		
			}

		public static void hitSelfFirst()
	{
		hitCPU();
		
		System.out.println("The Dealer is showing a " + deck.get(0).getSuit() + " of " + deck.get(0).getRank() + ".");
		
		System.out.println();
	}

		public static void hitUserFirst()
	{
		Collections.shuffle(deck);
		
		int numberOfValue = deck.get(0).getValue();
		int numberOfSecondValue = deck.get(1).getValue();
		
		if((numberOfValue == 11) && (numberOfSecondValue == 11))
		{
			numberOfAces = numberOfAces + 2;
			System.out.println("You were dealt a " + deck.get(0).getSuit() + " of " + deck.get(0).getRank() + " and a " + deck.get(1).getSuit() + " of " + deck.get(1).getRank() + ".");
			Driver.totalValueUser += (numberOfValue + numberOfSecondValue);
			//added remove statements to lessen deck and up strategic value of the game
			deck.remove(deck.get(0));
			deck.remove(deck.get(1));
		}
		else if((numberOfValue == 11) || (numberOfSecondValue == 11))
		{
			numberOfAces++;
			System.out.println("You were dealt a " + deck.get(0).getSuit() + " of " + deck.get(0).getRank() + " and a " + deck.get(1).getSuit() + " of " + deck.get(1).getRank() + ".");
			Driver.totalValueUser += (numberOfValue + numberOfSecondValue);
			deck.remove(deck.get(0));
			deck.remove(deck.get(1));
		}
		else
			{
			System.out.println("You were dealt a " + deck.get(0).getSuit() + " of " + deck.get(0).getRank() + " and a " + deck.get(1).getSuit() + " of " + deck.get(1).getRank() + ".");
			Driver.totalValueUser += (numberOfValue + numberOfSecondValue);
			deck.remove(deck.get(0));
			deck.remove(deck.get(1));
			}
		System.out.println();
		
	}


}