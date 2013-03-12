package LinkedIn;

public class PrefixTree {
	public TrieNode root  ;
	//public String word ;
	public PrefixTree()
	{
		root = new TrieNode('\0',false) ;
	}
	 public void insert(String word)
	    {
	        char[] letters = word.toCharArray() ;
	        TrieNode current = root ;
	        for(int i = 0 ; i < word.length() ; i ++)
	        {
	            if( current.number[ word.charAt(i) - 'a'] == null)
	                current.number[ word.charAt(i) - 'a'] = 
	                	new TrieNode(letters[i], i == word.length() -1 ? true :false) ;
	           current = current.number[word.charAt(i) -'a'] ;  
	        }
	        
	    }
	  public boolean search(String word)
      {
		  char[] letter = word.toCharArray() ;
		  TrieNode current = root ;
		  int i ;
          for(i = 0 ; i < word.length() ; i ++)
          {
              if( current == null) 
                  return false;
               current = current.number[letter[i] - 'a'] ;
              
          }
          if(i == word.length() -1 && current == null) return false ;
          if(current !=null && !current.fullword) return false ;
          return true ;
      }
	  public void printTree(TrieNode root,  int level, char[] branch)
	  {
		  if(root == null ) return ;
		  for(int i = 0 ; i < root.number.length ; i ++)
		  {
			  branch[level] = root.letter ;
			  printTree(root.number[i],level+1 , branch) ;
		  }
		  if(root.fullword)
		  {
			  for(int j = 0 ; j<=level ; j ++)
			  {
				  System.out.print(branch[j]) ;
				  System.out.println(); 
			  }
		  }
	  }
		 public static void main (String[] args)
		 {
			 PrefixTree pt = new PrefixTree() ;
			 String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
			 for(String word : words)
			 {
				 pt.insert(word) ;
			 }
			 char[] branch = new char[50] ;
			 pt.printTree(pt.root,0, branch) ;
			 String searchWord = "linked" ;
			 if(pt.search(searchWord))
				 System.out.println("The word is find") ;
			 else
				 System.out.println("The word is not found") ;
		 }
	  }




