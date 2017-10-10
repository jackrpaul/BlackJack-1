import java.util.*;
public class Driver
	{
		//changed totalValueSelf to totalValueCPU to avoid confusion
		public static int totalValueCPU = 0;
		public static int totalValueUser = 0;
		public static int balance = 100;
				
	public static void main(String[] args)
	
		{	
			//moved this method into the main method to ensure cards weren't being reused
			Deck.generateCards();
			tellUserWhatIsHappening();
			theCode();	
		}

	private static void theCode()
		{
			Betting.tellUserWhatIsHappening();
			//added takeBet method to theCode
			Betting.takeBet();
			Deck.hitSelfFirst();
			Deck.hitCPU();
			Deck.hitUserFirst();
			while(underTwentyOne() && userPlaying())
				{
					System.out.println();
					Deck.hitUser();
					Deck.hitCPU();
				}
			AI.checkCardsSelf();
			checkCards();
			askPlayAgain();
		}
	
	private static void tellUserWhatIsHappening()
		{
			Scanner doesUserPlay = new Scanner(System.in);
			System.out.println("We are going to play a game of BlackJack.");
			System.out.println("The object of this game is to get the closest to 21 without going over.");
			System.out.println("The Jacks, Queens, and Kings are all worth 10.");
			System.out.println("The Aces will change for you.");
			System.out.println("Press Enter to play!");
			String notNeeded = doesUserPlay.nextLine();
		}
	
	private static boolean userPlaying()
		{
			Scanner yesOrNo = new Scanner(System.in);
			System.out.println("Do you want to hit? \nEnter 1 for yes. \nEnter 2 for no.");
			int yeeOrNee = yesOrNo.nextInt();
			
			if(yeeOrNee == 1)
				{
				return true;
				}
			else if(yeeOrNee ==2)
				{
				return false;
				}
			else
				{
				System.out.println("That's not a valid option. Try again.");
				return false;
				}
			
		}

	private static boolean underTwentyOne()
		{
			if((totalValueUser > 22))
				{
				checkAces();
				if(totalValueUser > 22)
					{
					return false;
					}
				else
					{
					return true;
					}
				
				}
			else
				{
				return true;
				}
		}
	
	private static void checkCards()
		{
			if(totalValueUser < 22)
				{
				if((totalValueUser < totalValueCPU) && (totalValueCPU < 22))
					{
					System.out.println();
					balance = balance;
					System.out.println("You Lose :( Your new balance is: $" + balance);
					System.out.println("The dealer had: ");
					for(int i = 0 ; i < Deck.selfRank.size(); i++)
						{
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
						}
					}					
				else if(totalValueUser > totalValueCPU)
					{
					System.out.println();
					balance += Betting.amountBetByUser;
					System.out.println("You Win!! Your new balance is: $" + balance);
					System.out.println("The dealer had: ");
					for(int i = 0 ; i < Deck.selfRank.size(); i++)
						{
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
						}
					}
				else if(totalValueUser == totalValueCPU){
					System.out.println();
					balance += Betting.amountBetByUser;
					System.out.println("It's a Tie! Your new balance is: $" + balance);
					System.out.println("The dealer had: ");
					for(int i = 0 ; i < Deck.selfRank.size(); i++){
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
					}
				}
				else{
					System.out.println();
					balance += Betting.amountBetByUser;
					System.out.println("You Win!! Your new balance is: $" + balance);
					System.out.println("The dealer had: ");
					for(int i = 0 ; i < Deck.selfRank.size(); i++){
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
					}
				}
			}
			else
				{
				System.out.println();
				//added -= statement to ensure user could actually lose money too
				balance -= Betting.amountBetByUser;
				System.out.println("You Lose :( Your new balance is: $" + balance);
				System.out.println("The dealer had: ");
				for(int i = 0 ; i < Deck.selfRank.size(); i++)
					{
						System.out.println("A " + Deck.selfSuit.get(i) + " of " + Deck.selfRank.get(i));
					}
				}
			
		}

	private static void checkAces()
		{
			if(Deck.numberOfAces > 0)
				{
				if(totalValueUser > 22)
					{
					totalValueUser = totalValueUser - 10;
					Deck.numberOfAces--;
					}
				}
			if(Deck.numberOfAcesCPU > 0)
				{
				if(totalValueCPU > 22)
					{
					totalValueCPU = totalValueCPU - 10;
					Deck.numberOfAcesCPU--;
					}
				}
			
		}

	private static void askPlayAgain()
		{
			System.out.println();
			Scanner playAgain = new Scanner(System.in);
			System.out.println("Would you like to play again?");
			String playAgainAnswer = playAgain.nextLine();
			//added switch statement
			switch (playAgainAnswer)
			{
				case "yes":
				case "Yes":
				case "sure":
				case "Sure":
					{
					System.out.println("Okay! The cards that were used in this game will not be used again.");
					totalValueCPU = 0;
					totalValueUser = 0;
					System.out.println();
					theCode();
					break;
					}
				default:
						{
						System.out.println("Okay, have a great day!");
						break;
						}
			}
			
		}
	}
