
public class AI
	{
		//changed SelfValue to cpuValue to avoid confusion
		static int cpuValue = 0;
	
		public static void checkCardsSelf()
		{
		
		cpuValue = Driver.totalValueCPU;
		
		if(cpuValue < 17)
			{
			Deck.hitCPU();
			}
		}
			
	}
