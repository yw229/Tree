package LinkedIn;

public class TrieNode {
	 public TrieNode[] number ;
	 char letter;
	 boolean fullword ;
	   // public int value ;
	    public TrieNode(char letter, boolean fullword)
	    {
	        //value = -1 ;
	        number = new TrieNode[26] ; // construct the trie node ,26 branches 
	        this.letter = letter ;
	        this.fullword = fullword ;
	    }
		


}
