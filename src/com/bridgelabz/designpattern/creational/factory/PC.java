package com.bridgelabz.designpattern.creational.factory;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:20/12/2019
 * @version 1.0
 * Purpose:Contains PC implementation extends Computer abstract class
 **********************************************************************************************************/

public class PC extends Computer
{
	//Initialization
	private String ram;
	private String cpu;
	private String hdd;
	private String graphics;
	
	/**Constructor of PC Class 
	 * @param String ram,cpu,hdd,graphics
	 * */
	public PC(String ram, String cpu, String hdd, String graphics) {
		super();
		this.ram = ram;
		this.cpu = cpu;
		this.hdd = hdd;
		this.graphics = graphics;
	}
	
	/**Overridden method of Computer Class*/
	@Override
	public String getRAM() {
		return this.ram;
	}
	
	/**Overridden method of Computer Class*/
	@Override
	public String getHDD() {
		return this.hdd;
	}
	
	/**Overridden method of Computer Class*/
	@Override
	public String getCPU() {
		return this.cpu;
	}
	
	/**Overridden method of Computer Class*/
	@Override
	public String getGraphics() {
		return this.graphics;
	}
	
	
}
