package apps.old;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import beans.old.*;


public class Engine_Car
{

	public static void main(String[] args)
	{
		/*Resource rCar = new ClassPathResource("resources/Car.xml");
		Resource rEngine = new ClassPathResource("resources/Engine.xml");
		
		BeanFactory factoryEngine= new XmlBeanFactory(rEngine);
		BeanFactory factoryCar= new XmlBeanFactory(rCar);*/
		
		
		Resource r = new ClassPathResource("resources/car-engine.xml");
		
		
		BeanFactory factory= new XmlBeanFactory(r);
		
		
		Engine e = (Engine) factory.getBean("engine");
		Car c= (Car)factory.getBean("car");
		
		
		e.toString();
		c.toString();
		
		
		

	}

}
