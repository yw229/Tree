package Questions4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class DepthLinkedList {
	public TreeNode root ;
	
	public DepthLinkedList(TreeNode root)
	{
		this.root = root ;
	}
	
	public  ArrayList<LinkedList<TreeNode>> DepthList(TreeNode root)
	{ 
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>> () ;
		int depth = 0 ;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>() ;
		list.add(root) ;
		result.add(depth,list) ; // depth = 0 , add root 
		while (true)
		{
			LinkedList<TreeNode> dList = new LinkedList<TreeNode>() ; 
			for ( int i = 0 ; i < result.get(depth).size() ; i ++ )
			{
				TreeNode n = result.get(depth).get(i) ;
				if ( n!=null)
				{
					if ( n.left !=null)
						dList.add(n.left) ;
					if ( n.right !=null)
						dList.add(n.right) ;
				}
			}
				if ( dList.size() > 0)
					result.add(depth+1, dList) ;
				else
					break ;
				depth ++ ;
		}
		return result ;
	}
		public void printResult ( ArrayList<LinkedList<TreeNode>> result )
		{
			int depth = 0 ;
			for (  LinkedList<TreeNode> entry :result)
			{
				Iterator<TreeNode> it = entry.listIterator() ;
				System.out.print("Linked List at depth" + depth + " ") ;
				while (it.hasNext())
				{
					System.out.println( " " + it.next().data ) ;
				}
				System.out.println() ;
				depth ++ ;
			}
		}
		public static void main (String[] args)
		{
			int ran = 10 ; 
			int[] array = new int[ran] ;
			Random r = new Random() ;
			System.out.println("The array is" ) ;
			
			for (int i= 0; i < array.length ; i ++)
			{
				array[i] = r.nextInt(10) ;
				System.out.print(" " + array[i]) ;
			}
		
			TreeNode tr = TreeNode.createMinBST(array) ;
			DepthLinkedList dl = new DepthLinkedList( tr) ;
			ArrayList<LinkedList<TreeNode>> ls = dl.DepthList(tr);
			dl.printResult( ls) ;
		}
		
}
