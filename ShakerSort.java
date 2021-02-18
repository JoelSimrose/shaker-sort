//Joel Simrose
//Shaker Sort Algorithm
//December 3rd, 2018


import java.util.Random;
import java.util.*;
import java.lang.*;

public class ShakerSort
{
	/**
	*This is a method to sort an array with shaker sort.
	*@param n takes the array to be sorted
	*@return returns the sorted integer array
	*/
	public long shakerSort(int[] n)
	{

		long startTime = PrintTime();

		boolean switched = true;	//if there is a switch then keep using shaker sort
		int current;			
		int index = 0;
		int size = n.length;

		while(switched == true)
		{
			switched = false;
			
			for (int j=index; j < size - 1; j++) //go through array from start to end
			{

				current = j+1;

				if(n[j] > n[current])
				{
					int swap = n[j];
					n[j] = n[current];
					n[current] = swap;
					switched = true;
				}		
			}		
		}

		if(switched == false)
		{
			long endTime = PrintTime();			//get the finishing run time
			long runTime = endTime - startTime;		//get total running time for selection sort

			return runTime;
		
			//return n;//return array once sorted
		}

		switched = false;	//if array is not sorted then reset switched

		size = size - 1;	//decrement end 

		for(int i=size; i>=index; i--)	//go through array from end to start
		{
			if(n[i] > n[i+1])
			{
				int swap = n[i];
				n[i] = n[i + 1];
				n[i+1] = swap;
				switched = true;
			}
		}

		index = index + 1;	//increment start 

		return 0;

	}

	/**
	*This is a method to print out the specified array 
	*@param n takes the array to be printed
	*/
	public void printArray(int[] n)
	{

		for(int i=0; i<n.length; i++)
		{
			System.out.print(n[i] + ",");
		}

		System.out.println("\n");
	}

	/**
	*Creates a random array of the specified size
	*@param size the size of random array to make 
	*@return returns an integer array of random numbers between 1 and 100
	*/
	public static int[] RandomArrayGen(int size)
	{
		int[] randArray = new int[size];	//initialize array

		for(int i=0; i<size; i++)	
		{
			
			Random number = new Random();		//get a random number and add it to the array
			randArray[i] = number.nextInt(100); 
		
		}

		return randArray;

	}

	/**
	*This is a method to return the current time in milliseconds
	*/
	public static long PrintTime()
	{
		return System.currentTimeMillis();		//return current time 
	}



	public static void main(String[] args)
	{
		ShakerSort ss = new ShakerSort();

		int size = 192000;
		int[] n = RandomArrayGen(size);

		//System.out.print("Unsorted Array: ");
		//ss.printArray(n);
		long runTime = ss.shakerSort(n);

		System.out.println("Data Size: " + size);
		System.out.println("Runtime is: " + runTime);
		//System.out.print("Sorted Array: ");
		//ss.printArray(n);
	}
}
