package others;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo
{

	public static void main(String[] args) throws FileNotFoundException
	{
		File f = new File("C:\\Users\\PIKS-PC\\Desktop\\Files\\file3.txt");
		
		String read= readFromRandomAccessFile(f, 1);
		
		System.out.println("the line is: "+read);
		
	}

	public static String readFromRandomAccessFile(File f, int position)
	{
		String record = null;
		try
		{
			RandomAccessFile fileStore = new RandomAccessFile(f, "r");
			// moves file pointer to position specified
			fileStore.seek(position);
			// reading String from
			record = fileStore.readUTF();
			fileStore.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return record;
	}
}
