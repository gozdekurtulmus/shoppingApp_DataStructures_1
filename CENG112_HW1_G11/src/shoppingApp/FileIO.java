package shoppingApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {

	private String fileName; //Input file

	public FileIO(String fileName) {
		this.fileName =fileName;
	}
	
	//Get the number of lines in the given file
	public int getCount() {
		return findCount(getFileName());		
	}
	
	
	public String getFileName() {
		return this.fileName;		
	}
	
	//Converts the Item list into InventoryBag<Item> 
	public InventoryBag<Item> readInventory(){
		return new InventoryBag<>(createList());
			
	}
	
	
	//Creates an Item list from the given file.
	public Item[] createList() { 	
		Item[] items =  new Item[getCount()]; //Determine the size of the Item list.
		try {
			Scanner myReader = new Scanner(new File(getFileName()));			
			int i=0;
			
			while (myReader.hasNextLine()) {	
				String data = myReader.nextLine();
				items[i]=  new Item (data.split(",")); // Converts each row of the file into an Item and keeps them in the items array.
				i++;
			}	
			myReader.close();
		}
		catch (FileNotFoundException e) {System.out.println("File not found.");}
		return items;						
	}
	
	
	//Finds the number of lines in the file
	public int findCount( String fileName) {
		int count=0;
		try {
			Scanner myReader = new Scanner(new File(fileName));				
			while (myReader.hasNextLine()) {
				myReader.nextLine();
				count++;
			}
			myReader.close();
		}
		catch (FileNotFoundException e) {System.out.println("File not found."); }
		return count;		
	}
	

}
	
	
	