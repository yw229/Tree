package Question4;

public class isSymmetricTree
{
    public static boolean isSymTree (Tree r)
    {
        if(r == null) return false ;
        if (r.left ==null && r.right == null) return true ;
        
        if (r.left ==null && r.right == null) return true ;
            return isSysm(r.left,r.right) ; // root all left side is mirror of it's right side ?
                
       
    }
    public static boolean isSysm(Tree l, Tree r)
    {
        if (l == null && r == null )
            return true ;
        if ( (l == null && r!= null) || (l!=null && r==null))
        	return false ;
        return ( l.data == r.data && isSysm(l.left, r.right) && isSysm(l.right ,r.left)) ;
    } // recursive to find it's children are mirror of themselfs 
    
    public static void main (String[] args)
    {
        //int[] array = {2,3,4,,1} ;
        
        //Random ran = new Random()
        
        Tree t = new Tree(5) ;
         t.setLeft( new Tree(4)) ;
         t.setRight(new Tree(4)) ;
         t.left.setLeft(new Tree(3)) ;
         t.right.setRight(new Tree(3));
      /*  for (int i = 0 ; i < array.length ; i ++ )
        {
            t.insertInOrder(array[i]) ;
        }
        */
        System.out.println("tree t is mirror to itself ? " + isSymTree(t) ) ;
    }
}