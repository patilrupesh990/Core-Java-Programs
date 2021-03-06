package com.bridgelabz.datastructureprograms;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.LinkedListiml;
import com.bridgelabz.util.Utility;
 /*************************************************************************************
  * purpose: Read a List of Numbers from a file and arrange it ascending Order in a
  * Linked List. Take user input for a number, if found then pop the number out of the
  * list else insert the number in appropriate position.
  * @author Rupeshp007
  * date:23/11/2019
  * @version 1.0
*****************************************************************************************/
public class OrderedList 
{
	static LinkedListiml<Integer> list=new LinkedListiml<Integer>();
	static String filename="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/datastructureprograms/OrderList.txt";

	public static <T> void main(String[] args) throws FileNotFoundException, IOException 
	{
				
		 int numbers[]=OrderedList.ReadFile(filename);
		 
		 Arrays.sort(numbers);
		 list=DataStructure.add2List2(numbers, list);
		 
		 list.Display();
		 System.out.println();
		 System.out.println("Enter The Number you want to search");
		 int number=Utility.InputInt();
		 
		 OrderedList.SearchWord(number, list);
	}
	
	/*****************************************************************************
	 * Porpose:to find read Numbers from (,) separated lines from TextFile       *
	 * @param names FileName                                                     *
	 * @param key String                                                         *
	 * @return int[] array of Numbers                                            
	 * @throws IOException *
	 *****************************************************************************/	
	
	public static int[] ReadFile(String FileName)
	{
		File file;
		file=new File(FileName);
		FileReader filereader=null;
		BufferedReader buffer_reader;
		String temp= "";
		String line="";
		
			try {
				filereader = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffer_reader=new BufferedReader(filereader);
	
		try {
			while((temp=buffer_reader.readLine())!=null)
			{
				line+=temp;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] temp2= line.split(",");
		int words[]=new int[temp2.length];
		 int i=0;
		 for(String s:temp2)
		 {
			 words[i++]=Integer.parseInt(s);
		 }
		//List word=new List();
		try {
			buffer_reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words;
	}
	
	

	public static <T>void SearchWord(T word, LinkedListiml<T> list) throws FileNotFoundException 
	{
		if(!list.searchNode((T) word))
		{
			
			list.add((T) word);
		
			int elements[]=list.GetListElements();
				System.out.println(word+" Not Present in list and now added to list");
				Arrays.sort(elements);
				Utility.clearFile(filename);
				for(int data:elements)
				{
					Utility.WriteAppendinFile(data,filename);
				}
		}
		else
		{
			list.removeNode((T) word);
			System.out.println(word+" it was alrady in lIST and Removed from List");
			int elements[]=list.GetListElements();
			System.out.println(word+" Not Present in list and now added to list");
			Arrays.sort(elements);
			Utility.clearFile(filename);
			for(int count=0;count<elements.length;count++)
			{
				if(elements[count]!=0)
				Utility.WriteAppendinFile(elements[count],filename);
			}
		}
		list.Display();
	}
	
}
