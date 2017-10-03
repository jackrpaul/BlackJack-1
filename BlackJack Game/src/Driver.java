import java.util.*;
public class Driver
	{
		public static int totalValueSelf = 0;
		public static int totalValueUser = 0;
		public static int ballance = 100;
				
	public static void main(String[] args)
	
		{	
			tellUserWhatIsHappening();
			theCode();	
		}

	private static void theCode()
		{
			Deck.generateCards();
			Betting.tellUserWhatIsHappening();
			Deck.hitSelfFirst();
			Deck.hitSelf();
			Deck.hitUserFirst();
			while(underTwentyOne() && userPlaying())
				{
					System.out.println();
					Deck.hitUser();
					Deck.hitSelf();
				}
			AI.checkCardsSelf();
			checkCards();
			askPlayAgain();
		}
	
	private static void tellUserWhatIsHappening()
		{
			Scanner doesUserPlay = new Scanner(System.in);
			System.out.println("Were going to play a game of BlackJack.");
			System.out.println("The object of this game is to get the closest to 21 without going over.");
			System.out.println("Jack, Queen, and King are all worth 10.");
			System.out.println("The Aces will change for you.");
			System.out.println("Press Enter to play!");
			String notNeeded = doesUserPlay.nextLine();
		}
	
	private static boolean userPlaying()
		{
			Scanner yesOrNo = new Scanner(System.in);
			System.out.println("Do you want a hit? \n Enter 1 for yes \n Enter 2 for no");
			int yeeOrNee = yesOrNo.nextInt();
			
			if(yeeOrNee == 1){
				return true;
			}
			else if(yeeOrNee ==2){
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
					System.out.println();
					ballance = ballance;
					System.out.println("You Lose :( Your new balance is: $" + ballance);
					System.out.println("The dealer had: ");
					for(int i = 0 ; i < Deck.selfRank.size(); i++){
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
					}
				}					
				else if(totalValueUser > totalValueSelf){
					System.out.println();
					ballance += Betting.amountBetByUser;
					System.out.println("You Win!! Your new balance is: $" + ballance);
					System.out.println("The dealer had: ");
					for(int i = 0 ; i < Deck.selfRank.size(); i++){
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
					}
				}
				else if(totalValueUser == totalValueSelf){
					System.out.println();
					ballance += Betting.amountBetByUser;
					System.out.println("It's a Tie! Your new balance is: $" + ballance);
					System.out.println("The dealer had: ");
					for(int i = 0 ; i < Deck.selfRank.size(); i++){
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
					}
				}
				else{
					System.out.println();
					ballance += Betting.amountBetByUser;
					System.out.println("You Win!! Your new balance is: $" + ballance);
					System.out.println("The dealer had: ");
					for(int i = 0 ; i < Deck.selfRank.size(); i++){
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
					}
				}
			}
			else{
				System.out.println();
				ballance = ballance;
				System.out.println("You Lose :( Your new balance is: $" + ballance);
				System.out.println("The dealer had: ");
				for(int i = 0 ; i < Deck.selfRank.size(); i++){
					System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
				}
			}
			
		}

	private static void checkAces()
		{
			if(Deck.numberOfAces > 0){
				if(totalValueUser > 22){
					totalValueUser = totalValueUser - 10;
					Deck.numberOfAces--;
				}
			}
			if(Deck.numberOfAcesSelf > 0){
				if(totalValueSelf > 22){
					totalValueSelf = totalValueSelf - 10;
					Deck.numberOfAcesSelf--;
				}
			}
			
		}

	private static void askPlayAgain()
		{
			System.out.println();
			Scanner playAgain = new Scanner(System.in);
			System.out.println("Would you like to play again?");
			String playAgainAnswer = playAgain.nextLine();
			
			if(playAgainAnswer.equals("yes") || playAgainAnswer.equals("Yes")){
				System.out.println("Awesome!");
				totalValueSelf = 0;
				totalValueUser = 0;
				System.out.println();
				theCode();
			}
			else if(playAgainAnswer.equals("no") || playAgainAnswer.equals("No")){
				System.out.println();
				System.out.println("Ok");
			}
			else{
				System.out.println();
				System.out.println("Please enter either Yes or No.");
				askPlayAgain();
			}
			
		}
	}
