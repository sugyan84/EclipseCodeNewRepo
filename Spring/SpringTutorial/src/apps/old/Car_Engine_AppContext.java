package apps.old;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.old.*;



public class Car_Engine_AppContext
{

	public static void main(String[] args)
	{
		String[] arrFiles={
				"resources/Car.xml",
				"resources/Engine.xml"
				
		};
		
		ApplicationContext f= new ClassPathXmlApplicationContext(arrFiles);
		
		Car c= (Car)f.getBean("car");
		Engine e = (Engine)f.getBean("engine");
		
		e.toString();
		c.toString();
		
		

	}

}
