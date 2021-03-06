package com.bridgelabz.designpattern.creational.factory;

import com.bridgelabz.util.Utility;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:20/12/2019
 * @version 1.0
 * Purpose:Controller For Factory Design Pattern Program
 **********************************************************************************************************/

public class Controller {
	public static void main(String[] args) {
		System.out.println("Enter System Type");
		String type=Utility.InputString();
		System.out.println("Enter Processor speed");
		String cpu=Utility.InputString();
		System.out.println("Enter Ram");
		String ram=Utility.InputString();
		System.out.println("Enter Graphics");
		String graphics=Utility.InputString();
		System.out.println("Enter HardDisk");
		String hdd=Utility.InputString();
		Computer pc=ComputerFactory.getInstance(type, ram, cpu, hdd, graphics);
		Computer server=ComputerFactory.getInstance(type, ram, cpu, hdd, graphics);
		
		if("PC".equalsIgnoreCase(type))
		System.out.println(type+" Specifications Are: "+pc);
		else if("server".equalsIgnoreCase(type))
		System.out.println(type+" Specifications Are: "+server);
		else
			System.out.println(type+" Not Available ");
		
	}
}
