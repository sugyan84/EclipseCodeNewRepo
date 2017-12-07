package annotations.Custom;

import java.lang.annotation.Annotation;

public class Demo
{

	public static void main(String[] args)
	{
		Student s = new Student("S-111", "Sugyan", "BLR");
		s.getStudentDetails();
		
		
		//get the Class Object for the s student obj.
		Class c = s.getClass();
		
		System.out.println("Class: "+c.getName());
		
		
		
		
		//With the help of Class object, get Annotation obj.
		Annotation ann= c.getAnnotation(Course.class);
		
		
		//Get the Course obj by down-casting Annotation Obj.
		Course crs = (Course)ann;
		

		//Get details of Annotation now.
		System.out.println("Anno:cid- "+crs.cid());
		System.out.println("Anno:cname- "+crs.cname());
		System.out.println("Anno:ccost- "+crs.ccost());
		
		
		
		
	}
	
	

}
