package Questions4;

public class LCABST {
	 public TreeNode findLCABST(TreeNode root , TreeNode p , TreeNode q)
     {
         if(root == null || p == null || q== null ) return null ;
         if( Math.max(p.data,q.data) < root.data) // p,q are on the left subtree 
        	 return findLCABST(root.left , p,q) ;
         if(Math.min(p.data,q.data) > root.data) // p,q both on right substree
        	 return findLCABST(root.right, p, q) ;
         return root ; // one on left, one on right               
             
     }
	 public static void main(String[] args)
	 {
		 int[] array = {2,3,4,5,6,7,8,9,10} ;
		 TreeNode t = TreeNode.createMinBST(array) ;
		 TreeNode p = new TreeNode(4) ;
		 TreeNode q = new TreeNode(2) ;
		 LCABST l = new LCABST() ;
		 TreeNode m = l.findLCABST(t, p, q) ;
		 System.out.println(m.data) ;
	 }


}
