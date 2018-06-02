package problem.opentext;

import java.util.HashMap;
import java.util.Map;

public class TestClassKrypC
{
	public static void main(String[] args)
	{
		String word = "ab";
		String searchWord = "a";
		String prefix = "a";
		
		Trie obj = new Trie();
		obj.insert(word);
		boolean param_2 = obj.search(searchWord);
		boolean param_3 = obj.startsWith(prefix);
		
		System.out.println(param_2+" "+param_3);
	}
}

class Trie
{

	TrieNode root = null;

	/** Initialize your data structure here. */
	public Trie()
	{
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word)
	{

		TrieNode currNode = this.root;

		char[] arr = word.toCharArray();

		for (char c : arr)
		{
			if(currNode.children.containsKey(c))
			{
				currNode = currNode.children.get(c);
			}
			else
			{
				currNode.children.put(c, new TrieNode());
				currNode = currNode.children.get(c);
			}
		}
		
		currNode.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word)
	{
		boolean retVal = true;

		TrieNode currNode = this.root;

		char[] arr = word.toCharArray();

		for (char c : arr)
		{
			if(currNode.children.containsKey(c))
			{
				currNode = currNode.children.get(c);
			}
			else
			{
				retVal = false;
				break;
			}
		}

		if(currNode.isWord==true)
			retVal = true;
		
		return retVal;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix)
	{
		boolean retVal = search(prefix);

		return retVal;
	}
}

class TrieNode
{
	public Map<Character, TrieNode> children = new HashMap<>();
	public boolean isWord = false;

	// you might need some extra values according to different cases
};

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
