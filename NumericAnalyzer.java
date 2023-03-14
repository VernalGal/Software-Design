package edu.cuny.csi.csc330.lab2;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;


class NumericAnalyzer 
{
	
	int count;
	int min;
	int max;
	int range;
	int sum;
	int mean;
	double variance;
	double standard_deviation;
	int array[];
	

	/*public static int search_digit(String s)
    {
  
        // Function to check if is digit
        // is found or not
        for (int i = 0; i < s.length(); i++) 
        {
            if (Character.isDigit(s.charAt(i))== true) 
            {
                // return position of digit
                return i+1;
            }
        }
        // return 0 if digit is present
        return 0;
    }
	
   */
    
    public static void main(String[] args)
    {
    	
    	if(args.length == 0)
    	{
    		System.err.println("There has to be at least 1 argument, will exit early");
    		System.exit(1);
    	}
    	
    	int []array = new int[args.length];
    	for (int i = 0; i<args.length; ++i)
    	{
    		array[i]=Integer.parseInt(args[i]);
    	}
    	
    	//String[]arrays = {"1245a", "QWERTY"};
    	//int index = 0;
    	//for (String x : arrays) 
    	//{
        //    index = search_digit(x);
        //    if (index != 0) 
        //    {
        //        System.out.println("Digit found at : "+ (index)+ "th position.");
        //    }
        //    else 
        //    {
        //        System.out.println("Digit not present.");
        //     }
        // }
    	
        int[] arr = {27};
        System.out.println("The original array is: ");
        for (int num : arr) 
        {
            System.out.print(num + " ");
        }
        Arrays.sort(arr);
        System.out.println("\nThe sorted array is: ");
        for (int num : arr) 
        {
            System.out.print(num + " ");
        }
        
    	System.out.printf("\nSum:");
    	sum(arr);
    	
    	System.out.printf("\nCount:");
    	count(arr);
        
    	System.out.printf("\nMean:");
    	mean(arr);
    	
    	System.out.printf("\nMedian:");
    	median(arr);
    	
    	System.out.printf("\nMin:");
    	min(arr);
    	
    	System.out.printf("\nMax:");
    	max(arr);
    	
    	System.out.printf("\nMin:");
    	min(arr);
    	
    	System.out.printf("\nRange:");
    	range(arr);
    	
    	System.out.printf("\nVariance:");
    	variance(arr);
    	
    	System.out.printf("\nStandard Deviation:");
    	standard_deviation(arr);
    	
    	
    }
    
    


	public static void count(int []arr)
    {
    	System.out.print(arr.length);
    	
    }
    
    
    
    public static void sum(int []arr)
    {
    	int sum = 0;
    	for(int i = 0; i < arr.length; i++)
    	{
    		sum += arr[i];
    	}
    	System.out.print(sum);
    }
    
   public static void mean(int [] arr)
   {
	   int sum = 0;
	   for(int i = 0; i < arr.length; i++)
	   {
		   sum += arr[i];
	   }
	   
	   int count = arr.length;
	   
	   double mean = sum / count;
	   System.out.print(mean);
   }
   
   
   public static void median(int [] arr)
   {
	   int median = 0;
	   int count = arr.length;
	   if(count % 2 != 0)
		   median = arr[count/2];
	   else
		   median = (arr[count/2]+arr[(count/2)+1])/2;
	   System.out.print(median);
   }
   
   
   public static void min(int [] arr)
   {
	 System.out.print(arr[0]);
   }
   
   
   
   public static void max(int [] arr)
   {
	   int count = arr.length;
	   System.out.print(arr[count - 1]);
   }
   
   public static void range(int [] arr)
   {
	   int count = arr.length;
	   int max = arr[count - 1];
	   int min = arr[0];
	   
	   int range = max - min;
	   System.out.print(range);

   }
   
   
   public static void variance(int [] arr)
   {
	   int count = arr.length;
	   double sum = 0;
	   for(int i = 0; i < count; i++)
		   sum += arr[i];
	   double mean = sum / count;
	   
	   double square_diff = 0;
	   for(int i = 0; i < count; i++)
		   square_diff += (arr[i] - mean) * (arr[i]- mean);
	   
	   double variance = square_diff / (count);
	   System.out.print(variance);
   }
   
   public static void standard_deviation(int[] arr)
   {
	   int count = arr.length;
	   double sum = 0;
	   for(int i = 0; i < count; i++)
		   sum += arr[i];
	   double mean = sum / count;
	   
	   double square_diff = 0;
	   for(int i = 0; i < count; i++)
		   square_diff += (arr[i] - mean) * (arr[i]- mean);
	   
	   double variance = square_diff / (count);
	  
	   
	   double standard_deviation = Math.sqrt(variance);
	   
	   System.out.print(standard_deviation);
   }
   
     
}
   

	
	
	
	
	
	
	
	

