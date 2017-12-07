package demo;

public class CricketCoach implements demo.Coach
{

	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	
	
	@Override
	public String getDailyWorkOut()
	{
		return "Cricket: Bowl round-arm over the wicket for 3 overs";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getTeam()
	{
		return team;
	}

	public void setTeam(String team)
	{
		this.team = team;
	}

	public FortuneService getFortuneService()
	{
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

}
