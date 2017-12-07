package apps.old;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import beans.old.*;

public class Car_Engine_2
{
	public static void main(String[] args)
	{
		ApplicationContext f= new ClassPathXmlApplicationContext("resources/spring-car-engine-2.xml");
		
		Car2 c= (Car2) f.getBean("car2");
		
		c.printCarDetails();
	}

}
