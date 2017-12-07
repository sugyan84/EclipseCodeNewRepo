package general.ObjectReferenceInsideClass;

public class Demo
{

	public static void main(String[] args)
	{
		Box b1=new Box(5);
		
		System.out.println(b1.i);
		
		House h = new House(b1);
		h.change(b1);
		
		System.out.println(b1.i);
	}

}
