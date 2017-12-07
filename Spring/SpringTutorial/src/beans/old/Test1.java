package beans.old;

public class Test1 extends Car
{
	int id;
	String	name;
	

	public Test1(int i)
	{
		id=i;
	}
	
	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getName()
	{
		return name;
	}



	public void setName(String name)
	{
		this.name = name;
	}



	public Test1()
	{
		System.out.println("Hello, Welcome to Test1 class!");
	}

	

	public void hello()
	{
		
		System.out.println("id=|"+this.getId()+"| "+"name=|"+this.getName()+"|\n");
	}
}
