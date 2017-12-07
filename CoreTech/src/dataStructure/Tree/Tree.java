package dataStructure.Tree;

public interface Tree
{
	boolean addNode(int e);
	boolean removeNode(int e);
	int getDepth(int n);
	int getSize(int u);
	int getHeight(int u);
}
