package problem.compete.Cognizant.schoolPrayer;

public class MyList
{
	Node	head;
	Node	tail;

	public MyList()
	{
		this.head = null;
		this.tail = null;
	}

	public int addNode(Node newNode)
	{
		int retVal = -1;

		if(this.head == null)
		{
			// Creation of head Node
			this.head = newNode;
			newNode.next = null;
			this.tail = newNode;

			retVal = -1;
		}
		else
		{
			// head is not null

			Node before = null;
			Node after = this.head;

			boolean isAdded = false;

			while (!isAdded)
			{
				if(before == null)
				{
					if(newNode.data < after.data)
					{
						// added at Head
						newNode.next = this.head;
						this.head = newNode;
						isAdded = true;
						break;
					}
					else if(newNode.data > after.data && after.next == null)
					{
						// add as Second node
						after.next = newNode;
						newNode.next = null;
						this.tail = newNode;
						isAdded = true;
						retVal = after.data;
						break;
					}
					else
					{
						// move pointers forward
						before = after;
						after = after.next;

					}
				}

				//
				//System.out.println(before + ", " + newNode + ", " + after);
				
				if(after == null && before != null)
				{
					// added at last Node
					before.next = newNode;
					newNode.next = null;
					isAdded = true;
					retVal = before.data;
					break;
				}
				else if(newNode.data > before.data && newNode.data < after.data)
				{
					// add in-between these before and after nodes
					newNode.next = after;
					before.next = newNode;

					isAdded = true;
					retVal = before.data;
					break;
				}
				else
				{
					// move pointers forward
					after = after.next;
					before = before.next;
				}

			}

		}

		return retVal;
	}
}
