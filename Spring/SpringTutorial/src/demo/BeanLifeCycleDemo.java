package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemo
{

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("beanLifeCycleAppContext.xml");

		Coach c = appContext.getBean("trackcoach", Coach.class);
		
		System.out.println(c.getDailyWorkOut());
		
		
		appContext.close();
	}

}
