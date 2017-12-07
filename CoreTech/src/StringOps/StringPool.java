package StringOps;

public class StringPool
{

	public static void main(String[] args)
	{
		String str1 = new String("hello");
	    String str2 = "hello";
	    String str3 = str1.intern();
	    
	    System.out.println(System.identityHashCode(str1));
	    System.out.println(System.identityHashCode(str2));
	    System.out.println(System.identityHashCode(str3));
	    
	    Box b1= new Box(2);
	    
	    Box b2= b1;
	    
	    System.out.println("b1= "+System.identityHashCode(b1));
	    System.out.println("b2= "+System.identityHashCode(b2));

	}

}

class Box
{
	int i;
	
	Box(int i)
	{
		this.i= i;
	}
}