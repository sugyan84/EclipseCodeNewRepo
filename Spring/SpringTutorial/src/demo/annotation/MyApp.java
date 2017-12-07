package demo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContextAnnotation.xml");
		
		Coach obj = appContext.getBean("theSillyCoach", Coach.class);
		
		System.out.println(obj.getDailyWorkOut());
		
		System.out.println(obj.getDailyFortune());
		
		appContext.close();
	}
}
