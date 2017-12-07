package demo;

public class TrackCoach implements demo.Coach
{

	private FortuneService fortuneService;
	
	
	public TrackCoach(FortuneService fortuneService)
	{
		System.out.println("Track Coach: no-arg constructor");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkOut()
	{
		return "TrackCoach: Run for 30mins like hell";
	}

	
	
	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}



	public void setFortuneService(FortuneService f)
	{
		this.fortuneService = f;
	}

	
	public void initMethod()
	{
		System.out.println("DO my Startup stuff");
	}
	
	
	public void destroyMethod()
	{
		System.out.println("DO my Clean-up stuff");
	}
	
	
	@Override
	protected void finalize() throws Throwable
	{
		super.finalize();
		System.out.println("Object finalize() destruction method");
	}
}
