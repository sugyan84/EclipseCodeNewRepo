package general.ObjectReference;

public class DemoObjectRef
{

	public static Box inspectionMethod(Box b)
	{
		System.out.println("Ref came inside method b="+b.i);
		
		b=new Box(10);
		
		return b;
	}
	
	
	public static void main(String[] args)
	{
		Box b1= new Box(5);
		
		System.out.println("Main ref b1="+b1.i);
		
		inspectionMethod(b1);
		
		System.out.println("Back to main, changed ref in method shows b1="+b1.i);

	}

}
