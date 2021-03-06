package com.bridgelabz.junit;
import com.bridgelabz.util.Utility;

/************************************************************************************
 * @author Rupeshp007
 * date:28/11/2019
 * Purpos:Computes the square root of a nonnegative number c using
 *  Newton's method
 **********************************************************************************/

public class SquareRuteNewtonMethod {

	 public static void main(String[] args) {

		 double d=0.0;  
		 double c = Utility.InputDouble();
	       
		 if(c>0)
		 {
			 d=Utility.SqurerootNewtonMethod(c);
		 }
	       else
	       {
	       System.out.println("Number cannot be negative");
	       }
	       System.out.println(d);
	    }
	
}
