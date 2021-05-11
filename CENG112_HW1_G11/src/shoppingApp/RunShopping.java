package shoppingApp;

import java.util.Scanner;

public class RunShopping {
	private Bag shoppingBasket; //The bag that keeps the added items.
	private Fridge fridge;     // Fridge with the different compartments.
	
    public RunShopping(){  	
    	this.shoppingBasket = new ShoppingBasket(2000);
		this.fridge = new Fridge();   	
    }
    
    
    public void startApp() {
        System.out.println("Welcome!\n");
        System.out.println("Where would you like to go?\nPlease press H to go home, M to go Mall or Q to exit.");
        choose(0); // Checks where the user wants to go.
    }
    
    public InventoryBag<Item> createInventory(){
    	FileIO getAccess = new FileIO("inventory.txt"); //reads the given file
        return getAccess.readInventory(); //creates the items from the file and keeps them in an Item array.	
    }
    
    //When the user wants to go to mall this operation is called.
    public void mallOperations() {
        System.out.print("Welcome to Mall.\nWe have:");
        InventoryBag<Item> marketList = createInventory();
        marketList.printInventory(); //prints the items in an organized way to the console.
        System.out.println("\nTo add items press 'A'\nTo check your basket press 'B'\nTo go home press 'H'\nTo exit press'Q'");
        choose(2); //Checks what the user wants to do.

    }
    
    // Executes the operations of "Adding to shopping basket" and "Checking the shopping basket"
    public void basketOperations(String choice) {

        if (choice.equalsIgnoreCase("A")) { //If the user wants to add something         
            Item[] items = createInventory().getList(); //The list of products at the market is received. 
            System.out.println("Enter the indexes of items you want to add one by one.To finish adding press -1.");
            Scanner input = new Scanner(System.in);
            int index = input.nextInt();
            while (index >= 0) { //User can add items consecutively in this while loop.
                shoppingBasket.add(items[index]);
                index = input.nextInt(); //Takes the new input to add new item or quit the loop.
            }
            
        }
        else if (choice.equalsIgnoreCase("B")) { //If the user wants to check the shopping basket
            getBasket().displayItems(); //Show the list of items that are currently in the basket.
        }
        System.out.println("\nTo add items press 'A'\nTo check your basket press 'B'\nTo go home press 'H'\nTo exit press'Q'");
        choose(2); //Checks what the user wants to do.
    }

    //This method is called when the user goes home.
    public void fridgeOperations() {
        if (getFridge().isFull()){ //If the fridge's all compartments are completely full, program ends.
            System.out.println("Fridge is full.");
            transactions(0,"q"); //Quit
        }
        else {
            String operations = "To add items to fridge press 'A'\nTo see the capacity of the fridge press'B'\nTo go Mall press 'M'\nTo quit press 'Q'";
            System.out.println("\nWhat would you like to do?\n" + operations);
            choose(1); //Checks what the user wants to do.
        }
    }

    //This method is called when a decision is asked from the user.
    public void choose(int fromWhere) {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        
        if(fromWhere==0) {transactions(fromWhere,choice);} //If the operation comes from the startApp() only "H" and "M" operations are valid.
        if(fromWhere==1) { //If the operation comes from Home (fridgeOperations());
            if(choice.equalsIgnoreCase("A")) { // Calls the methods for adding from basket to fridge.
                
            	if(!getBasket().isEmpty()) { //Precondition for decideAddPrint() is checked. 
                    getFridge().decideAddPrint(getBasket());  //Adding operation is called
                }
                else {
                    System.out.println("Your shopping basket is empty. You can't add something."); //Precondition couldn't be met.
                    
                }
            	fridgeOperations();//Turns back to choices
            }
            else if(choice.equalsIgnoreCase("B")) { //Calls the methods for checking the Fridge.
                getFridge().printFridge(); //Shows how much of the Fridge's capacity is full.
                fridgeOperations();
            }
            else {transactions(fromWhere,choice);} // "M" and "Q" are also valid, checks if the user wanted these.
        }

        else if(fromWhere==2) { //If the operation comes from Mall
            if (choice.equalsIgnoreCase("A") || choice.equalsIgnoreCase("B")) {
                basketOperations(choice); // This can execute both Adding to basket and Checking the Basket operations.
            }
            else {transactions(fromWhere,choice);} // "H" and "Q" r also valid, checks if the user wanted these.
        }


    }

    public  void transactions(int fromWhere,String choice) {
        if (choice.equalsIgnoreCase("H")) {fridgeOperations();} // Goes Home ( calls Fridge operations)
        else if (choice.equalsIgnoreCase("M")) {mallOperations();} // Goes Mall ( calls Mall operations)
        else if (choice.equalsIgnoreCase("Q")) {System.out.println("Have a nice day.");} // Quits.
        else { //If the user gives wrong input, asks to choose again.
            System.out.println("Please enter a valid operation"); 
            choose(fromWhere); 
        }
        
    }
        
    public Fridge getFridge() {
    	return this.fridge;
    }
    
    public Bag getBasket() {
    	return this.shoppingBasket;
    }

    
}
