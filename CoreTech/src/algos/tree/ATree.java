package algos.tree;

import java.util.ArrayDeque;
import java.util.Queue;

import algos.tree.TreeNode.NodePosition;

public class ATree<T extends Comparable<T>>
{
	TreeNode<T>	root;
	int			depth;
	int			height;
	int			size				= 0;
	boolean		duplicateAllowed	= false;

	public ATree()
	{
		this.root = null;
	}

	public boolean insertElement(TreeNode<T> newNode)
	{
		boolean status = false;

		TreeNode<T> currentNode = this.root;

		while (!status)
		{
			if(this.root == null)
			{
				this.root = newNode;
				currentNode = this.root;
				this.root.setParent(null);
				this.root.setPositionFromParent(NodePosition.ROOT);
				size++;
				status = true;
				// System.out.println("Inserted " + newNode.getValue() + " to
				// Root " + currentNode.getValue());
				break;
			}
			int c = currentNode.getValue().compareTo(newNode.getValue());

			if(c > 0)
			{

				if(currentNode.getLeft() != null)
				{
					currentNode = currentNode.getLeft();
					continue;
				}
				else
				{
					newNode.setParent(currentNode);
					newNode.setPositionFromParent(NodePosition.LEFT);
					currentNode.setLeft(newNode);

					size++;
					status = true;
					// System.out.println("Inserted " + newNode.getValue() + "
					// to Left of " + currentNode.getValue());
				}

			}
			else if(c < 0)
			{

				if(currentNode.getRight() != null)
				{
					currentNode = currentNode.getRight();
					continue;
				}
				else
				{

					newNode.setParent(currentNode);
					newNode.setPositionFromParent(NodePosition.RIGHT);
					currentNode.setRight(newNode);
					size++;
					status = true;
					// System.out.println("Inserted " + newNode.getValue() + "
					// to Right of " + currentNode.getValue());
				}
			}
			else if(c == 0) // When duplicate value comes to get inserted
			{
				if(duplicateAllowed) currentNode.count++;

			}

		}

		return status;
	}

	public boolean insertElement(T newValue)
	{
		boolean status = false;

		TreeNode<T> newNode = new TreeNode<T>(newValue);

		TreeNode<T> currentNode = this.root;

		while (!status)
		{
			if(this.root == null)
			{
				this.root = newNode;
				currentNode = this.root;
				this.root.setParent(null);
				this.root.setPositionFromParent(NodePosition.ROOT);
				size++;
				status = true;
				// System.out.println("Inserted " + newNode.getValue() + " to
				// Root " + currentNode.getValue());
				break;
			}
			int c = currentNode.getValue().compareTo(newNode.getValue());

			if(c > 0)
			{

				if(currentNode.getLeft() != null)
				{
					currentNode = currentNode.getLeft();
					continue;
				}
				else
				{
					newNode.setParent(currentNode);
					newNode.setPositionFromParent(NodePosition.LEFT);
					currentNode.setLeft(newNode);

					size++;
					status = true;
					// System.out.println("Inserted " + newNode.getValue() + "
					// to Left of " + currentNode.getValue());
				}

			}
			else if(c < 0)
			{

				if(currentNode.getRight() != null)
				{
					currentNode = currentNode.getRight();
					continue;
				}
				else
				{

					newNode.setParent(currentNode);
					newNode.setPositionFromParent(NodePosition.RIGHT);
					currentNode.setRight(newNode);
					size++;
					status = true;
					// System.out.println("Inserted " + newNode.getValue() + "
					// to Right of " + currentNode.getValue());
				}
			}
			else if(c == 0) // When duplicate value comes to get inserted
			{
				if(duplicateAllowed) currentNode.count++;

			}

		}

		return status;
	}

	public SearchResult searchElement(TreeNode<T> findNode)
	{
		// TreeNode<T> findNode = new TreeNode<T>(findValue);

		boolean found = false;
		SearchResult result = new SearchResult();

		TreeNode<T> currentNode = this.root;

		int s = this.getSize();
		int i = 0;
		while (i < s)
		{
			if(currentNode != null)
			{
				i++;
				if(currentNode.getValue().equals(findNode.getValue()))
				{
					System.out.println("Found " + findNode.getValue() + " at if() " + currentNode.getValue());
					// findNode.setParent(currentNode.getParent());
					result.setParent(currentNode.getParent());
					System.out.println("Parentttttttttt " + currentNode.getParent().getValue());
					result.setTarget(currentNode);
					result.setFound(true);
					break;
				}

			}

			int c = currentNode.getValue().compareTo(findNode.getValue());

			if(c > 0) // lesser
			{

				if(currentNode.getLeft() != null)
				{
					currentNode = currentNode.getLeft();
					continue;
				}
				else
				{
					result.setFound(false);
					break;
				}

			}
			else if(c < 0) // greater
			{

				if(currentNode.getRight() != null)
				{
					currentNode = currentNode.getRight();
					continue;
				}
				else
				{
					result.setFound(false);
					break;
				}
			}

		}

		// System.out.println("Returning ...."+result.getTarget().getLeft());
		return result;

	}

	public SearchResult searchElement(T findValue)
	{
		TreeNode<T> findNode = new TreeNode<T>(findValue);

		boolean found = false;
		SearchResult result = new SearchResult();

		TreeNode<T> currentNode = this.root;

		int s = this.getSize();
		int i = 0;
		while (i < s)
		{
			if(currentNode != null)
			{
				i++;
				if(currentNode.getValue().equals(findNode.getValue()))
				{
					System.out.println("Found " + findNode.getValue() + " at if() " + currentNode.getValue());
					// findNode.setParent(currentNode.getParent());
					result.setParent(currentNode.getParent());
					result.setTarget(findNode);
					result.setFound(true);
					break;
				}

			}

			int c = currentNode.getValue().compareTo(findNode.getValue());

			if(c > 0) // lesser
			{

				if(currentNode.getLeft() != null)
				{
					currentNode = currentNode.getLeft();
					continue;
				}
				else
				{
					result.setFound(false);
					break;
				}

			}
			else if(c < 0) // greater
			{

				if(currentNode.getRight() != null)
				{
					currentNode = currentNode.getRight();
					continue;
				}
				else
				{
					result.setFound(false);
					break;
				}
			}

		}

		return result;

	}

	public int getHeight()
	{
		TreeNode<T> temp;
		int height = 0;

		Queue<TreeNode<T>> queue = new ArrayDeque<TreeNode<T>>();

		queue.add(root);

		TreeNode dummy = new TreeNode(Integer.MIN_VALUE);

		queue.add(dummy);

		while (!queue.isEmpty())
		{
			temp = queue.remove();

			if(temp.getValue().equals(Integer.MIN_VALUE))
			{
				height++; // Increment height
				/*
				 * Insert special node queue if queue is not empty since all
				 * nodes of that level has been covered
				 */
				if(!queue.isEmpty()) queue.add(dummy);
			}

			TreeNode<T> lc = temp.getLeft();
			TreeNode<T> rc = temp.getRight();

			if(lc != null)
			{
				queue.add(lc);
			}
			if(rc != null)
			{
				queue.add(rc);
			}

		}

		return height;
	}

	public void clearTree()
	{
		this.root = null;
	}

	public TreeNode<T> getRoot()
	{
		return root;
	}

	public void setRoot(TreeNode<T> root)
	{
		this.root = root;
	}

	public int getDepth()
	{
		this.depth = this.getHeight() - 1;
		return depth;
	}

	public int getSize()
	{
		return size;
	}

	public void printLevelOrder()
	{
		TreeNode<T> temp;
		int height = 0;

		Queue<TreeNode<T>> queue = new ArrayDeque<TreeNode<T>>();

		queue.add(root);

		TreeNode dummy = new TreeNode(Integer.MIN_VALUE);

		queue.add(dummy);

		while (!queue.isEmpty())
		{
			temp = queue.remove();

			if(!temp.getValue().equals(Integer.MIN_VALUE)) System.out.print(temp.getValue() + " ");

			if(temp.getValue().equals(Integer.MIN_VALUE))
			{
				height++; // Increment height
				/*
				 * Insert special node queue if queue is not empty since all
				 * nodes of that level has been covered
				 */
				System.out.println();

				if(!queue.isEmpty()) queue.add(dummy);
			}

			TreeNode<T> lc = temp.getLeft();
			TreeNode<T> rc = temp.getRight();

			if(lc != null)
			{
				queue.add(lc);
			}
			if(rc != null)
			{
				queue.add(rc);
			}

		}

	}

	public TreeNode<T> minNode(TreeNode<T> startNode)
	{
		TreeNode<T> min = startNode;

		while (min.getLeft() != null)
		{
			min = min.getLeft();
		}

		return min;

	}

	public TreeNode<T> maxNode(TreeNode<T> startNode)
	{
		TreeNode<T> max = startNode;

		while (max.getRight() != null)
		{
			max = max.getRight();
		}

		return max;

	}

	public boolean deleteNode(TreeNode<T> delNode)
	{
		
		
		boolean isDeleted = false;

		SearchResult elementPresent = this.searchElement(delNode);
		System.out.println("Hai ? " + elementPresent.isFound());

		if(elementPresent.isFound())
		{
			delNode = elementPresent.getTarget();
			NodePosition delNodePosition = delNode.getPositionFromParent();
			TreeNode<T> delNodeLeftChild = delNode.getLeft();
			TreeNode<T> delNodeRightChild = delNode.getRight();

			TreeNode<T> delNodeParent = delNode.getParent();
			TreeNode<T> delNodeParentLeftChild = delNodeParent.getLeft();
			TreeNode<T> delNodeparentRightChild = delNodeParent.getRight();

			if(delNode.isLeafNode()) // No child Logic [Fine]
			{
				if(delNodePosition == NodePosition.LEFT)
				{
					if(delNodeParentLeftChild.equals(delNode)) delNodeParent.setLeft(null);
				}
				else if(delNodePosition == NodePosition.RIGHT)
				{
					if(delNodeparentRightChild.equals(delNode)) delNodeParent.setRight(null);
				}

				delNode = null;
				isDeleted = true;

			}
			else if(delNodeLeftChild != null && delNodeRightChild == null) // 1-child logic (Only Left Child)
																			
			{
				T val = delNodeLeftChild.getValue();
				delNode.setLeft(null);
				delNode.setValue(val);
				isDeleted = true;
			}
			else if(delNode.getLeft() == null && delNode.getRight() != null) // 1-child logic (Only Right Child)
																				
			{
				T val = delNodeRightChild.getValue();
				delNode.setRight(null);
				delNode.setValue(val);
				isDeleted = true;
			}
			else if(delNode.getLeft() != null && delNode.getRight() != null) // 2-child Logic
			{
				if(delNodePosition==NodePosition.LEFT)
				{
					TreeNode<T> maxNode= maxNode(delNodeLeftChild);
					T val= maxNode.getValue();
					deleteNode(val);
					delNodeParentLeftChild.setValue(val);
				}
				else
					if(delNodePosition==NodePosition.RIGHT)
					{
						TreeNode<T> maxNode= maxNode(delNodeRightChild);
						T val= maxNode.getValue();
						deleteNode(val);
						delNodeparentRightChild.setValue(val);
					}
				
				isDeleted = true;
			}

		}

		return isDeleted;
	}
	
	
	
	public boolean deleteNode(T value)
	{
		TreeNode<T> delNode = new TreeNode<T>(value);
		
		boolean isDeleted = false;

		SearchResult elementPresent = this.searchElement(delNode);
		System.out.println("Hai ? " + elementPresent.isFound());

		if(elementPresent.isFound())
		{
			delNode = elementPresent.getTarget();
			NodePosition delNodePosition = delNode.getPositionFromParent();
			TreeNode<T> delNodeLeftChild = delNode.getLeft();
			TreeNode<T> delNodeRightChild = delNode.getRight();

			TreeNode<T> delNodeParent = delNode.getParent();
			TreeNode<T> delNodeParentLeftChild = delNodeParent.getLeft();
			TreeNode<T> delNodeparentRightChild = delNodeParent.getRight();

			if(delNode.isLeafNode()) // No child Logic [Fine]
			{
				if(delNodePosition == NodePosition.LEFT)
				{
					if(delNodeParentLeftChild.equals(delNode)) delNodeParent.setLeft(null);
				}
				else if(delNodePosition == NodePosition.RIGHT)
				{
					if(delNodeparentRightChild.equals(delNode)) delNodeParent.setRight(null);
				}

				delNode = null;
				isDeleted = true;

			}
			else if(delNodeLeftChild != null && delNodeRightChild == null) // 1-child logic (Only Left Child)
																			
			{
				T val = delNodeLeftChild.getValue();
				delNode.setLeft(null);
				delNode.setValue(val);
				isDeleted = true;
			}
			else if(delNode.getLeft() == null && delNode.getRight() != null) // 1-child logic (Only Right Child)
																				
			{
				T val = delNodeRightChild.getValue();
				delNode.setRight(null);
				delNode.setValue(val);
				isDeleted = true;
			}
			else if(delNode.getLeft() != null && delNode.getRight() != null) // 2-child Logic
			{
				if(delNodePosition==NodePosition.LEFT)
				{
					TreeNode<T> maxNode= maxNode(delNodeLeftChild);
					T val= maxNode.getValue();
					deleteNode(val);
					delNodeParentLeftChild.setValue(val);
				}
				else
					if(delNodePosition==NodePosition.RIGHT)
					{
						TreeNode<T> maxNode= maxNode(delNodeRightChild);
						T val= maxNode.getValue();
						deleteNode(val);
						delNodeparentRightChild.setValue(val);
					}
				
				isDeleted = true;
			}

		}

		return isDeleted;
	}
}
