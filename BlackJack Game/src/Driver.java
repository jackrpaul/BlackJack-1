import java.util.Scanner;
import java.util.*;
public class Driver
	{
		public static int numberOfHitsUser = 1;
		public static int totalValueSelf = 0;
		public static int totalValueUser = 0;
	
	public static void main(String[] args)
	
		{
			
			//tellUserWhatIsHappening();
			Deck.generateCards();
			//GiveCards.giveTwoCards();
			Deck.hitSelf();
			Deck.hitUser();
			
			do{
				Deck.hitUser();
				Deck.hitSelf();
			}
			while(userPlaying() && underTwentyOne());
			checkCards();
			
			System.out.println( "Self is: " + totalValueSelf + " User is: " + totalValueUser);
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
			if((totalValueUser > 22) || (totalValueSelf > 22)){
				return false;
			}
			else{
				return true;
			}
		}
	private static void checkCards()
		{
			if(totalValueUser > 22){
				System.out.println("You lost :(");
			}
			else if(((totalValueSelf > 22) && (totalValueUser < 22)) || (((totalValueUser  < 22) && (totalValueSelf < 22)) && (totalValueUser > totalValueSelf))) {
				System.out.println("You Won!!!");
			}
			else if(((totalValueSelf > 22) && (totalValueUser > 22)) && (totalValueSelf == totalValueUser)){
				System.out.println("Its a tie!");
			}
			
		}
	

	}
