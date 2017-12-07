package others;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.util.*;

/**
 * Class to find combinations of strings from multiple files
 * 
 * SAMPLE INPUT:
 * 
 * file1 file2 file3 line1: a 1 j line2 b 2 k line3 c 3 m
 * 
 * OUTPUT: a1j a1k a1m a2j a2k a2m a3j a3k a3m .. .. .. same repeats with b and
 * c
 * 
 */
public class Combination
{

	public static void main(String args[])
	{
		Combination combi = new Combination();
		combi.readFiles();
	}

	void readFiles()
	{
		String target_dir = "C:\\Users\\PIKS-PC\\Desktop\\Swetha (the bhainsiya)\\";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();

		ArrayList<String> list = new ArrayList<String>();
		ArrayList<ArrayList<String>> listOfList = new ArrayList<ArrayList<String>>();
		int count = 0;

		for(File file : files)
		{
			if(file.isFile())
			{

				// System.out.println("reading File=> " + file.getName());
				BufferedReader buffRead = null;
				try
				{
					buffRead = new BufferedReader(new FileReader(file));
					String line;

					ArrayList<String> tmpList = new ArrayList<String>();
					System.out.println("entering while loop count: " + count);
					while ((line = buffRead.readLine()) != null)
					{
						tmpList.add(line);
					}
					if(tmpList.size() > 0) 
						list = concatenateListItems(list, tmpList);

				}
				catch(IOException io)
				{
					System.out.println("IOException caught" + io);
				}
				finally
				{
					if(buffRead != null)
					{
						try
						{
							buffRead.close();
						}
						catch(IOException io)
						{
							System.out.println("IOException caught" + io);
						}
					}
				}
			}
		}

		System.out.println("Concatenated List");
		for(String str : list)
		{
			System.out.println(str);
		}
	}

	// concatenates only single line only
	ArrayList<String> concatenateListItems(ArrayList<String> list, String str)
	{
		ArrayList<String> listNew = new ArrayList<String>();
		if(list.size() == 0)
		{
			for(int j = 0; j < str.length(); j++)
			{
				String tmp = "" + str.charAt(j);
				listNew.add(tmp);
			}
		}

		for(String strElement : list)
		{
			for(int i = 0; i < str.length(); i++)
			{
				String tmp = strElement;
				System.out.println("$: " + tmp);
				tmp = tmp + str.charAt(i);
				listNew.add(tmp);
			}
		}
		return listNew;
	}

	// concatenates each line
	ArrayList<String> concatenateListItems(ArrayList<String> list, ArrayList<String> tmpList)
	{
		ArrayList<String> listNew = new ArrayList<String>();

		if(list.size() == 0)
		{
			for(String strElement : tmpList)
			{
				listNew.add(strElement);
			}
		}

		for(String strElement : list)
		{
			for(String strTmp : tmpList)
			{
				String tmp = strElement;
				tmp = tmp +" "+ strTmp;
				listNew.add(tmp);
			}
		}
		return listNew;
	}
}

/*
 * 
 * // function which read file void readFile() { concatenateList(); }
 * 
 * // function which iterates list and concatenate each line (String) from file
 * to each element (String) in list void concatenateList() {
 * 
 * }
 * 
 * 
 * 
 */
