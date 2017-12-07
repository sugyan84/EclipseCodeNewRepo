package problem.LeaderBoard;

import java.util.Scanner;

public class Solution
{

	static MyLinkedList l = null;

	public static void main(String[] args)
	{

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] scores = new int[n];

		for(int i = 0; i < n; i++)
		{

			scores[i] = in.nextInt();

			if(i == 0)
			{
				Node headNode = new Node(scores[i]);
				headNode.setRank(1);
				l = new MyLinkedList(headNode);
			}
			else
			{
				l.addAtDeservedPosition(new Node(scores[i]));
			}
		}

		l.traverseList();

		int m = in.nextInt();
		int[] alice = new int[m];
		for(int j = 0; j < m; j++)
		{

			alice[j] = in.nextInt();
			task(alice[j]);
		}

		l.traverseList();

	}

	public static void task(int nowScore)
	{

		Node n = new Node(nowScore);
		n.setName("Alice");

		l.addAtDeservedPosition(n);
		l.alice = n;

		System.out.println("Alice rank: " + l.alice.rank);

	}
}
