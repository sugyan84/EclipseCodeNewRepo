package javaTrickyPrograms.AnonymousInnerClass;

public class Demo
{
	//Trick:: inner.getData() can't be accessed.
	// the method getData() is undefined for type Anonymous
}

interface Anonymous
{
	public int getValue();
}

class Outer
{
	private int data = 15;

	public static void main(String[] args)
	{
		Anonymous inner = new Anonymous() {
			int data = 5;

			@Override
			public int getValue()
			{
				return data;
			}
			
			public int getData()
			{
				return data;
			}
		};
		
		
		Outer outer = new Outer();
		
		//System.out.println(inner.getValue()+ inner.getData()+outer.data);
	}
}