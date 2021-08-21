package com.bridgelabz;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class StockAccountManagement {
	

	/**
	 * Purpose: Method to read Stock.json file and find the total price
	 * Providing read-only access to JSON data. Reading the external JSON file
	 * Creating main object to store JSONParser, JSONObject and JSONArray 
	 * Parsing object to JSONObject from  Stock.json file
	 */
	
	public void readStockJsonFile() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(".\\Resources/StockDetails");
		Object stockMain = parser.parse(reader);
		JSONObject stockObj = (JSONObject) stockMain;
		
		JSONArray stockArray = (JSONArray) stockObj.get("Stock");
		System.out.println("Details of Stock are: ");
		for (int i = 0; i < stockArray.size(); i++) {
			JSONObject stockDetails = (JSONObject) stockArray.get(i);
			
			String name = (String) stockDetails.get("stockName");
			long noOfShare = (long) stockDetails.get("numberOfShare");
			double price = (double) stockDetails.get("price");

			System.out.println("\nShare name is: " + name);
			System.out.println("Number of share is: " + noOfShare);
			System.out.println("Share price is: " + price);
			
			double stockPrice = noOfShare * price;
			System.out.println("\nTotal price of is " + stockPrice);

		}
		}

	public static void main(String[] args) throws IOException, ParseException {
		StockAccountManagement stockinfo = new StockAccountManagement();
		stockinfo.readStockJsonFile();

	}
}