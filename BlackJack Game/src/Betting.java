import java.util.*;

public class Betting
	{
		public static int amountBetByUser = 0;

	public static void tellUserWhatIsHappening()
		{

			Scanner amountBet = new Scanner(System.in);
			
			System.out.println("How many dollars would you like to bet?");
			
			amountBetByUser = amountBet.nextInt();
			
			System.out.println();
			//System.out.println(amountBetByUser);
			
		}

	}
