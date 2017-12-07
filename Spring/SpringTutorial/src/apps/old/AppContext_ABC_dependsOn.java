package apps.old;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppContext_ABC_dependsOn
{

	public static void main(String[] args)
	{
		ApplicationContext f= new ClassPathXmlApplicationContext("resources/dependsOn_ABC.xml");
		

	}

}
