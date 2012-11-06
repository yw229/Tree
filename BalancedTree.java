package Questions4;

import java.util.Random;

import Lib.AssortedMethod;

public class BalancedTree {
	//public int[] array ;
	public TreeNode t ;
	
	public BalancedTree ( TreeNode t)
	{
		//this.array  = array ; 
		this.t = t ;
	}
	public int MinHeight(TreeNode t)
	{
		//this.t = t ;
		if (t==null) return 0 ;
		return 1 + Math.min(MinHeight(t.left),MinHeight(t.right)) ;
	}
	public int MaxHeight(TreeNode t)
	{
		//this.t = t;
		if (t==null) return 0 ;
		return 1 + Math.max(MaxHeight(t.left), MaxHeight(t.right)) ;
	}

	public boolean isBalancedTree (TreeNode t)
	{
		//this.t =t ;
		return (MaxHeight(t) - MinHeight(t) <= 1) ; 
		
	}
	public boolean isBalancedTree ()
	{
		return isBalancedTree(this.t) ;
	}

	public static void main (String[] args)
	{
		int n = 10 ;
		int array[] = new int[n] ;
		Random ran = new Random();
		System.out.println("Array is :") ; 
		for (int i = 0 ; i < array.length ; i ++)
		{
			array[i] = ran.nextInt(n) ;
			System.out.print(" " + array[i]) ;
			
		}
		
		TreeNode t = TreeNode.createMinBST(array) ;
		BalancedTree bt = new BalancedTree(t) ;
		System.out.println(" T? " + t.data);
		System.out.println("T? left  " + t.left.data);
		System.out.println("T? right  " + t.right.data);
		System.out.println("Is balanced? " + bt.isBalancedTree() );
		
	
	
	
		TreeNode unt = new TreeNode(10) ;
		
		System.out.println("Random Array is :") ;
		for (int i = 0 ; i < 10 ; i ++)
		{
			int rand = AssortedMethod.randomIntInRange(0, 50) ;
			unt.insertOrder(rand);
			System.out.print(" "+ rand) ;
		
		}
		BalancedTree btb = new BalancedTree(unt) ;
		System.out.println("Root? " + unt.data);
		System.out.println("Root? left  " + unt.left.data);
		System.out.println("Root? right  " + unt.right.data);
		System.out.println("Is balanced? " + btb.isBalancedTree() );
	}
}
