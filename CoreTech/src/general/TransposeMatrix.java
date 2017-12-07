package general;

public class TransposeMatrix
{

	public static void main(String[] args)
	{
		int[][] orig = new int[4][3];
		
		int[][] trans=new int[3][4];
		
		orig[0][0]=3;
		orig[0][1]=5;
		orig[0][2]=7;
		orig[1][0]=8;
		orig[1][1]=2;
		orig[1][2]=5;
		orig[2][0]=4;
		orig[2][1]=8;
		orig[2][2]=2;
		orig[3][0]=4;
		orig[3][1]=7;
		orig[3][2]=9;

		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(orig[j][i]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
			
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<4;j++)
			{
				trans[i][j]=orig[j][i];
			}
					
		}
				  
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(trans[j][i]+" ");
			}
			System.out.println();
		}

	}

}
