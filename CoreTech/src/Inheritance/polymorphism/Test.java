package Inheritance.polymorphism;


class A
{
	void doSum()
	{
		System.out.println("Class A");
	}
}


class B extends A
{
	void doSum()
	{
		System.out.println("Class B");
	}
}

class C extends B
{
	void doSum()
	{
		System.out.println("Class C");
	}
}


public class Test
{

	public static void main(String[] args)
	{
		A objA= new C();
		objA.doSum();
	}

}
