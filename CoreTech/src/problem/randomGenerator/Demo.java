package problem.randomGenerator;

public class Demo
{

	public static void main(String[] args)
	{
		RandomGen r = new RandomGen();
		
		for(int i=0; i<10; i++)
		System.out.println(r.getRandomNumber());

	}

}
