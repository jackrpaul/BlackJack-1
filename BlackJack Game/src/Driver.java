import java.util.Scanner;
public class Driver
	{
	public static void main(String[] args)
		{
			
			tellUserWhatIsHappening();
			generateCards();
			
			
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

	private static void generateCards()
		{
			// TODO Auto-generated method stub
			
		}


	}