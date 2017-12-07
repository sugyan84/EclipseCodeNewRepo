package algos.graphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph
{
	/*
	 * Makes use of Map collection to store the adjacency list for each vertex.
	 */
	private Map<Integer, List<Integer>> Adjacency_List;

	/*
	 * Initializes the map to with size equal to number of vertices in a graph
	 * Maps each vertex to a given List Object
	 */
	public Graph(int number_of_vertices)
	{
		Adjacency_List = new HashMap<Integer, List<Integer>>();
		for(int i = 1; i <= number_of_vertices; i++)
		{
			Adjacency_List.put(i, new LinkedList<Integer>());
		}
	}

	/* Adds nodes in the Adjacency list for the corresponding vertex */
	public void setEdge(int source, int destination)
	{
		if(source > Adjacency_List.size() || destination > Adjacency_List.size())
		{
			System.out.println("the vertex entered in not present ");
			return;
		}
		List<Integer> slist = Adjacency_List.get(source);
		slist.add(destination);
		List<Integer> dlist = Adjacency_List.get(destination);
		dlist.add(source);

		Collections.sort(slist);
		Collections.sort(dlist);
	}

	/* Returns the List containing the vertex joining the source vertex */
	public List<Integer> getEdge(int source)
	{
		if(source > Adjacency_List.size())
		{
			System.out.println("the vertex entered is not present");
			return null;
		}
		return Adjacency_List.get(source);
	}

	public boolean isConnected(int source, int destination)
	{
		boolean retValue = false;
		// Your code here.

		return retValue;
	}

	public Map<Integer, List<Integer>> getAdjacency_List()
	{
		return Adjacency_List;
	}

	public void traverseBFS()
	{
		Map m = this.getAdjacency_List();

		LinkedList queue = new LinkedList();

		HashSet isVisited = new HashSet();

		Integer currNode = null;

		Set s = m.entrySet();

		Iterator itr = s.iterator();

		if(itr.hasNext())
		{
			Map.Entry me = (Map.Entry) itr.next();

			queue.add(me.getKey());

			//System.out.println("First element got is : " + me.getKey());

			while (queue.size() != 0)
			{

				currNode = (Integer) queue.remove();
				//System.out.println("Removed from Queue: "+currNode);

				if(isVisited.contains(currNode))
				{

				}
				else
				{
					// Not visited.
					System.out.print(currNode+", ");
					isVisited.add(currNode);

					// Get all its adjacent Nodes linked.
					LinkedList ladj = (LinkedList) m.get(currNode);
					Iterator itradj = ladj.iterator();

					//System.out.println("Adding adjacent nodes of: " + currNode);
					while (itradj.hasNext())
					{
						Integer it = (Integer) itradj.next();

						queue.add(it);

						//System.out.print(it + "|");
					}
					//System.out.println("\n");
				}

			}

		}
	}

}
