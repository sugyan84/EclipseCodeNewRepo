package javaTrickyPrograms;

public class staticBlockDemo
{

	public static void main(String[] args)
	{
		A obj1=new A();
		A obj2=new A();
		//

	}

}


class A
{
	static
	{
		System.out.println("static block");
	}
	
	
	A()
	{
		System.out.println("constructor");
	}
	//normal block is executed everytime object is created, executed before constructor.
	{
		System.out.println("non-static block");
	}
}