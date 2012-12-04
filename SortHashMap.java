package Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortHashMap {
    public String[] words ;
    public HashMap<String, Integer> wordMap ;
    public SortHashMap(String[] words)
    {
        this.words = words ;
        wordMap = new HashMap<String,Integer>() ;
    }
    public HashMap<String, Integer> getFreq()
    {
        for(String s : words)
        {
            Integer freq = wordMap.get(s);
            wordMap.put(s,freq == null ? 1 : freq+1) ;
            
        }
        return wordMap ;
    } 
    public HashMap< String,Integer> SortValueMap(HashMap<String,Integer> input)
    {
        HashMap<String, Integer> temp = new HashMap<String,Integer>() ;
        for(String s : input.keySet())
            temp.put(s, input.get(s));
        
        List<String> KeySet = new ArrayList<String>(temp.keySet()) ; // string key 
        List<Integer> ValueSet = new ArrayList<Integer>(temp.values()) ; // freqency 
        Collections.sort(KeySet) ;
        Collections.sort(ValueSet) ;
        HashMap<String,Integer> sortedMap = new LinkedHashMap<String,Integer>() ;
        
        /*TreeSet<Integer> sortedValueSet = new TreeSet<Integer>(ValueSet); // sorted freqency set 
        Object[] sortedArray = sortedValueSet.toArray() ;
        for(int i= 0 ; i < sortedArray.length ; i ++)
        {
            sortedMap.put(KeySet.get(ValueSet.indexOf(sortedArray[i])) , (Integer)sortedArray[i]) ;
        }*/
        Iterator<Integer> valueIt = ValueSet.iterator() ; 
        
        while(valueIt.hasNext())
        {
        	Object val = valueIt.next() ;
        	Iterator<String> keyIt = KeySet.iterator() ; 
        	
        	while(keyIt.hasNext())
        	{
        	Object key = keyIt.next() ;
        	String comp1 =temp.get(key).toString() ;
        	String comp2 = val.toString() ;
        	
        	if(comp1.equals(comp2))
        	{
        		temp.remove(key) ;
        		KeySet.remove(key) ;
        		sortedMap.put((String) key, (Integer) val) ;
        		break;
        	}
        	}
        }
         return sortedMap ;     
    }
    public void printMap()
    {
    	HashMap< String,Integer> sorted = new HashMap< String,Integer>() ;
    	sorted = SortValueMap(wordMap) ;
    	for(String st : sorted.keySet())
    	{
    		System.out.println(st + " " + sorted.get(st)) ;
    	}
    }
    public static void main(String[] args)
    {
    	String[] words= {"a","b" ,"d" ,"a","a","c" , "b"} ;
    	SortHashMap st = new SortHashMap(words) ;
    	HashMap<String, Integer> freq = new HashMap<String,Integer>() ;
    	freq = st.getFreq() ;
    	for(String s : freq.keySet())
    		System.out.println( "before " + s + freq.get(s)) ;
    	st.SortValueMap( freq ) ;
    	
    	st.printMap() ;
    }
}