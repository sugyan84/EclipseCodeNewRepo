package threading_arrayAdding;

public class DemoArrayAdding
{

	public static void main(String[] args) throws InterruptedException
	{
		int[] a=new int[]{1,2,3,4,5,6,7,8,9,10};
		
		ArrayAddingThread t1=new ArrayAddingThread(a);
		ArrayAddingThread t2=new ArrayAddingThread(a);
		
		t1.setName("First Half");
		t2.setName("Second Half");
		
		t1.start();
		t2.start();

		t1.join();
		t2.join();
		
		System.out.println("Sum is "+ArrayAddingThread.sum);
	}

}
