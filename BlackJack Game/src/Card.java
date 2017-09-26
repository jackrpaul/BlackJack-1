
public class Card
	{
		String suit;
		String color;
		int value;

		public Card(String s, String c, int v)
			{
				suit = s;
				color = c;
				value = v;
			}

		public String getSuit()
			{
				return suit;
			}

		public void setSuit(String suit)
			{
				this.suit = suit;
			}

		public String getColor()
			{
				return color;
			}

		public void setColor(String color)
			{
				this.color = color;
			}

		public int getValue()
			{
				return value;
			}

		public void setValue(int value)
			{
				this.value = value;
			}

	}
