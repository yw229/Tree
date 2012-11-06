package Questions4;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
	public int[] array;
	public int k ;
	public int location ;
	
	public  BinarySearch ( int array[],int k)
	{
		this.array = array ;
		this.k = k ;
		//location = -1;
	}
	public int location ()
	{
		int s = 0 , 
		e = array.length -1 ;
		location = -1 ;
		
		while ( s < e)
		{
			int mid = (s+e) /2 ;
			if ( array[mid] == k)
			{
				location = mid ;
				return location ;
			}
			else
				if ( k < array[mid])
					e = mid -1;
			else
				if  (k > array[mid])
					s = mid + 1;
		}	
		//return -1 ;
		return -1;
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
		Arrays.sort(array) ;
		System.out.println(" New Array is") ;
		for ( int i = 0 ; i < array.length ; i ++)
		{
			System.out.print(" " + array[i]) ;
		}
		BinarySearch bs = new BinarySearch(array,7);
		
		System.out.println(" Find  key " + 7 +" location "+ bs.location()) ;
	}

}
