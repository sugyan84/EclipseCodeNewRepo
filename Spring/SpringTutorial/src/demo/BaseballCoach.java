package demo;

public class BaseballCoach implements demo.Coach
{

	private FortuneService f;
	
	public BaseballCoach(FortuneService f)
	{
		this.f = f;
	}
	
	@Override
	public String getDailyWorkOut()
	{
		return "Baseball: Practice batting for 30mins";
	}

	@Override
	public String getDailyFortune()
	{
		return this.f.getFortune();
	}
	
}
