package algos.tree;

public class SearchResult
{
	private TreeNode parent;
	private TreeNode target;
	private boolean isFound;
	
	public TreeNode getParent()
	{
		return parent;
	}
	public void setParent(TreeNode parent)
	{
		this.parent = parent;
	}
	public TreeNode getTarget()
	{
		return target;
	}
	public void setTarget(TreeNode target)
	{
		this.target = target;
	}
	public boolean isFound()
	{
		return isFound;
	}
	public void setFound(boolean isFound)
	{
		this.isFound = isFound;
	}
	
	
}
