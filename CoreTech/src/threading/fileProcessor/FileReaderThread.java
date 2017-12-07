package threading.fileProcessor;

public class FileReaderThread implements Runnable
{

	FileDetails f;
	
	
	
	public FileReaderThread(FileDetails f)
	{
		this.f = f;
	}



	@Override
	public void run()
	{
		try
		{
			this.f.readFromFile();
		}
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
