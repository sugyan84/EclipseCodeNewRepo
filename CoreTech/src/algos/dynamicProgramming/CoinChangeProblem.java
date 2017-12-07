package algos.dynamicProgramming;

import java.util.Arrays;

public class CoinChangeProblem
{
	public static void solveProblem(int amount, int[] coins)
	{
		//build 2-D array
		//Rows: contains COIN denominations.
		//Columns: Contain the amount to be formed from coins. [colmuns is +1 because we dont compute for 0 amount]
		//Cell: Will compute and populate the cell with minimum no. of coins required to add upto the amount in that particular column.
		int[][] masterArray= new int[coins.length][amount+1];

		//Sort the coins denomination array
		Arrays.sort(coins);


		//Fill first column with 0's
		for(int r=0; r<coins.length; r++)
		{
			masterArray[r][0]= 0;
		}

		//Let's compute minimum no.of coins required
		for(int r=0; r< coins.length; r++)	//Travel through each COIN denomination
		{
			int currentDenominationValue= coins[r];

			for(int c=1; c<amount+1; c++)
			{
				int noOfCoinsRequired = c/(coins[r]);

				if(r==0)
				{
					masterArray[r][c]= noOfCoinsRequired;	//populate the first row directly by dividing;
				}
				else	//else for next rows, compute as per formulae.
				{
					//Math.min(a, b);

					//Get upper cell's value
					int upperCellValue= masterArray[r-1][c];

					//no. of Steps to come back and check value
					int backSteps = coins[r];

					int backStepsCellValue=0;
					
					//Value at backSteps cell
					if(c-backSteps < 0)
					{
						//backStepsCellValue = masterArray[r][0];
						masterArray[r][c] = upperCellValue;
					}
						
					else
					{
						backStepsCellValue = masterArray[r][c-backSteps];

						masterArray[r][c] = Math.min(upperCellValue, backStepsCellValue+1);
						
					}
						
				}

			}

		}

		System.out.println("Minimum no.of Coins required= "+masterArray[coins.length-1][amount]);
		
		int r = coins.length;
		int c = amount+1;
		
		for(int i = 0; i<r; i++)
		{
			for(int j=0; j<c; j++)
			{
				System.out.print(masterArray[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		int[] coins = {1, 12, 5};
		
		solveProblem(15, coins);
	}
}