package Question4;

import java.util.ArrayList;

public class BSTArray {
	 	/*public ArrayList<Integer> aleft ;
	    public ArrayList<Integer> aright ;
	    public ArrayList<Integer> bleft ;
	    public ArrayList<Integer> bright ;*/
	    public Integer[] a ;
	    public Integer[] b ;
	    
	    public BSTArray(Integer[] a, Integer[] b)
	    {
	        this.a =a ;
	        this.b = b ;
	        
	    }  
	    
	    public boolean isSameBST(Integer a[] ,Integer b[])
	    {
	    	if (a == null || a.length < 1 || b == null || b.length < 1)
	    		return false;
	        if(a[0] !=b[0]) return false;
	        if(a.length != b.length) return false ;
	        if(a.length ==1) return true ;
	        
	        ArrayList<Integer> aleft =new ArrayList<Integer> () ;
	        ArrayList<Integer> aright = new ArrayList<Integer>() ;
	        ArrayList<Integer>  bleft =  new ArrayList<Integer>() ;
	        ArrayList<Integer> bright = new ArrayList<Integer>() ;
	        for (int i : a) {
	    		if (i < a[0])
	    		aleft.add(i);
	    		else if(i>a[0])
	    		aright.add(i);
	    		// left array and right array BST
	    		}

	    		for (int j : b) {
	    		if (j < b[0])
	    		bleft.add(j);
	    		else if(j>b[0])
	    		bright.add(j);
	    		// 
	    		}
	    		return isSameBST(aleft.toArray(new Integer[] {}),
	    	    		bleft.toArray(new Integer[] {}))
	    	    		&& isSameBST(aright.toArray(new Integer[] {}),
	    	    		bright.toArray(new Integer[] {})); //recursively put left and right
	    
	    }  
	    public int[] ToArray(ArrayList<Integer> list)
	    {
	        int[] arr = new int[list.size()] ;
	        for(int i = 0 ; i< list.size();i++)
	        {
	            arr[i] = list.get(i) ;
	        }
	        return arr ;
	    }
	    public boolean isSameBST()
	    {
	    	return isSameBST(this.a,this.b) ;
	    }
	    public static void main(String[] args)
	    {
	    	Integer[] a = {5,4,7,2,3,6,8} ;
	    	Integer[] b = {5,7,4,6,8,2,3} ;
	    	BSTArray bs = new BSTArray(a,b) ;
	    	System.out.println(bs.isSameBST(a, b)) ;
	    	
	    	
	    }

}
