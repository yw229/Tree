package Questions4;

import java.util.HashMap;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ReconstructTreeInPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer,Integer> inMap = new HashMap<Integer,Integer>() ;
        for(int i =0 ; i < inorder.length; i++)
        {
            inMap.put(inorder[i],i) ;
        }
        return build(inMap,preorder,0,preorder.length-1,inorder,0,inorder.length-1) ;
       } 
   public TreeNode build(HashMap<Integer,Integer> inMap,int[] preorder,int pres,int pren,int[] inorder,int ins,int ine)
         {
            if( pres>pren || ins> ine)
                return null ;
            
            TreeNode root = new TreeNode(preorder[pres]) ; // preorder first is root 
            int i = inMap.get( preorder[pres] ) ; // find root value index in inorder array 
            root.left = build(inMap, preorder,pres+1,pres+i-ins,inorder,ins,i-1 ) ; //
            root.right = build(inMap, preorder,pres+1+i-ins,pren,inorder,i+1,ine) ;
            return root ;
            
         }
    
    }
    
   