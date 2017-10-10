import java.util.*;

public class Betting
	{
		public static int amountBetByUser = 0;
		static Scanner amountBet = new Scanner(System.in);
	public static void tellUserWhatIsHappening()
		{
			
			System.out.println("Your balance is: $" + Driver.balance);
			
			System.out.println();
			
			System.out.println("How many dollars would you like to bet?");
			
		}
	//added takeBet method to prevent user from betting more than their balance
	public static void takeBet()
		{
			amountBetByUser = amountBet.nextInt();
			
			if(amountBetByUser > Driver.balance)
				{
				System.out.println("You don't have that much money! Bet again please.");
				takeBet();
				}
			System.out.println();
		}

	}
