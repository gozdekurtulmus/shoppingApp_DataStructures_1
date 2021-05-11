package shoppingApp;

public class InventoryBag<T> {
	private  T[] items; //List of items in the mall.

	public InventoryBag(T[] itemList) {
		this.items = itemList;
	}			
	
	public T[] getList() {
		return this.items;		
	}
	
	//Prints the item list in a categorized way to the console.
	public void printInventory(){
		
		Item[] myList = (Item[]) getList();	
		int myIndex = 0;
		String startCategory = myList[myIndex].getComp(); //Starting category
		for (int i=0; i<4; i++) {
			System.out.print("\n\n"+startCategory.toUpperCase()+"\n");
			
			while(myIndex<myList.length && (myList[myIndex].getComp()).equals(startCategory)) {
				System.out.print("\t["+myIndex+"]" + myList[myIndex].toString()); //Print every item in the same category with their indexes and weights.
				myIndex++;
			}		
			if(myIndex<myList.length) {
			startCategory = myList[myIndex].getComp();	//Change the category if there are more
			}
		}
		System.out.println();
	}		
}
