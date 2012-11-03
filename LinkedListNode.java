package Questions2;
//import LibPackage.AssortedMethod;

public class LinkedListNode {

    public LinkedListNode prev ;
    public LinkedListNode next ;
    public int data ;
    
    public LinkedListNode(LinkedListNode p, LinkedListNode n, int data)
    {
        this.data = data ;
        setNext(n) ;
        setPrev(p) ;
    }
    
    public void setNext(LinkedListNode n)
    {
        this.next = n ;
        if (n!=null && n.prev!=this)
           n.prev = this ;
    }
    public void setPrev(LinkedListNode p)
    {
        this.prev = p ;
        if (p!=null && p.next!=this)
            p.next = this;
    }
    public String printForward()
    {
        if(next!=null)
        {
            return " " + data + "->"+next.printForward() ;
        }
        else
            return ((Integer)data).toString() ;
		
    }
    
    public static LinkedListNode createLinkedListNode(int N)
    {
        int init = (int)(Math.random()*N) ;
        LinkedListNode node = new LinkedListNode(null,null,init) ;
       
        LinkedListNode prev = node ;
        for (int i = 0 ; i< N; i++)
        {
            int d = (int)(Math.random()*N) ;
            LinkedListNode next = new LinkedListNode(null,null,d) ;
            prev.setNext(next) ;
            prev = next;
                        
        }
        return node ;
         
    }
}
