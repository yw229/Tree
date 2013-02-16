package Questions4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class KthLargestBST {
	/*Find the kth largest element in the collection 
	 * 
	 * Idea: keep track at each node size(how many nodes counting it and its descendant  )
	 * Take advantage of the BST in order traversal feature-start leftmost node which is the smallest value 
	 *  using the counter to keep the Kth smallest node, if counter of the node is find on the left sub tree than return the node;
	 *   if K> than the left sub tree size, recursively traverse on the right sub stree till counter == K 
	 *  then the result is on the right
	 *  . We only make the traverse start from the right most node to find the K largest and apply the above rules 
	 * */
	public static int count =0;
	 public static void findK(TreeNode t,int K  )
	    {
		 	
		  if (t == null) return ;

		 // TreeNode nd ;
		   findK( t.right, K);
		  //if ( K == count ) return nd;

		  count++;
		  if (K == count)
			  {
			  System.out.println(t.data) ;
			  //return nd; 
			  }

		  	findK(t.left, K);
		  //return (count == K)? nd : null;
	      
	    }
	/*
	 * 
	 *non-recursive in order traversal but start from right most 
	 */
	 public static TreeNode KLargestNonRecursive(TreeNode t, int K)
	 {
		 Stack<TreeNode> s = new Stack<TreeNode>() ;
		 TreeNode current = t ;
		 int count = 0 ;
		 while(!s.isEmpty() || current !=null)
		 {
			 if(current!=null)
			 {
				 s.push(current) ;
				 current =current.right ;
			 }
			 else
			 {
				 current = s.pop() ;
				 count ++ ;
				 if(count == K)
					 return current ;
				 current = current.left ;
			 }
				 
		 }
		 return null ;
		 
	 }
	 /*
	  ** count the duplicates node in tree 
	  */
	 public static int count(TreeNode t)
	 {
		 Stack<TreeNode> s = new Stack<TreeNode>() ;
		 TreeNode current = t ;
		 int count = 0 ;
		 ArrayList<Integer> result = new ArrayList<Integer>() ;
		 HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;
		 int i = 0 ;
		 while(!s.isEmpty() || current !=null)
		 {
			 if(current!=null)
			 {
				 s.push(current) ;
				 current =current.left ;
			 }
			 else
			 {
				 current = s.pop() ;
				 result.add(i,current.data) ;
				 // only adjacent nodes could be possibly equal with another
				 if( (i==1 && result.get(i) == result.get(i-1)) ||
						 (i>1 &&  result.get(i) == result.get(i-1) && result.get(i-2) != result.get(i)))
				 {
					 count = count + 1 ;
					 System.out.println(i) ;
				 }
				 i++ ;
				 current = current.right ;
				 
			 }
				 
		 }
		 return count ;
		 
	 }
	  public static TreeNode createBST(int array[], int low, int high)
	    {
	        if(low > high) return null  ;
	        int mid = (low + high)/2 ;
	        TreeNode n = new TreeNode( array[mid] ) ;
	        n.setLeft(createBST(array,low,mid-1));
	        n.setRight(createBST(array,mid+1,high)) ;
			return n;
	        
	        
	    }
	  public static void main (String[] args)
	    {
	    	//Random ran = new Random() ;
	         int array[] = {2,2,2,2,3,3,4,5,6,6,8,8,8,8,8,9} ;
	         
	     
	    	 
	    	
	       // TreeNode t = TreeNode.createMinBST(array) ;
	         TreeNode t = createBST(array, 0, array.length-1) ;
	        //KthLargestInTree kt = new KthLargestInTree(4,t) ;
	        // System.out.println( " " + findK(t,4) ) ;
	        System.out.println( " " + KLargestNonRecursive(t,3).data  + count(t)) ;
	        // findK(t,7) ;
	    }


}
