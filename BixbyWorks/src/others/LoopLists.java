package others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LoopLists
{
	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static String filesSourcePath="C:\\Users\\PIKS-PC\\Desktop\\Swetha (the bhainsiya)\\";
	
	static List allLists= new ArrayList();
	static List bufferList = new ArrayList();
	
	public static void readFiles() throws Exception
	{
		File fs= new File(filesSourcePath);
		
		File[] arrFiles= fs.listFiles();
		
		System.out.println(arrFiles.length);
		
		for(File i: arrFiles)
		{
			br= new BufferedReader(new FileReader(i));
			
			List localList = new ArrayList();
			
			String str;
			
			while((str=br.readLine()) != null)
			{
				localList.add((String)str);
			}
			
			allLists.add(localList);
			
			br.close();
		}
		
	}
	
	
	public static void concatenateLists(String s)
	{
		bufferList.add(s);
		
		for(int i=1;i<allLists.size();i++)
		{
			bufferList=traverseList((List)allLists.get(i), bufferList);
		}
		
		System.out.println("------------------------");
		
		Iterator itt= bufferList.iterator();;
		
		while(itt.hasNext())
		{
			System.out.println(itt.next());
		}
	}
	
	
	
	public static List traverseList(List newList, List existList)
	{
		Iterator ItrExist = existList.iterator();
		
		List l= new ArrayList();
		String existString;

		
		while(ItrExist.hasNext())							
		{
			String existStringBackUp;
			
			existString=(String)ItrExist.next();
			existStringBackUp=existString;
			
			
			//This was the bug !!
			//itrNewList Iterator was declared outside the loop
			//because of which it ended looping after the first element.
			Iterator itrNewList = newList.iterator();
			while(itrNewList.hasNext())
			{
				existString=existStringBackUp;
				
				String my= (String)itrNewList.next();
				
				l.add(existString+" "+my);				
			}
		}
		
		return l;
	}
	
	public static void main(String[] args) throws Exception
	{
		readFiles();
		
		List x= (List)allLists.get(0);
		
		Iterator itr= x.iterator();
		
		while(itr.hasNext())
		{
			concatenateLists((String)itr.next());
			bufferList.clear();
		}
	}

}
