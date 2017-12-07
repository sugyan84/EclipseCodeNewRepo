package general.MAIN;

//This program demonstrates overriding main() method in Java.
public class Demo
{

	public static void main(String[] args)
	{
		BaseClass b = new BaseClass();
		
		b.main(new String[1]);			//It calls Base Class main() method only.
		
		
		
		BaseClass c = new ChildClass();
		
		c.main(new String[1]);			//It calls Base Class main() method only.
		

	}

}


class BaseClass
{
	public static void main(String[] args)
	{
		System.out.println("Base Class");
	}
}

class ChildClass extends BaseClass
{
	public static void main(String[] args)
	{
		System.out.println("Child Class");
	}
}