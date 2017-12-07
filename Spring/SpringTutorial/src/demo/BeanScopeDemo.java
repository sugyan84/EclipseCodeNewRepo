package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeAppContext.xml");
		
		Coach coachObj1 = context.getBean("trackcoach", Coach.class);
		
		Coach coachObj2 = context.getBean("trackcoach", Coach.class);
		
		boolean isSame = (coachObj1==coachObj2);
		
		System.out.println("isSame: "+isSame);
	}
}
