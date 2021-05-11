package shoppingApp;
/** 
 	An interface that describes the operations of a bag of objects.
	@param <T>
 */


public interface IBag<T> {
	
/** Adds a new entry to this bag.	
	@param newItem The object to be added as new entry.
	@return True if the addition is successful, or false if not. */
	public boolean add(T newItem);
	
/** Sees whether this bag is empty.
	@return True if the bag is empty, or false if not. */
	public boolean isEmpty();
	
/** Sees whether this bag is full.	
	@return True if the bag is empty, or false if not. */
	public boolean isFull();
	
/** Removes the occurrence of the given index from the bag.
	@param index The index of the occurrence to be removed.
	@return T the removed occurrence. */
	public T removeByIndex(int index);
	
/** Removes the last entry from this bag.
 	@return Either the removed entry, if the removal was successful, or null */	
	public T remove();
	
/** Removes the given entry from this bag, if possible.
    @param item The entry to be removed.
    @return T the removed occurrence. */
	public T remove(T item);
	
/** Gets the current number of entries in this bag.	
	@return The integer number of entries currently in the bag. */
	public int getItemCount();

/** Finds the index of given item in the list.
	@param item The entry which the user wants to find index.
	@return The integer number of the index. */
	public int getIndexOf(T item);
	
/** Sees whether the bag contains the given entry.
	@param item The entry to be checked.
	@return True if the bag contains the item or false if not. */
	public boolean contains(T item);
	
/** Shows all the items in the bag. */	
	public void displayItems();

/** Removes all the items form the bag. */
	public void dump();
		
/** Transfers the item to target bag.	
   @param targetBag The bag that the item will be transferred.
   @param item The item that will be transferred to bag.
   @return True if the transfer is successful or false if not.*/
	public boolean transferTo(IBag<T> targetBag, T item);
	
	
}
