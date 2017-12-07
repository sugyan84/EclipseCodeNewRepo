package general.NullPointer;

public class Demo
{

	public static void main(String[] args)
	{
		Demo obj= null;
		obj.print();			//In .class file, obj is replaced by ClassName by JVM and executed successfully.
	}

	//removed static
	public static void print()
	{
		System.out.println("hello");
	}
	
}
