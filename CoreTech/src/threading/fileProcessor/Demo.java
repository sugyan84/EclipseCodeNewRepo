package threading.fileProcessor;

import java.util.Random;


/*
 * This program reads from a File (with one Thread), stores the line in a buffer(String variable), 
 * and other Thread writes the buffer data 
 * to another file.
 */
public class Demo
{

	public static void main(String[] args)
	{
		FileDetails fd = new FileDetails();
		
		fd.fileName="C:\\Users\\PIKS-PC\\Desktop\\hugeFile.txt";
		fd.setRead(true);
		fd.setData(null);
		
		fd.writeToFile="C:\\Users\\PIKS-PC\\Desktop\\writeFile.txt";
		
		FileReaderThread frt = new FileReaderThread(fd);
		Thread t1 = new Thread(frt, "ReadingThread");
		
		FileWriterThread fwt = new FileWriterThread(fd);
		Thread t2 = new Thread(fwt, "WritingThread");

		
		t1.start();
		t2.start();
		
	}

}