package problem.randomGenerator;

public class RandomGen
{
	private static long	initialNumber		= 5;

	private long		lastReturnedNumber	= initialNumber;

	private int			counter				= 0;

	public RandomGen()
	{

	}

	public RandomGen(long start, long end)
	{

	}

	public double getRandomNumber()
	{
		int switcher = counter % 4;
		this.counter++;
		double calculatedValue=0.0d;
		double valueToReturn=0;
		
		switch (switcher)
		{
		case 0:
			calculatedValue = lastReturnedNumber/2;
			valueToReturn = lastReturnedNumber - calculatedValue;
			break;
		case 1:
			calculatedValue = lastReturnedNumber/2;
			valueToReturn = lastReturnedNumber + calculatedValue;
			break;
		case 2:
			calculatedValue = lastReturnedNumber/2;
			valueToReturn = lastReturnedNumber * calculatedValue;
			break;
		case 3:
			calculatedValue = lastReturnedNumber/2;
			valueToReturn = lastReturnedNumber / calculatedValue;
			break;

		default:
			break;
		}
		
		lastReturnedNumber = (long)valueToReturn;
		return valueToReturn;
	}
}
