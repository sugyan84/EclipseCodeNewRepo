package javaTrickyPrograms;

import java.util.TreeSet;

public class TreeSetWorking
{

	public static void main(String[] args)
	{
		TreeSet t = new TreeSet<>();

		Employee e1 = new Employee();

		e1.empID = 1;
		e1.name = "Sugyan";

		Employee e2 = new Employee();

		e2.empID = 2;
		e2.name = "Aman";

		t.add(e1);
		t.add(e2);

		System.out.println(t);
	}

}

class Employee implements Comparable
{
	int		empID;
	String	name;

	@Override
	public int compareTo(Object arg0)
	{
		Employee e = (Employee) arg0;

		if(this.empID > e.empID)
		{
			return -1;
		}
		else if(this.empID < e.empID)
			return 1;
		else
			return 0;
	}
	
	public String toString()
	{
		return ("["+this.empID+" "+this.name+"]");
	}
}
