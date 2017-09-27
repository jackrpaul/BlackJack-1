import java.util.Scanner;
import java.util.*;
public class Driver
	{
		public static int numberOfHitsUser = 1;
		public static int totalValueSelf = 0;
		public static int totalValueUser = 0;
		public static String easyOrHard = "null";
	
	public static void main(String[] args)
	
		{
			
			//tellUserWhatIsHappening();
			//askEasyOrLessEasy();
			Deck.generateCards();
			Deck.hitSelfFirst();
			Deck.hitUser();
			do{
				Deck.hitUser();
				Deck.hitSelf();
			}
			while(underTwentyOne() && userPlaying());
			AI.checkCardsSelf();
			checkCards();
			
			System.out.println( "Self is: " + totalValueSelf + " User is: " + totalValueUser); // this is for trouble shooting
		}



	private static void tellUserWhatIsHappening()
		{
			Scanner doesUserPlay = new Scanner(System.in);
			System.out.println("Were going to play a game of BlackJack.");
			System.out.println("The object of this game is to get the closest to 21 without going over.");
			System.out.println("Jack, Queen, and King are all worth 10.");
			System.out.println("Press Enter to play!");
			String notNeeded = doesUserPlay.nextLine();
		}
	private static void askEasyOrLessEasy()
		{
			Scanner eOrH = new Scanner(System.in);
			System.out.println("Do you want to play easy or hard?");
			easyOrHard = eOrH.nextLine();
			
		}
	private static boolean userPlaying()
		{
			Scanner yesOrNo = new Scanner(System.in);
			System.out.println("Do you want a hit?");
			String yeeOrNee = yesOrNo.nextLine();
			
			if(yeeOrNee.equals("Yes") || yeeOrNee.equals("yes")){
				return true;
			}
			else if(yeeOrNee.equals("No") || yeeOrNee.equals("no")){
				return false;
			}
			else{
				return false;
			}
			
		}

	private static boolean underTwentyOne()
		{
			if((totalValueUser > 22)){
				checkAces();
				if(totalValueUser > 22){
					return false;
				}
				else{
					return true;
				}
				
			}
			else{
				return true;
			}
		}
	private static void checkCards()
		{
			if(totalValueUser < 22){
				if((totalValueUser < totalValueSelf) && (totalValueSelf < 22)){
					System.out.println("You Lose :(");
				}					
				else if(totalValueUser > totalValueSelf){
					System.out.println("You Win!!");
				}
				else if(totalValueUser == totalValueSelf){
					System.out.println("It's a Tie!");
				}
			}
			else{
				System.out.println("You Lose :(");
			}
			
		}

	private static void checkAces()
		{
			if(Deck.numberOfAces > 0){
				if(totalValueUser > 22){
					totalValueUser = totalValueUser - 10;
				}
			}
			
		}
	}
