package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	public static void testAddCartItem() {
		CartDao cartDao= new CartDaoCollectionImpl();
		cartDao.addCartItem((long)1, (long)1);
        
        cartDao.addCartItem((long)2,(long)4);
        List<MenuItem> cartItems;
		try {
			cartItems = cartDao.getAllCartItems((long)1);
			for (MenuItem item: cartItems) {
		        System.out.println(item.toString());
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	 private static void testGetAllCartItems() {
	        CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
	        try {
	            List<MenuItem> cartItems = cartDao.getAllCartItems(1);
	            for (MenuItem item: cartItems) {
	                System.out.println(item.toString());
	            }
	        } catch (CartEmptyException e) {
	            e.printStackTrace();
	        }
	    }
	 public static void testRemoveCartItem() {
		 CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
	        cartDao.removeCartItem(1, 1);
	        try {
	            List<MenuItem> cartItems = cartDao.getAllCartItems(1);
	            for (MenuItem item: cartItems) {
	                System.out.println(item.toString());
	            }
	        } catch (CartEmptyException e) {
	            e.printStackTrace();
	        } 
	 }
public static void main (String[] args) {
	System.out.println("Cart Datails");
    testAddCartItem();
    testGetAllCartItems();
    testRemoveCartItem();
}
}
