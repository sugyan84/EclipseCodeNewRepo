package javaTrickyPrograms.OverRiding;

class B
{
	public static String method()
	{
		return "B::method()";
	}
}


class A extends B
{
	public static String method()
	{
		return "A::method()";
	}
	
	public static void main(String[] args)
	{
		B a = new A();
		
		//B b = new B();
		
		System.out.println(a.method()/*+" "+b.method()*/);
	}
}

