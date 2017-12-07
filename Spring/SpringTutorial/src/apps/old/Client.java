package apps.old;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;
import beans.old.*;


public class Client
{

	public static void main(String[] args)
	{
		Resource r = new ClassPathResource("resources/spring.xml");

		BeanFactory factory= new XmlBeanFactory(r);
		
		Test1 t=(Test1) factory.getBean("t");
		
		
		t.hello();
		
		
	}

}
