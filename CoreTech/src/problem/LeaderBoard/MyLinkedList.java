package problem.LeaderBoard;

public class MyLinkedList
{
	Node	head;
	Node	last;
	Node	alice;
	long	size;

	public MyLinkedList(Node head)
	{
		this.head = head;
		this.last = head;
		this.last.next = null;
		this.head.prev = null;
		this.size++;
	}

	public void alloteRanks()
	{
		Node curr = head;

		int rank = 1;

		while (curr != null)
		{
			Node prev = curr.getPrev();

			if(prev == null)
			{
				curr.setRank(rank);
			}
			else if(prev != null && prev.score == curr.score)
			{
				curr.setRank(rank);
			}
			else if(prev != null && prev.score != curr.score)
			{

				curr.setRank(++rank);
			}

			curr = curr.next;
		}
	}

	public void sort()
	{
		// Enter loop only if there are elements in list
		boolean swapped = (head != null);

		// Only continue loop if a swap is made
		while (swapped)
		{
			swapped = false;

			// Maintain pointers
			Node curr = head;
			Node next = curr.next;
			Node prev = null;

			// Cannot swap last element with its next
			while (next != null)
			{
				// swap if items in wrong order
				if(curr.compareTo(next) < 0)
				{
					// notify loop to do one more pass
					swapped = true;

					// swap elements (swapping head in special case
					if(curr == head)
					{
						head = next;
						Node temp = next.next;
						next.next = curr;
						next.setPrev(null);
						curr.next = temp;
						curr.setPrev(next);
						curr = head;
					}
					else
					{
						prev.next = curr.next;
						next.setPrev(prev);
						curr.next = next.next;
						if(next.next != null) next.next.setPrev(curr);
						next.next = curr;
						curr = next;
					}
				}

				// move to next element
				prev = curr;
				curr = curr.next;
				next = curr.next;
			}
		}
	}

	public void adjustRanksTillEnd(Node p)
	{
		Node currNode = null;

		if(p == null)
		{
			// head case
			currNode = this.head.getNext();
		}
		else
			currNode = p.getNext();

		Node prevNode = p;

		while (currNode != null)
		{
			if(prevNode != null) if(currNode.score == prevNode.score)
			{
				// same rank inserted
				currNode.setRank(prevNode.getRank());

				break;
			}
			else if(currNode.score < prevNode.score)
			{
				// if NewNode
				if(currNode.rank == 0)
				{
					currNode.setRank(prevNode.getRank() + 1);
				}
				else
				{
					// Increment existing rank by 1
					currNode.setRank(currNode.getRank() + 1);
				}
			}
			else
			{

			}
			currNode = currNode.getNext();
		}
	}

	public void add(Node newNode)
	{
		this.last.next = newNode;
		newNode.prev = this.last;
		this.last = newNode;

	}

	public void addAtDeservedPosition(Node newNode)
	{

		Node addNext = this.head;
		Node addPrev = addNext.getPrev();

		while (addNext != null)
		{
			if(addPrev == null)
			{
				if(newNode.score >= addNext.score)
				{
					// add before head

					newNode.setNext(addNext);
					addNext.setPrev(newNode);
					newNode.setPrev(null);
					newNode.setRank(1);
					this.size++;
					this.head = newNode;
					// call adjust ranks (addPrev)
					adjustRanksTillEnd(newNode);
					break;

				}
				else if(newNode.score <= addNext.score && this.size == 1)
				{
					// add after head, when only head Node present
					newNode.setPrev(addNext);
					newNode.setNext(null);

					if(addNext.score == newNode.score)
						newNode.setRank(addNext.getRank());
					else
						newNode.setRank(addNext.getRank() + 1);

					addNext.setNext(newNode);
					this.size++;

					break;
				}
			}
			else
			{
				if(newNode.score <= addPrev.score && newNode.score > addNext.score)
				{
					// add Node in between addPrev & addNext
					newNode.setPrev(addPrev);
					newNode.setNext(addNext);

					addPrev.setNext(newNode);
					addNext.setPrev(newNode);

					// call adjust ranks (addPrev)
					adjustRanksTillEnd(addPrev);
					this.size++;
					break;
				}
				else if(addNext.getNext() == null)
				{
					// we are at last Node now, add at last.
					newNode.setPrev(addNext);
					newNode.setNext(null);

					if(addNext.score == newNode.score)
						newNode.setRank(addNext.getRank());
					else
						newNode.setRank(addNext.getRank() + 1);

					addNext.setNext(newNode);

					break;
				}

			}

			// move 1 step forward
			addPrev = addNext;
			addNext = addNext.getNext();
		}

	}

	public void traverseList()
	{
		Node curr = head;

		System.out.println("\n");
		while (curr != null)
		{
			System.out.print(curr.score + "(" + curr.rank + ")" + "-> ");
			curr = curr.next;
		}

		System.out.println("\n");
	}
}
