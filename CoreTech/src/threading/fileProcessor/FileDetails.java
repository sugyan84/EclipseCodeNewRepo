package threading.fileProcessor;

import java.io.*;
import java.util.Set;

public class FileDetails
{

	String fileName;
	String writeToFile;
	boolean read;
	String data;
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fw = null;
	BufferedWriter bw = null;

	
	
	public FileDetails()
	{
		//super();
	}

	public void readFromFile() throws Exception
	{
		String temp=null;
		
		fr= new FileReader(fileName);
		br=new BufferedReader(fr);
		
			while((temp=br.readLine())!=null)
			{
				
				synchronized(this)
				{
				while(Thread.currentThread().getName().equalsIgnoreCase("ReadingThread") && this.data!=null)
				{
					wait();
				}
				}
				
				this.data=temp;
				System.out.println("Read "+this.data);
				temp=null;
				
				synchronized (this)
				{
					notify();
				}
				
				
				
				
			}
			
			this.br.close();
		
	}
	
	
	public void writeToFile() throws Exception
	{
		String temp=null;
		
		fw= new FileWriter(writeToFile);
		bw=new BufferedWriter(fw);
		
		//
		Thread t = this.getThreadByName("ReadingThread");
		
		while(t.isAlive() || this.data!=null)
		{
			synchronized(this)
			{
			
			while(Thread.currentThread().getName().equalsIgnoreCase("WritingThread") && this.data==null)
			{
				wait();
			}
			}
			
			System.out.println("Writing "+this.data+"\n");
			bw.write(this.data+"\n");
		
			this.data=null;
			
			synchronized (this)
			{
				notify();
			}
		}
		
		
		this.bw.close();
		
	}
	
	
	
	public synchronized Thread getThreadByName(String threadName) {
	    Thread __tmp = null;

	    Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
	    Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);

	    for (int i = 0; i < threadArray.length; i++) {
	        if (threadArray[i].getName().equals(threadName))
	            __tmp =  threadArray[i];
	    }

	    return __tmp;
	}
	
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------
	
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public boolean isRead()
	{
		return read;
	}
	public void setRead(boolean read)
	{
		this.read = read;
	}
	public String getData()
	{
		return data;
	}
	public void setData(String data)
	{
		this.data = data;
	}

	public String getWriteToFile()
	{
		return writeToFile;
	}

	public void setWriteToFile(String writeToFile)
	{
		this.writeToFile = writeToFile;
	}

	@Override
	protected void finalize() throws Throwable
	{
		this.br.close();
		this.bw.close();
		System.out.println("Finalize");
	}
	
		
	
}
