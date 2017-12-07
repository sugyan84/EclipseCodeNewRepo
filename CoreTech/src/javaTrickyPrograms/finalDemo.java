package javaTrickyPrograms;


/*This program should print the content in static block,
but as we are accessing only a final variable which is constant 
so JVM replaces T.x as 100, which is just a constant and T class is not loaded.
So, the static block is also not executed.*/
public class finalDemo
{

	public static void main(String[] args)
	{
		System.out.println(T.x);
	}

}


class T
{
	public static int x=10;
	
	static
	{
		System.out.println("T loaded");
	}
}
