package StringOps.StringSplit;

class StringSplitDemo
{

	public static void main(String args[])
	{
		String test = "This is a Test";
		String[] tokens = test.split("\\s");
		System.out.println(tokens.length);
	}
}
