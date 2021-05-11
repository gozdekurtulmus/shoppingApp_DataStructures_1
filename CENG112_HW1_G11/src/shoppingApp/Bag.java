package shoppingApp;

public class Bag implements IBag<Item>{
        private Item[] products;  //items list
        private int capacity;     //capacity of bag
        private int gram ;        //total gram of items in the bag
        private int size;         //number of items

    public Bag(int capacity){
        this.products = new Item[0]; //at first item list is empty
        this.capacity = capacity;
        this.gram = 0;          //at first bag is empty
        this.size = 0;
    }
    @Override
    //The size of the array will change with every item added
    public boolean add(Item newItem) {
        if (gram + newItem.getWeight() <= capacity){
            //If the grams of the item to be added and the grams of the contents of the bag exceed the capacity, no additions can be made.
            Item[] tempArr = new Item[++size];
            for (int i=0; i < products.length; i++){
                tempArr[i]=products[i];
            }
            tempArr[products.length]=newItem;
            gram += newItem.getWeight();
            products = tempArr;
            System.out.println(newItem.getName() + " added.");
            return true;
        }
        else{
            if (!(newItem.getComp().equals("vegetables and fruits")|| newItem.getComp().equals("meats")|| newItem.getComp().equals("beverages")||newItem.getComp().equals("snacks"))){
                System.out.println(newItem.getName()+ " cannot be added to your fridge."); //if item is added to fridge
            }
            else{
                System.out.println(newItem.getName()+ " cannot be added to your shopping basket.");
            }
            return false;
        }
    }
    @Override
    public boolean isEmpty() {
        return size == 0; //returns true if empty
    }
    @Override
    public boolean isFull() {
        return gram >= capacity; //returns true if full
    }
    @Override
    public Item removeByIndex(int index) {
        Item removeItem = products[index]; //gets the product at the given index
        return remove(removeItem);
    }
    @Override
    public Item remove() {
        return removeByIndex(products.length-1); //removes the last added product
    }
    
    //pre-cond:It is checked in the Fridge class whether the item to be removed is exists or not.
    //The size of the array will change with every item removed
    @Override
    public Item remove(Item item) {
        Item[] tempArr = new Item[--size];
        int index=0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getName().equals(item.getName())) {
                index = i;
                break;
            }
            else{
                tempArr[i] = products[i];
            }
        }
        for (int i=index+1; i<products.length;i++){
            tempArr[i-1] = products[i];
        }
        gram -= item.getWeight();
        products = tempArr;
        return item;
    }
    @Override
    public int getItemCount() {
        return size;
    }
    @Override
    public int getIndexOf(Item item) {
        for (int i=0; i<products.length; i++){ //Finds the index of the given item by checking the list
            if(products[i].isEqual(item)) { 
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean contains(Item item) {
        for (Item product : products) { //Searches if the given item is in the list
            if (product.isEqual(item)) { 
                return true;
            }
        }
        return false;
    }
    @Override
    public void displayItems() {
        if (isEmpty()){ //the bag is empty
            System.out.println("Empty!");
        }
        else{
            for (int i=0; i<products.length; i++) {//prints the items in an organized way to the console.
                System.out.print("  ["+i+"] "+products[i].toString());
            }
        }
    }
    @Override
    public void dump() { // every item in the bag is removed
            products = new Item[0];
            size = 0;
            gram = 0;
            System.out.println("Your shopping basket is empty");
    }
    @Override
    public boolean transferTo(IBag<Item> targetBag, Item item) {
        //the item inside the bag is transferred to the specified compartment
        if (targetBag.add(item)){
            remove(item);
            return true;
        }
        else{
            remove(item);
            return false;
        }
    }
    
    public int getCapacity() {
    	return this.capacity;
    }


    public int getGram() {
    	return this.gram;
    }

    
    public int getSize() {
    	return this.size;
    }

    
    public Item getProduct(int index){ //returns the item in the specified index
        return products[index];
    }
}
