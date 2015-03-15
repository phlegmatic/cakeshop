package src.com.vkkm.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import src.com.vkkm.bean.CartItems;
import src.com.vkkm.bean.ProductInfo;
import src.com.vkkm.bean.User;

public class Cart {

	private List<CartItems> cart;  // List of CartItems

	// constructor
	public Cart() {
		cart = new ArrayList<CartItems>();
	}

	// Add a CartItem into this Cart
	public void add( int id, String prodName, int prodPrice,User cust, int qtyOrdered) {
		// Check if the id is already in the shopping cart
		Iterator<CartItems> iter = cart.iterator();
		while (iter.hasNext()) {
			CartItems item = iter.next();
			if (item.getProdId() == id) {
				// id found, increase qtyOrdered
				item.setQtyOrdered(item.getQtyOrdered() + qtyOrdered);
				return;
			}
		}
		// id not found, create a new CartItem
		cart.add(new CartItems(id,prodName, prodPrice, cust, qtyOrdered));
	}

	// Update the quantity for the given id
	public boolean update(int id, int newQty) {
		Iterator<CartItems> iter = cart.iterator();
		while (iter.hasNext()) {
			CartItems item = iter.next();
			if (item.getProdId() == id) {
				// id found, increase qtyOrdered
				item.setQtyOrdered(newQty);
				return true;
			}
		}
		return false;
	}

	//checkout cart with final qty present in cart
	/*public void checkout(int newQty) {
		Iterator<CartItems> iter = cart.iterator();
		while (iter.hasNext()) {
			CartItems item = iter.next();
			item.setQtyOrdered(newQty);

		}
	}
*/	// Remove a CartItem given its id
	public void remove(int id) {
		Iterator<CartItems> iter = cart.iterator();
		while (iter.hasNext()) {
			CartItems item = iter.next();
			if (item.getProdId() == id) {
				cart.remove(item);
				return;
			}
		}
	}

	// Get the number of CartItems in this Cart
	public int size() {
		return cart.size();
	}

	// Check if this Cart is empty
	public boolean isEmpty() {
		return size() == 0;
	}

	// Return all the CartItems in a List<CartItem>
	public List<CartItems> getItems() {
		return cart;
	}

	// Remove all the items in this Cart
	public void clear() {
		cart.clear();
	}


}


