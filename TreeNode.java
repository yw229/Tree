package Questions4;

public class TreeNode {
	public TreeNode left ;
	public TreeNode right ;
	public TreeNode parent ;
	public int data ; 
	public int[] array ;
	
	public TreeNode (int d )
	{
		this.data = d ;
		
	}
	public TreeNode ()
	{
		
	}
	public void setLeftChild(TreeNode left)
	{
		this.left = left ;
		if (left !=null)
			left.parent = this ;
	}
	public void setRightChild (TreeNode right)
	{
		this.right = right ;
		if (right!=null)
			right.parent = this ;
	}
	public void insertOrder (int d)
	{
		if (d <= data)
		{
			if (left ==null)
				setLeftChild(new TreeNode (d)) ;
			else
				left.insertOrder (d) ;
		}
		else
		{
			if (right == null)
				setRightChild(new TreeNode(d)) ;
			else
				right.insertOrder(d) ;
		}
	}
	public boolean isBST()
	{
		if (left !=null)
		{
			if (data < left.data || !left.isBST())
				return false;
		}
		else
		{
			if ( data >= right.data || ! right.isBST())
				return false;
		}
		
		return true ;
	}
	public int height ()
	{
		int lefthight = left != null? left.height():null ;
		int righthight = right !=null? right.height():null;
		return 1 + Math.max(lefthight, righthight);
	}
	public TreeNode find (int d)
	{
		if (d == data)
			return this;
		if (d < data)
			return left !=null? left.find(d):null ;
		if (d > data)
			return right !=null? right.find(d):null ;
		return null ;
	}
	private static TreeNode addToTree (int array[],int start, int end)
	{
		if (end < start)
			return null ;
		int mid = (start+ end)/2 ;
		TreeNode n= new TreeNode (array[mid]) ;
		n.setLeftChild(addToTree(array,start,mid -1)) ; // recursive left child
		n.setRightChild(addToTree(array,mid+1,end)) ; // recursive right child
		return n ;
		
	}
	public static   TreeNode createMinBST (int array[])
	{
		return addToTree (array,0, array.length -1) ;
	}
}
