package general;

import java.util.HashSet;
import java.util.Iterator;

public class OverRide
{
public static void main(String[] args)
{
	String s = "ONE"+1+2+"TWO"+"THREE"+3+4+"FOUR"+"FIVE"+5; 
	 
    System.out.println(s);
    
  HashSet h = new HashSet();
  
 
  
h.add(null);
h.add(null);
  h.add("4");
 h.add("2");
 h.add("1");
  
  
  Iterator i=h.iterator();
  
  while(i.hasNext())
  {
	  System.out.println(i.next());
  }
}
}


class AS
{
    void method(int i)
    {
        //method(int)
    }

	void method(Object i)
	{
		// TODO Auto-generated method stub
		
	}

	void method(Integer i)
	{
		// TODO Auto-generated method stub
		
	}
}
 
class B extends AS
{
    @Override
    void method(Object i)
    {
        //method(Integer)
    }
}