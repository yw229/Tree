package Questions4;

public class inOrderTraverse {
	 public void inOrderPrint(TreeNode n)
	    {
	        if(n == null)
	        return  ;
	        inOrderPrint(n.left) ;
	        System.out.println(" " + n.data) ;
	        inOrderPrint(n.right) ;
	    }
	 public void PreOrder(TreeNode n)
	 {
		 if(n == null) return ;
		 System.out.println(" " + n.data) ;
		 PreOrder(n.left) ;
		 PreOrder(n.right) ;
	 }
	 public void PostOrder(TreeNode n)
	 {
		 if(n == null) return ;
		 PostOrder(n.left) ;
		 PostOrder(n.right) ;
		 System.out.println(" " + n.data) ;
		 
	 }
	    public static TreeNode addToTree(int low,int high, int[] array )
	    {
	        if(low>high) return null ;
	        int m = (low + high)/2 ;
	        TreeNode n = new TreeNode(array[m]) ;
	        n.setLeft(addToTree(low,m-1,array)) ;
	        n.setRight(addToTree(m+1,high, array)) ;
	        
	        return n ;
	    	/* if (low > high) return null ; 
	         int mid = (low+high)/2 ;
	         TreeNode root = new TreeNode(array[mid]) ;
	        // while( low < high)
	         
	              root.setLeft(  addToTree(low,mid-1,array) );
	              root.setRight( addToTree(mid+1, high,array) );
	         return root ;*/
	        
	    }
	  
	    public static void main(String[] args)
	    {
	        int[] array = {4,6,7,2,3,1,0} ;
	        TreeNode n = addToTree(0, array.length-1, array) ;
	        //TreeNode n = TreeNode.createMinBST(array) ;
	        inOrderTraverse in = new inOrderTraverse() ;
	        in.inOrderPrint(n) ;
	        System.out.println() ;
	        in.PreOrder(n) ;
	        System.out.println() ;
	        in.PostOrder(n) ;
	    }

}
