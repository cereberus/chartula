package random;


public class random_Math_random {

	/**
	 * @param args
	 */
	
	static int random;
	
	
	public static void main(String[] args) {
		int Min = 50;
		int Max = 550;
		for (int i=0;i<3;i++)
		{
			// 0 - 53
//			random = (int) Math.floor((Math.random()*53)+1);
				
			// Range
			random =  Min + (int)(Math.random() * ((Max - Min) + 1));
			System.out.println(random);
			
		}
	}

}
