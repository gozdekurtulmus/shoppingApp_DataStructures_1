package shoppingApp;

import java.util.Scanner;

public class Fridge {
    private Bag meats;       //MeatsCompartment
    private Bag vegetablesFruits;   //VegetablesFruitsCompartment
    private Bag snacks;            //SnacksCompartment
    private Bag beverages;        //BeveragesCompartment
    

    public Fridge(){ //Each compartment is created with their fixed sizes
    	this.meats = new MeatsCompartment(5000);
		this.vegetablesFruits = new VegetablesFruitsCompartment(3000);
		this.snacks = new SnacksCompartment(2000);
		this.beverages = new BeveragesCompartment(4000);
    }
    
    //This method is used when the user wants to add items in their bag to fridge.
    //Precondition: It is checked that Bag is not empty before using this method.
    public void decideAddPrint(Bag shoppingBasket){

        System.out.println("You have these items in your shopping basket:");
        shoppingBasket.displayItems(); //Shows the items in the basket with their indexes,names and grams.
        System.out.println("\nEnter the indexes of items you want to put in. Press -1 to stop adding.");       
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt(); 
        while(index>=0) { //User can add items consecutively in this while loop. 
            
            if (shoppingBasket.getSize() <= index) { //Precondition for the usage of the remove method.
            	System.out.println("Please select a valid number.");
                } 
            else {
            	Item newItem = shoppingBasket.getProduct(index); //Find the item of the given index.
            	shoppingBasket.transferTo(getCompartment(newItem.getComp()),newItem); //Transfer the item to the compartment where it belongs in the fridge and remove from the bag.
                }
            if(shoppingBasket.isEmpty()) { // When the shopping basket is empty user can't use the method anymore.
        		System.out.println("Your shopping basket is empty now.");
        		break;        		
        	}
            shoppingBasket.displayItems(); //Removing items from the bag will change their indexes. It displays the refreshed list.
            System.out.println();
            index = scanner.nextInt(); //Takes the input to add a new item or exit from the loop.
        }        
    }
    
    public void printFridge() { //Prints the remaining capacities in the every compartment
    	System.out.println("Meats:"+this.meats.getGram()+"/"+this.meats.getCapacity()+
    						"\nVegetables and Fruits:"+this.vegetablesFruits.getGram()+"/"+this.vegetablesFruits.getCapacity()+
    						"\nSnacks:"+this.snacks.getGram()+"/"+this.snacks.getCapacity()+
    						"\nBeverages:"+this.beverages.getGram()+"/"+this.beverages.getCapacity());
    	
    }
    
    public Bag getCompartment(String comp) { //Returns which compartment the item will be transferred to
    	if(comp.equals("meats")) {
    		return this.meats; 		
    	}
    	if(comp.equals("beverages")) {
    		return this.beverages; 		
    	}
    	if(comp.equals("snacks")) {
    		return this.snacks;
    	}
    	if(comp.equals("vegetables and fruits")) {
    		return this.vegetablesFruits;
    	}
    	else return null;   	
   	
    }
    
    public boolean isFull() { //Checks every compartment, returns true if the fridge is completely full or false otherwise.
        return meats.isFull() && vegetablesFruits.isFull() && beverages.isFull() && snacks.isFull();      
    }
}
