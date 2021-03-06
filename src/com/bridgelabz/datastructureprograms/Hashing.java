package com.bridgelabz.datastructureprograms;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.bridgelabz.util.HashingFunction;
import com.bridgelabz.util.Utility;
/**
 * @author Rupeshp007
 * date:30/11/2019
 * Purpos:To create hashing table to data based on hashcode using singly linkedlist.
 * suppose we want to store data 26.
 * 26%11=4 it will store data on 4th location
 * 44%11=4 its aslo store on 4th location
 * 22%11=2
 * 33%11=3
 * so finally
 * 				(2)->22
 * 				(3)->33
 * 				(4)->44,26
 **********************************************************************************/

public class Hashing 
{
	static int size;
	static HashingFunction hashing=new HashingFunction();
	
	static String filename="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/datastructureprograms/OrderList.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		int[] list=OrderedList.ReadFile(filename);
		
		for(int index:list)
		{
			hashing.put(index);
		}
		
		System.out.println("Enter the Number you want to search");
		int search=Utility.InputInt();
		SearchElement(search);
	}
	
	/** it will Search the element in LinkedList on given location.
	 * @param int value
	 * @return void  
	 * **/	
	public static void SearchElement(int element)
	{
		boolean result=hashing.search(element);
		if(result)
		{
			System.out.println(element+"Element is found and removed successfully");
			hashing.removeElement(element);
		}
		else
		{
			System.out.println("Element not found and added to file");
			Utility.WriteinFile(element, filename);
		}
	}
}
