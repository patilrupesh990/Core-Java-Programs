package com.bridgelabz.oops.InventaryManagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.JsonUtility;
import com.bridgelabz.util.Utility;

/********************************************************************************************************
 * @author Rupeshp007 date:6/12/2019
 * @version 1.0 Purpose:Service for manage Inventory Program Operations: 1.add
 *          inventory 2.get price of value 3.get total value of inventories
 **********************************************************************************************************/

public class InventoryService extends InventoryManagerImplementation implements Inventory {

	// Initilization for InventoryService

	static String fileName = "/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/InventaryManagement/InventoryDetails.json";
	InventoryDetails details = new InventoryDetails();

	static JSONArray arrayObject = new JSONArray();
	JSONObject inventoryObject = new JSONObject();

	/***********************************************************************************
	 * Override Method From Inventory to Display information about Rice,Wheat
	 * and Pulse like this different Inventory from .Json file
	 * 
	 * @param no
	 *            param
	 * @return void
	 * 
	 ********************************************************************************/

	@Override
	public void displayInventory() {
		String jsonobject = "";
		try {
			jsonobject = JsonUtility.readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(jsonobject);
	}

	/*********************************************************************************
	 * Override method from inventory to add Information about Inventories and
	 * it will be store into the InventoryDetails.json file.
	 * 
	 * @param no
	 *            param
	 * @return void
	 *******************************************************************************/

	@Override
	public void addInventory() {
		String name = "";
		double price = 0, weight = 0;
		System.out.println("Enter Name Of inventory");
		System.out.println("1.Rice 2.Pulse 3.Wheat 4.save");

		int input = Utility.InputInt();
		if (input > 0 && input < 4) {
			System.out.println("Enter Name");
			name = Utility.InputString();
			System.out.println("Enter the Price");
			price = Utility.InputDouble();

			System.out.println("Enter the  Weight");
			weight = Utility.InputDouble();
			details.setInventoryName(name);
			details.setInventoryprice(price);
			details.setInventoryweight(weight);
		}

		if (input == 1)
			this.ConverJavaToJsonAll(details, "Rice", name, weight, price);
		else if (input == 2)
			this.ConverJavaToJsonAll(details, "Pulse", name, weight, price);
		else if (input == 3)
			this.ConverJavaToJsonAll(details, "Wheat", name, weight, price);
		else if (input == 4) {
			// String jsonObject=inventoryObject.toJSONString();
			JsonUtility.writeToFile(fileName, inventoryObject);
		} else {
			System.out.println("Invalid input");
			inventary.addInventory();
		}

		// String string=JsonUtility.ConverJavaToJson(details);

	}

	/*********************************************************************************
	 * Override Method From Inventory to check Price For Rice,Wheat and Pulse
	 * like this different Inventory from .json file.
	 * 
	 * @param int
	 *            number
	 * @return void
	 * 
	 *         logic:weight of Inventory * Price Of Inventory per Kg.
	 *******************************************************************************/

	@SuppressWarnings({ "rawtypes" })
	@Override
	public void checkPrice() {
		System.out.println("1.Rice  2.Wheat  3.Pulse");
		String name = Utility.InputString();
		if (name.equals("rice") || name.equals("Rice")) {
			// parsing file "JSONExample.json"
			Object obj = null;
			try {
				obj = new JSONParser().parse(new FileReader(fileName));
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}

			// typecasting obj to JSONObject
			JSONObject jo = (JSONObject) obj;

			// getting address
			Map rice = ((Map) jo.get("Rice"));

			// iterating address Map
			double price = 0;
			@SuppressWarnings("unchecked")
			Iterator<Map.Entry> itr1 = rice.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();

				if (pair.getKey().equals("Price")) {
					price = (double) pair.getValue();
				}

			}
			System.out.println("Price of Rice /kg-->" + price);
			System.out.println("--------------------");
		} else if (name.equals("wheat") || name.equals("Wheat")) {
			Object obj = null;
			try {
				obj = new JSONParser().parse(new FileReader(fileName));
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}

			// typecasting obj to JSONObject
			JSONObject jo = (JSONObject) obj;

			// getting address
			Map wheat = ((Map) jo.get("Wheat"));

			// iterating address Map
			double price = 0;
			@SuppressWarnings("unchecked")
			Iterator<Map.Entry> itr1 = wheat.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();

				if (pair.getKey().equals("Price")) {
					price = (double) pair.getValue();
				}

			}
			System.out.println("Price of Wheat /kg-->" + price);

		}

		else if (name.equals("Pulse") || name.equals("Pulse")) {
			Object obj = null;
			try {
				obj = new JSONParser().parse(new FileReader(fileName));
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}

			// typecasting obj to JSONObject
			JSONObject jo = (JSONObject) obj;

			// getting address
			Map pulse = ((Map) jo.get("Pulse"));

			// iterating address Map
			double price = 0;
			@SuppressWarnings("unchecked")
			Iterator<Map.Entry> itr1 = pulse.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();

				if (pair.getKey().equals("price")) {
					price = (double) pair.getValue();
				}

			}

			System.out.println("Price of Pulse /kg-->" + price);

		} else {
			System.out.println("Invalid choice");
		}

	}

	/*********************************************************************************
	 * it will Convert all java object into the .json file like this different
	 * Inventory from .json file.
	 * 
	 * @param Object
	 *            object,String input,String name,double weight,double price
	 * @return JSONArray
	 *******************************************************************************/

	@SuppressWarnings("unchecked")
	public JSONArray ConverJavaToJsonAll(Object object, String input, String name, double weight, double price) {
		JSONObject inventoryrice = new JSONObject();
		JSONObject inventorywheat = new JSONObject();
		JSONObject inventorypulse = new JSONObject();
		inventoryObject = JsonUtility.readFile2(fileName);

		if (input.equals("Rice")) {

			inventoryrice.put("Name", name);
			inventoryrice.put("weight", new Double(weight));
			inventoryrice.put("Price", new Double(price));
			inventoryObject.put("Rice", inventoryrice);
			String jsonObject = inventoryObject.toJSONString();
			System.out.println(jsonObject + "SuccessFully Added.");
		} else if (input.equals("Wheat")) {

			inventorywheat.put("Name", name);
			inventorywheat.put("weight", new Double(weight));
			inventorywheat.put("Price", new Double(price));
			inventoryObject.put("Wheat", inventorywheat);
			String jsonObject = inventoryObject.toJSONString();
			System.out.println(jsonObject + "SuccessFully Added.");

		} else if (input.equals("Pulse")) {
			inventorypulse.put("name", name);
			inventorypulse.put("weight", new Double(weight));
			inventorypulse.put("Price", new Double(price));
			inventoryObject.put("Pulse", inventorypulse);
			String jsonObject = inventoryObject.toJSONString();
			System.out.println(jsonObject + "SuccessFully Added.");
		} else {
			System.out.println("Invalid Input please check speling");
			try {
				throw new InventoryExcpetion("Invalid Input Please check speling");
			} catch (InventoryExcpetion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inventary.addInventory();
		}

		// System.out.println(arrayObject);
		return arrayObject;
	}

}
