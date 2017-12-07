package general.ObjectReferenceInsideClass;

public class House
{
	Box b;

	public House(Box b)
	{
		//super();
		this.b = b;
	}
	
	public Box change(Box i)
	{
		this.b.i=10;
		return this.b;
	}
	
}
