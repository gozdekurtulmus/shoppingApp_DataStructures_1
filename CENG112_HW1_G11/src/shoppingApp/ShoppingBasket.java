package shoppingApp;
//This compartment extends Bag class
//Because every method in the Bag class is used in the same way, no extra method or override is done
public class ShoppingBasket extends Bag implements IBag<Item>{
    public ShoppingBasket(int capacity){
        super(capacity);
    }
}
