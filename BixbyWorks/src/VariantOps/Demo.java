package VariantOps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo
{
	static HashMap m = new HashMap();

	{
		m.put('(', ')');
		m.put(')', '(');

		m.put('{', '}');
		m.put('}', '{');

		m.put('[', ']');
		m.put(']', '[');
	}

	public static BufferedReader readFile(File f)
	{
		BufferedReader br = null;

		try
		{
			br = new BufferedReader(new FileReader(f));
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}

		return br;
	}

	public static List readFileToList(String string)
	{
		BufferedReader br = null;
		String str = null;
		List l = new ArrayList<String>();

		try
		{
			br = new BufferedReader(new FileReader(new File(string)));

			while ((str = br.readLine()) != null)
			{
				l.add(str);
			}

		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}

		return l;
	}

	public static List<String> getSimpleBracesWords(String s)
	{
		List<String> l = new ArrayList<String>();
		Stack st = new Stack();
		char startBrace = '(';
		char endBrace = ')';

		char[] charArr = s.toCharArray();
		boolean startPushing = false;
		StringBuffer bfr = new StringBuffer();

		for(char a : charArr)
		{
			if(a == startBrace || startPushing == true)
			{
				if(a != endBrace) st.push(a);
				startPushing = true;
			}

			if(a == endBrace)
			{
				char x = ' ';
				StringBuffer prepareStackTakeOut = new StringBuffer();
				while (true)
				{
					x = (char) st.pop();
					if(x == startBrace)
						break;
					else
					{
						prepareStackTakeOut.append(x);
					}
				}
				prepareStackTakeOut = prepareStackTakeOut.reverse();
				l.add(prepareStackTakeOut.toString());
				startPushing = false;
			}
		}

		return l;
	}

	public static List<String> getSquareBracesWords(String s)
	{
		List<String> l = new ArrayList<String>();
		Stack st = new Stack();
		char startBrace = '[';
		char endBrace = ']';

		char[] charArr = s.toCharArray();
		boolean startPushing = false;
		StringBuffer bfr = new StringBuffer();

		for(char a : charArr)
		{
			if(a == startBrace || startPushing == true)
			{
				if(a != endBrace) st.push(a);
				startPushing = true;
			}

			if(a == endBrace)
			{
				char x = ' ';
				StringBuffer prepareStackTakeOut = new StringBuffer();
				while (true)
				{
					x = (char) st.pop();
					if(x == startBrace)
						break;
					else
					{
						prepareStackTakeOut.append(x);
					}
				}
				prepareStackTakeOut = prepareStackTakeOut.reverse();
				l.add(prepareStackTakeOut.toString());
				startPushing = false;
			}
		}

		return l;
	}

	public static List<String> getCurlyBracesWords(String s)
	{
		List<String> l = new ArrayList<String>();
		Stack st = new Stack();
		char startBrace = '{';
		char endBrace = '}';

		char[] charArr = s.toCharArray();
		boolean startPushing = false;
		StringBuffer bfr = new StringBuffer();

		for(char a : charArr)
		{
			if(a == startBrace || startPushing == true)
			{
				if(a != endBrace) st.push(a);
				startPushing = true;
			}

			if(a == endBrace)
			{
				char x = ' ';
				StringBuffer prepareStackTakeOut = new StringBuffer();
				while (true)
				{
					x = (char) st.pop();
					if(x == startBrace)
						break;
					else
					{
						prepareStackTakeOut.append(x);
					}
				}
				prepareStackTakeOut = prepareStackTakeOut.reverse();
				l.add(prepareStackTakeOut.toString());
				startPushing = false;
			}
		}

		return l;
	}

	public static List<String> trial(String s)
	{

		List<String> l = new ArrayList<String>();
		Stack st = new Stack();
		char startBrace = '[';
		char endBrace = ']';

		int openCount = 0;
		int closeCount = 0;

		char[] charArr = s.toCharArray();
		boolean startPushing = false;
		StringBuffer bfr = new StringBuffer();

		for(char a : charArr)
		{
			st.push(a);
			if(a == startBrace)
				openCount++;
			else if(a == endBrace) closeCount++;
			startPushing = true;

			if(openCount == closeCount && openCount != 0/* a == endBrace */)
			{
				char x = ' ';
				StringBuffer prepareStackTakeOut = new StringBuffer();
				int i = 0;

				while (openCount != 0)
				{
					i++;

					x = (char) st.pop();

					if(x == startBrace)
						openCount--;
					else if(x == endBrace) closeCount--;

					if(i == 1 || openCount == 0)
					{
						// jatra
					}
					else
					{
						prepareStackTakeOut.append(x);
					}

				}
				prepareStackTakeOut = prepareStackTakeOut.reverse();
				l.add(prepareStackTakeOut.toString());
				startPushing = false;
			}
		}
		
		

		return l;

	}

	public static void processString(String s)
	{
		Iterator itr = trial(s).iterator();

		while (itr.hasNext())
		{
			System.out.println("Simple: " + itr.next());
		}

	}

	public static void main(String[] args) throws Exception
	{
		List ll = readFileToList("C:\\Users\\PIKS-PC\\Desktop\\Files\\file2.txt");

		Iterator itr = ll.iterator();

		while (itr.hasNext())
		{
			processString((String) itr.next());
		}

	}

}
