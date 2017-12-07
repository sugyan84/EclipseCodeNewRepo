package threading;

public class ProdCons
{

	public static void main(String[] args)
	{
		QuesAns o = new QuesAns();
		
		ThreadBox t1=new ThreadBox(o);
		
		ThreadBox t2=new ThreadBox(o);
		
		
		t1.start();
		t2.start();

	}

}
