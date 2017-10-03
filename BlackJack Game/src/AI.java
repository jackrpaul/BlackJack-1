
public class AI
	{
		static int selfValue = 0;
	
		public static void checkCardsSelf()
		{
		selfValue = Driver.totalValueSelf;
		
		if(selfValue < 17){
			Deck.hitSelf();
		};
		};
			
	}
