package shoppingApp;

public class Item {
	private String itemName; 
	private String itemCompartment;
	private final int itemWeight;

	public Item(String[] givenList) { // {"itemName","itemCompartment","itemWeight"} is an example given String[].
		this.itemName = givenList[0]; 
		this.itemCompartment = givenList[1];
		this.itemWeight = Integer.parseInt(givenList[2]);				
	}
	
	public String getName() {
		return this.itemName;	
	}
	
	public String getComp() {
		return this.itemCompartment;
	}
	
	public int getWeight() {
		return this.itemWeight;
	}
	
	//Gives Item's properties in an organized manner. 
	public String toString() {
		return this.itemName + "(" + this.itemWeight + "grams)";
	}
	
	//Checks if an item is equal to the other.
	public boolean isEqual(Item item) {
		boolean check = false;
		if(this.itemName.equals(item.getName()) && this.itemCompartment.equals(item.getComp()) && this.itemWeight==item.getWeight()) {
		check = true;
		}
		return check;		
	}
	
}
	