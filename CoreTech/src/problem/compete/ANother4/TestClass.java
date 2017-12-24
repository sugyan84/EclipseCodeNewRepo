package problem.compete.ANother4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Scanner s = new Scanner(System.in);
        
        int T = Integer.parseInt(br.readLine());

        List<Student> l = new ArrayList<>(T);
        
        for(int i=0; i<T; i++)
        {
        	String[] str = br.readLine().split(" ");
        	
        	Student obj = new Student(str[0], Integer.parseInt(str[1]));
        	
        	l.add(obj);
        }
        
        Collections.sort(l);
        
        Iterator itr = l.iterator();
        
        while(itr.hasNext())
        {
        	Student s = (Student) itr.next();
        	
        	System.out.println(s.name+" "+s.marks);
        }

    }
}


class Student implements Comparable
{
	int marks;
	
	String name;

	public Student(String name, int m)
	{
		this.name = name;
		this.marks = m;
	}
	
	@Override
	public int compareTo(Object paramT)
	{
		int retVal=0;
		
		Student s = (Student) paramT;
		
		if(this.marks < s.marks)
		{
			retVal = 1;
		}
		else if(this.marks > s.marks)
		{
			retVal = -1;
		}
		else if(this.marks == s.marks)
		{
			retVal = this.name.compareToIgnoreCase(s.name);
		}
		
		return retVal;
	}
	
	
}