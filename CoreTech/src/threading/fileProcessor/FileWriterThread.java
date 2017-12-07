package threading.fileProcessor;

public class FileWriterThread implements Runnable
{

	FileDetails f;
	
	
	
	public FileWriterThread(FileDetails f)
	{
		this.f = f;
	}



	@Override
	public void run()
	{
		try
		{
			this.f.writeToFile();
		}
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
