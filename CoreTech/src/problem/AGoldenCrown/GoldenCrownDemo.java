package problem.AGoldenCrown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GoldenCrownDemo
{
	static Map<String, String>		kingDom_Emblem				= new HashMap<String, String>();

	static Map<String, Map>			kingDom_EmblemLetterCount	= new TreeMap<String, Map>();

	static Map<Character, Integer>	msg_WordCount				= new TreeMap<Character, Integer>();

	static List<String>				messages					= new ArrayList<String>();

	static Set<String>				acquiredKingdoms			= new HashSet<String>();

	static BufferedReader			br							= null;

	static String					fileName					= "E:\\STUDY\\Eclipse Workspace\\CoreTech\\src\\problem\\AGoldenCrown\\secretMessages.txt";

	static boolean isDigitAllowedInMsg = false;
	
	public static void init()
	{
		kingDom_Emblem.put("land", "panda");
		kingDom_Emblem.put("water", "octopus");
		kingDom_Emblem.put("ice", "mammoth");
		kingDom_Emblem.put("air", "owl");
		kingDom_Emblem.put("fire", "dragon");
		kingDom_Emblem.put("space", "gorilla");

		try
		{
			br = new BufferedReader(new FileReader(new File(fileName)));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		convertToWordCount();
	}

	private static void convertToWordCount()
	{
		Set<Map.Entry<String, String>> mapKeySet = kingDom_Emblem.entrySet();

		Iterator keysIterator = mapKeySet.iterator();

		while (keysIterator.hasNext())
		{
			Map.Entry<String, String> thisEntry = (Map.Entry<String, String>) keysIterator.next();

			Map<Character, Integer> letterFrequency = new HashMap<Character, Integer>();

			String emblemString = thisEntry.getValue();
			char[] emblemCharArray = emblemString.toCharArray();

			for(char x : emblemCharArray)
			{
				if(letterFrequency.containsKey(x))
				{
					letterFrequency.put(x, letterFrequency.get(x) + 1);
				}
				else
				{
					letterFrequency.put(x, 1);
				}
			}

			kingDom_EmblemLetterCount.put(thisEntry.getKey(), letterFrequency);

		}
	}

	public static void putLetterCountInMap(String word)
	{
		char[] emblemCharArray = word.toCharArray();

		for(char x : emblemCharArray)
		{
			x = Character.toLowerCase(x);
			
			if(Character.isLetter(x) || isDigitAllowedInMsg)
			{
					System.out.println(x);
				if(msg_WordCount.containsKey(x))
				{
					msg_WordCount.put(x, msg_WordCount.get(x) + 1);
				}
				else
				{
					msg_WordCount.put(x, 1);
				}
			}
		}
	}

	private static String[] preProcessInputString(String inputString)
	{
		String[] splitStr = inputString.split(",");

		splitStr[0] = splitStr[0].trim().toLowerCase();
		splitStr[1] = splitStr[1].trim().toLowerCase().substring(1, splitStr[1].trim().toLowerCase().length() - 1);

		if(!kingDom_EmblemLetterCount.containsKey(splitStr[0].trim().toLowerCase()))
		{
			try
			{
				throw new InvalidInputDataException("Invalid Kingdom Name");
			}
			catch(InvalidInputDataException e)
			{
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}

		return splitStr;
	}

	private static void readSecretMessages()
	{
		String inputLine = "";

		try
		{
			while ((inputLine = br.readLine()) != null)
			{
				System.out.println(inputLine);
				messages.add(inputLine.trim());

			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null) try
			{
				br.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	private static void process(String inputStr)
	{
		boolean status = true;

		String[] splitStr = preProcessInputString(inputStr);

		putLetterCountInMap(splitStr[1]);

		Map m = (Map) kingDom_EmblemLetterCount.get(splitStr[0]);
		Iterator itr = m.entrySet().iterator();

		while (itr.hasNext())
		{
			Map.Entry<Character, Integer> emblemKey = (Map.Entry<Character, Integer>) itr.next();

			char key = (char) emblemKey.getKey();
			int valOfEmblem = (int) emblemKey.getValue();

			if(msg_WordCount.containsKey(key))
			{
				int valOfMsg = (int) msg_WordCount.get(key);

				if(valOfMsg < valOfEmblem)
				{
					status = false;
					break;
				}
			}
			else
			{
				status = false;
				break;
			}
		}

		if(status)
		{
			// System.out.println("Kingdom acquired!");
			acquiredKingdoms.add(splitStr[0]);
		}
		else
		{
			// System.out.println("Failed");
		}

		msg_WordCount.clear();
	}

	private static void processSecretMessages()
	{
		Iterator msgItr = messages.iterator();

		while (msgItr.hasNext())
		{
			String s = (String) msgItr.next();

			process(s);
		}
	}

	private static void showResult()
	{
		if(acquiredKingdoms.size() >= 3)
		{
			System.out.print("\nAllies of King Shan: ");
			for(String s : acquiredKingdoms)
			{
				System.out.print(s + ", ");
			}
		}
		else
		{
			System.out.println("No Kingdom acquired");
		}
	}

	public static void main(String[] args)
	{
		init();

		readSecretMessages();

		processSecretMessages();

		showResult();
	}

}
