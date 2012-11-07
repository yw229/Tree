package Questions4;

public class SubTree {
	/*
	 * given a bigger tree and a smaller tree , 
	 * find out if small one is within that big tree*/
	 public static  boolean containsTree(TreeNode big, TreeNode small)
	    {
	        if (small == null) return true ; // if small tree is null, return true 
	        else return isSub(big,small) ; // call subtree 
	    }
	    public static boolean isSub(TreeNode r, TreeNode e) // r is bigger than e 
	    {
	        if(r==null) return false ; // bigger one is null, return false 
	        if (e.data == r.data) //  two tree root node value the same,check if tree rooted at r contains the 
	   		 // binary tree rooted at e as a subtree starting at r
	        {
	          return TreeMatch(e,r) ; 
	        }
	        return isSub(r.left,e)|| isSub(r.right,e) ; // two node
	           
	    }
	    
	    /* Checks if the binary tree rooted at a contains the 
		 * binary tree rooted at b as a subtree starting at a.
		 */
	    
	    public static boolean TreeMatch(TreeNode a, TreeNode b)  
	    {
	       if (a == null && b == null) return true ; //nothing left in the subtree
	       if ( (a!=null && b==null) ||(a==null &&b!=null))
	           return false ; 
	      // if ( (a.data == b.data) &&(a.left == b.left) && (a.right == b.right)) 
	       //        return true ;
	        if (a.data !=b.data) return false ; // data does not match 
	       return  TreeMatch(a.left,b.left)&& TreeMatch(a.right,b.right) ;
	    }   
	    
	    public static void main(String[] args)
	    {
	        int[] array = {3,6,7,8,10,3,4,2,4} ;
	        int[] a = {3,6,7,8} ;
	        TreeNode big = new TreeNode(6) ;
	        TreeNode small = new TreeNode(5) ;
	        for (int i = 0 ; i < array.length ; i ++)
	        {
	            big.insetInOrder(array[i]) ;
	        }
	        for(int i=0; i< a.length; i++)
	        {
	            small.insetInOrder(a[i]) ;
	        }
	        System.out.println("Tree small is subTree of tree big?" + containsTree(big,small) ) ;
	    }



}
