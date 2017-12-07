package demo.annotation;

public class SwimCoach implements Coach
{

	private FortuneService f;
	
	public SwimCoach(FortuneService f)
	{
		this.f = f;
	}
	
	@Override
	public String getDailyWorkOut()
	{
		return "Swim: regulary";
	}

	@Override
	public String getDailyFortune()
	{
		return this.f.getFortune();
	}

}
