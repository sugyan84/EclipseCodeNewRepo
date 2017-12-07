package demo.JavaBased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.annotation.Coach;

public class MyApp
{
	public static void main(String[] args)
	{
		//ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContextAnnotation.xml");
		
		//Java-based COnfiguration
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Coach obj = appContext.getBean("swimCoachObj", Coach.class);
		
		System.out.println(obj.getDailyWorkOut());
		
		System.out.println(obj.getDailyFortune());
		
		appContext.close();
	}
}
