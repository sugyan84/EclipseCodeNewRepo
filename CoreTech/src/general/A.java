package general;

public class A
{
		public static void main(String[] args)
		{
			AA obj = new AA();
			
			int x= obj.methodOfA();
			
			System.out.println(x);
		}
}


class AA
{
    
	int methodOfA()
    {
        return (true ? null : 0);
    }
}