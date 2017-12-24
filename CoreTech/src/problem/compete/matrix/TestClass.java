package problem.compete.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestClass
{
	static int[][] matrix = null;

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Scanner s = new Scanner(System.in);

		System.out.println("rading");
		int T = Integer.parseInt(br.readLine());
		
		System.out.println(T);

		for(int i = 0; i < T; i++)
		{
			int n = s.nextInt();
			int m = s.nextInt();

			matrix = new int[n][m];
			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < m; k++)
				{
					matrix[j][k] = s.nextInt();
				}
			}

			Set<String> set = new HashSet<>();

			List<Boolean> setTF = new ArrayList<>();

			for(int j = 0; j < m; j++)// excluding column
			{
				set.clear();
				setTF.clear();

				for(int r = 0; r < n; r++)
				{
					StringBuffer sbfr = new StringBuffer();

					for(int p = 0; p < m; p++)
					{
						if(p == j)
						{
							continue;
						}

						sbfr.append(matrix[r][p]);
					}

					setTF.add(set.add(sbfr.toString()));

				}

				if(!setTF.contains(false))
				{
					System.out.println("Yes");
					break;
				}

			}

			System.out.println("No");
		}

	}
}
