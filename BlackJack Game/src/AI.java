
public class AI
	{
		static int selfValue = 0;

		
		public static void easyOrHardCheck(){
			String easyOrHardCheck = Driver.easyOrHard;
			if(easyOrHardCheck.equalsIgnoreCase("hard")){
				checkCardsSelf();
			}
		}
		public static void checkCardsSelf()
		{
		selfValue = Driver.totalValueSelf;
		
		if(selfValue < 17){
			Deck.hitSelf();
		}
		};
			
	}
