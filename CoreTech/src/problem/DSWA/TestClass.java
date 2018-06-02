package problem.DSWA;

public class TestClass
{

	public static void main(String[] args)
	{

        PassS p = new PassS();
        p.start();
    

	}

}


class Base
{
    static int x = 10;
}
class Derived extends Base
{
    public static void fun()
    {
        //System.out.println(super.x);
    }
}



class PassS 
{
    /*public static void main(String [] args) 
    {
        PassS p = new PassS();
        p.start();
    }*/

    void start() 
    {
        String s1 = "sleep";
        String s2 = fix(s1);
        System.out.println("START: "+s1 + " " + s2);
    }

    String fix(String s1) 
    {
        s1 = s1 + "stream";
        System.out.println("FIX: "+s1 + " ");
        return "steem";
    }
}