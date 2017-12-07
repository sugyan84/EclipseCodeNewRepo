package Inheritance.interfaceExtends;

public interface ABC
{
	int x = 100;

	public void display1();

	public void display2();
}

abstract class A_ABC implements ABC
{
	@Override
	public void display1()
	{
		System.out.println("abstract class A_ABC display1()");
	}
}

class myClass extends A_ABC
{
	@Override
	public void display2()
	{
		System.out.println("Concreate class display2()");
	}

}
