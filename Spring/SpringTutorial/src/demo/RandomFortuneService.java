package demo;

import java.util.Random;

public class RandomFortuneService implements FortuneService
{

	private String[] fortunes;

	public  RandomFortuneService(String[] fortunes)
	{
		this.fortunes = fortunes;
	}

	@Override
	public String getFortune()
	{
		String retVal="";
		
		Random r = new Random();
		int Low = 0;
		int High = 2;
		int Result = r.nextInt(High-Low) + Low;
		
		retVal = this.fortunes[Result];
		
		return retVal;
	}

}
