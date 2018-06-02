package problem.opentext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RoomAllocater
{
	static int				max_Rooms;
	static Set<Character>	occupiedList	= new HashSet<Character>();
	static Set<Character>	waitingList		= new HashSet<Character>();

	static String			inputString;

	public static void readInput()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try
		{
			inputString = br.readLine().trim();

			max_Rooms = Integer.parseInt(br.readLine().trim());
		}
		catch(IOException ex)
		{
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public static int computeUnSatisfiedCustomers()
	{
		int unSatisfiedCustomersCount = 0;

		int occupiedRooms = 0;

		char[] arr = inputString.toCharArray();

		for (char x : arr)
		{
			if(occupiedList.contains(x))
			{
				// remove it - he left the room
				occupiedRooms--;
				occupiedList.remove(x);
			}
			else
			{
				// Is he waiting?
				if(waitingList.contains(x))
				{

					// waiting customer- leaving.
					unSatisfiedCustomersCount++;
					waitingList.remove(x);
				}
				else
				{
					// new customer- try to allocate room
					if(occupiedRooms < max_Rooms)
					{
						// give room key.
						occupiedList.add(x);
						occupiedRooms++;
					}
					else
					{
						// ask him to wait.
						waitingList.add(x);
					}
				}
			}
		}

		return unSatisfiedCustomersCount;
	}

	public static void main(String[] args)
	{
		readInput();
		
		System.out.println(computeUnSatisfiedCustomers());
	}
}
