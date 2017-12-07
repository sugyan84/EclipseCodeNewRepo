package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp
{

	public static void main(String[] args)
	{
		// load Config file
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");

		CricketCoach thecoach = appContext.getBean("trackcoach", CricketCoach.class);

		System.out.println(thecoach.getDailyWorkOut());

		System.out.println(thecoach.getDailyFortune());

		System.out.println("EMail: " + thecoach.getEmailAddress());

		System.out.println("Team: " + thecoach.getTeam());

		FortuneService fs = appContext.getBean("randomFortune", FortuneService.class);

		System.out.println(fs.getFortune());

		appContext.close();
	}

}
