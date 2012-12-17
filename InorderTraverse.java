package Question4;

import java.util.Stack;

public class InorderTraverse
{
    public Tree root ;
    private Stack<Tree> s ;
    public InorderTraverse(Tree root)
    {
        this.root = root ;
        s = new Stack<Tree>() ;
        
    }
    public void inorderT()
    { // the last traversed node must not have right child 
        Tree current = root ;
        while(current!=null ||!s.isEmpty())
        {
            if(current!=null)
            {
                s.push(current) ; // push current to stack and traverse left node
                current = current.left ; // push left till the left leaf of tree
            }
            else
            { 
            current = s.peek() ;
            System.out.print(" " + current.data) ;
            s.pop() ; // pop the left most tree node 
            
            current = current.right ;  // 
            }
            
        }
    }
    public static Tree addToTree(int[] array, int low, int high)
    {
    	if(low>high) return null ;
        int m = (low + high)/2 ;
        Tree n = new Tree(array[m]) ;
        n.setLeft(addToTree(array,low,m-1)) ;
        n.setRight(addToTree(array, m+1,high)) ;
        
        return n ;
    	
    }
    public static void main(String[] args)
    {
    	int[] array = {2,3,4,5,6,7,8,9,11,12,14} ;
        Tree n = addToTree(  array,0,array.length-1) ;
        InorderTraverse is = new InorderTraverse(n) ;
        is.inorderT() ;
    }
    
}