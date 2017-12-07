package demo.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("theSillyCoach")
public class TennisCoach implements Coach
{

	private FortuneService f;

	/*@Autowired
	public TennisCoach(FortuneService f)
	{
		this.f = f;
	}*/

	
	public TennisCoach()
	{
		System.out.println("default Constructor()");
	}
	@Autowired
	public void setF(FortuneService f)
	{
		this.f = f;
	}

	@Override
	public String getDailyWorkOut()
	{
		return "Tennis: run for 20 mins";
	}

	@Override
	public String getDailyFortune()
	{
		System.out.println(this.getClass() + "--> " + "In TennisCoach getDailyFortune()");
		return this.f.getFortune();
	}

	@PostConstruct
	public void myStartUp()
	{
		System.out.println("Method after constructor");
	}
	
	@PreDestroy
	public void myDestroy()
	{
		System.out.println("before destruction");
	}
}
