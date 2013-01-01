package Questions4;

import java.util.Random;

public class LCA {
	 public int heightH(TreeNode p)
	    {
	        
	       /* if(p== null) return 0;
	        if(p.parent==null) return 1 ;
	         return 1+heightH(p.parent) ;*/
		 int height = 0 ; 
		 while(p!=null)
		 {
			 p=p.parent ;
			 height ++ ;
		 }
		 return height ;
	       // return  0 ;
	    }
	 public TreeNode FindLAC(TreeNode a , TreeNode b)
	 {
		 int ha = heightH(a) ;
		 int hb = heightH(b) ;
		 if(ha >hb) // assume b is deeper than a 
		 {
			 swap(ha,hb) ;
			 swapNode(a,b) ;
		 }
		 int diff = hb - ha ; // find difference 
		 /*
		  * The node which is closer to root is always diff ahead of the deeper node */
		int diff = hb-ha ; 
       		 if(diff > 0) // b is deeper than a 
        	{  
        		for(int i = 0 ; i < diff ; i ++)
           			 b = b.parent ; // b reach a level
        	}
        	else
       		 {
        		diff = ha-hb ;
        		for(int i = 0 ; i < diff ; i ++)
                		a = a.parent ; // a reach b level
        	}
            
		 while(true)
		 {
			 if( a==b) return a ; // find the common root 
			 a = a.parent ;
			 b = b.parent ;
		 }
		 
			
	 }
	/* 
	private void swapNode(TreeNode a, TreeNode b) {
		// TODO Auto-generated method stub
		int temp = a.data ;
		a.data =b.data ;
		b.data=temp;
		
	}
	private void swap(int ha, int hb) {
		// TODO Auto-generated method stub
		int temp = ha ;
		ha = hb ;
		hb =temp ;
	}*/
	public static void main(String[] args)
    {
        Random ran = new Random() ;
        int array[] = new int[10] ;
        for (int i=0 ; i < array.length ; i++)
        {
            array[i] = ran.nextInt(10) ;
            System.out.print(" " + array[i]) ;
        }
        TreeNode t = TreeNode.createMinBST(array) ;
        TreeNode a = t.left.right ;
        TreeNode b = t.left.left ;
        System.out.println(" TreeRoot" + t.data) ;
        LCA lca= new LCA() ;
        TreeNode la = lca.FindLAC(a, b) ;
        System.out.println(" The first common of ; ancesotr of node a:" + a.data + "b:"+ b.data +
        		"Common" + la.data) ;
    }
}
