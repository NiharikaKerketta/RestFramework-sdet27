package sdet27.GenericUtility;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author Niharika
 */
public class JavaUtility {

	/**
	 * this method will generate a random value for every run
	 * @return
	 */
	public int getRandomNum()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		return randomNumber;
		
	}
}
