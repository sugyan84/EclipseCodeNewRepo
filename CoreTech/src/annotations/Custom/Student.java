package annotations.Custom;

@Course(cid="C-345", cname="Spring", ccost=20400)
public class Student
{
	String sid;
	String sname;
	String saddr;
	public Student(String sid, String sname, String saddr)
	{
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddr = saddr;
	}
	
	
	public void getStudentDetails()
	{
		System.out.println("Student details");
		System.out.println("------------------");
		System.out.println("ID: "+this.sid);
		System.out.println("Name: "+this.sname);
		System.out.println("Address: "+this.saddr);
	}
}