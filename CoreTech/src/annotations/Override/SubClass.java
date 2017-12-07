package annotations.Override;

import javax.jws.Oneway;

public class SubClass extends SuperClass
{
	@Override
	public void getDriver()
	{
		System.out.println("Sub Driver");
	}
}
