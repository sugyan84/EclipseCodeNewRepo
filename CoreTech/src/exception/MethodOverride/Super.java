package exception.MethodOverride;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Super
{
	void show() throws IOException
	{
		
	}
}



class Sub extends Super
{
	void show() throws FileNotFoundException
	{
		
	}
}