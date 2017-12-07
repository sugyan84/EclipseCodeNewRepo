package trials;

/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */

public class Main
{
	static Map<String, Software> latestVersionDetails = new HashMap<String, Software>();

	public static void updateLatestVersion(Software s)
	{
		if(latestVersionDetails.containsKey(s.getSoftwareName()))
		{
			Software old = (Software) latestVersionDetails.get(s.getSoftwareName());

			int comp = old.compareTo(s);

			if(comp == -1)
			{
				// Updating software version
				latestVersionDetails.put(s.getSoftwareName(), s);
			}
		}
		else
		{
			latestVersionDetails.put(s.getSoftwareName(), s);
		}
	}

	public static boolean isOutDated(Software s)
	{
		boolean retVal = false;

		if(latestVersionDetails.containsKey(s.getSoftwareName()))
		{

			Software old = (Software) latestVersionDetails.get(s.getSoftwareName());

			int comp = old.compareTo(s);

			if(comp == 1)
			{
				retVal = true;
			}

		}

		return retVal;
	}

	public static int processData(ArrayList<String> array)
	{
		/*
		 * Modify this method to process `array` as indicated in the question.
		 * At the end, return the appropriate value.
		 *
		 * Please create appropriate classes, and use appropriate data
		 * structures as necessary.
		 *
		 * Do not print anything in this method.
		 *
		 * Submit this entire program (not just this method) as your answer
		 */

		Map<String, List> serverDetails = new HashMap<String, List>();

		Set<String> outDatedServers = new HashSet<String>();

		Iterator itrArray = array.iterator();

		while (itrArray.hasNext())
		{
			String line = (String) itrArray.next();

			String[] splitArr = line.split(",");

			String key = splitArr[0]; // ServerName

			if(serverDetails.containsKey(key))
			{
				/*
				 * if ServerName already present in Map, adding a new Software
				 * Object into its existing List of Values.
				 */
				List l = (List) serverDetails.get(key);

				Software s = new Software(splitArr[1].trim(), splitArr[2].trim(), splitArr[3].trim());

				l.add(s);

				serverDetails.put(key, l);

				updateLatestVersion(s);
			}
			else
			{
				/*
				 * if ServerName NOT present in Map, adding a new Software
				 * Object into its List of Values.
				 */
				List<Software> softList = new ArrayList<Software>();

				Software s = new Software(splitArr[1].trim(), splitArr[2].trim(), splitArr[3].trim());

				softList.add(s);

				serverDetails.put(key, softList);

				updateLatestVersion(s);
			}
		}

		Iterator itrServerDetails = serverDetails.entrySet().iterator();

		while (itrServerDetails.hasNext())
		{
			Map.Entry<String, List> entryServerDetails = (Map.Entry<String, List>) itrServerDetails.next();

			List<Software> ll = (List) entryServerDetails.getValue();
			Iterator itrSoftList = ll.iterator();

			while (itrSoftList.hasNext())
			{
				if(isOutDated((Software) itrSoftList.next()))
				{
					outDatedServers.add(entryServerDetails.getKey());
				}
			}
		}
		
		return outDatedServers.size();
	}

	public static void main(String[] args)
	{
		ArrayList<String> inputData = new ArrayList<String>();
		try
		{
			Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
			while (in.hasNextLine())
			{
				String line = in.nextLine().trim();
				if(!line.isEmpty()) // Ignore blank lines
				{
					inputData.add(line);
				}

			}
			int retVal = processData(inputData);
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			output.println("" + retVal);
			output.close();
		}
		catch(IOException e)
		{
			System.out.println("IO error in input.txt or output.txt");
		}
	}
}

class Software implements Comparable
{
	String	softwarecategory;
	String	softwareName;
	String	version;

	public Software(String softwarecategory, String softwareName, String version)
	{
		this.softwarecategory = softwarecategory;
		this.softwareName = softwareName;
		this.version = version;
	}

	public String getSoftwarecategory()
	{
		return softwarecategory;
	}

	public void setSoftwarecategory(String softwarecategory)
	{
		this.softwarecategory = softwarecategory;
	}

	public String getSoftwareName()
	{
		return softwareName;
	}

	public void setSoftwareName(String softwareName)
	{
		this.softwareName = softwareName;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	@Override
	public int compareTo(Object o)
	{
		int retVal = 0;

		Software s = (Software) o;

		if(this.softwarecategory.equalsIgnoreCase(s.softwarecategory)
				&& this.softwareName.equalsIgnoreCase(s.softwareName))
		{
			int one = -1;
			int two = -2;

			do
			{
				one = getDecimalCount(this.version);
				two = getDecimalCount(s.version);

				if(one != two)
				{
					if(one < two)
					{
						this.version = this.version + ".0";
					}
					else if(one > two)
					{
						s.version = s.version + ".0";
					}
				}

			} while (one != two);

			String[] splitArr = this.version.split("\\.");
			String[] oSplitArr = s.version.split("\\.");

			int[] splitArrInt = new int[splitArr.length];
			int[] osplitArrInt = new int[oSplitArr.length];

			for(int i = 0; i < splitArr.length; i++)
			{
				splitArrInt[i] = Integer.parseInt(splitArr[i]);
			}

			for(int i = 0; i < oSplitArr.length; i++)
			{
				osplitArrInt[i] = Integer.parseInt(oSplitArr[i]);
			}

			if(splitArrInt[0] > osplitArrInt[0])
			{
				retVal = 1;
			}
			else if(splitArrInt[0] < osplitArrInt[0])
			{
				retVal = -1;
			}
			else if(splitArrInt[0] == osplitArrInt[0])
			{
				if((splitArrInt.length >= 2 && osplitArrInt.length >= 2))
				{
					if(splitArrInt[1] > osplitArrInt[1] && (splitArrInt.length >= 2 && osplitArrInt.length >= 2))
					{
						retVal = 1;
					}
					else if(splitArrInt[1] < osplitArrInt[1])
					{
						retVal = -1;
					}
					else if(splitArrInt[1] == osplitArrInt[1])
					{
						if((splitArrInt.length >= 3 && osplitArrInt.length >= 3))
						{
							if(splitArrInt[2] > osplitArrInt[2])
							{
								retVal = 1;
							}
							else if(splitArrInt[2] < osplitArrInt[2])
							{
								retVal = -1;
							}
							else if(splitArrInt[2] == osplitArrInt[2])
							{
								retVal = 0;
							}
						}
						else
							retVal = 0;

					}
				}
				else
					retVal = 0;

			}

		}
		else
		{
			retVal = (this.softwarecategory.compareToIgnoreCase(s.softwarecategory));
		}

		return retVal;
	}

	public static int getDecimalCount(String str)
	{
		int count = 0;

		char[] chr = str.trim().toCharArray();

		for(char x : chr)
		{
			if(x == '.') count++;
		}
		return count;
	}

	@Override
	public String toString()
	{
		return "Software [softwarecategory=" + softwarecategory + ", softwareName=" + softwareName + ", version="
				+ version + "]";
	}

}
