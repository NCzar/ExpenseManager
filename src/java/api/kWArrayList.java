/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author nikhilv85
 */
public class kWArrayList
// Insert solution to programming exercise 1, section 9, chapter 2 here
{
    // Data Fields

    /** The default initial capacity */
    private static final int INITIAL_CAPACITY = 10;
    /** The underlying data array */
   
    
    String[] array1; 
    
   
    /** The current size */
    private int size = 1;
    /** The current capacity */
    private int capacity = 0;

    /**
     * Construct an empty KWArrayList with the default
     * initial capacity
     */
    public kWArrayList() {
        capacity = INITIAL_CAPACITY;
        
     //   Data3=(E[]) new Object[2];
     //   removeandadd(Data3);
     //   Data4=(E[]) new Object[5];
     //   removeandadd(Data4);
    }
    
   public static void main(String[] args){
         String[] theData = new String[] {"a"};
   
        String[] theData2 = new String[] {"a", "b","c"};
        
        String[]  theData3={"a","b","c","d","e"};
        kWArrayList k=new kWArrayList();
        k.removeandadd(theData);
        k.removeandadd(theData2);
        k.removeandadd(theData3);
    }
    public String[] removeandadd(String[] Data1) {
       
        size=Data1.length;
        String[] returnValue = null;
       
        String bufferdata=Data1[size-1];
        
        for (int i = 0; i < size-1; i++) {
         //   System.out.println(Data1[i]);
            }
        
                    System.out.println("\n");

        if(size==1){
            returnValue=Data1;
        }
        else{
            for (int i = 0; i < size-1; i++) {
            Data1[i+1] = Data1[i];
            }
        Data1[0]=bufferdata;
        }
         for (int i = 0; i < size-1; i++) {
          //  System.out.println(Data1[i]);
            }
         
        returnValue=Data1;
      System.out.println(Data1[0]);
        return returnValue;
    }

    
    }
