package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static Map<Long, Cart> userCarts =new HashMap<>();
	public CartDaoCollectionImpl() {
		if (userCarts == null || userCarts.isEmpty()) {
			userCarts = new HashMap<Long, Cart>();

		}	
	}
	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
		List<MenuItem> cartList1 = new ArrayList<>();

        if(userCarts.containsKey(userId)){
            Cart uCart = userCarts.get(userId);
            List<MenuItem> itemList = uCart.getMenuItemList();
            itemList.add(menuItem);
            uCart.setMenuItemList(itemList);
            userCarts.put(userId, uCart);
        } else {
            ArrayList<MenuItem> newUserList = new ArrayList<>();
            newUserList.add(menuItem);
            Cart newUserCart = new Cart((double)menuItem.getPrice(),newUserList);
            userCarts.put(userId, newUserCart);
        }
	}
	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		
		Cart MyCart = userCarts.get(userId);
		if(MyCart.getMenuItemList().size() == 0)
		{
			throw new CartEmptyException();
			
		}
		else
		{
			float Tamount =0.00f;
			for(MenuItem item : MyCart.getMenuItemList())
			{
				Tamount += item.getPrice();
			}
			MyCart.setTotal(Tamount);
		}
		return MyCart.getMenuItemList();
	}
	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		List<MenuItem> deletingList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < deletingList.size(); i++){
            if (deletingList.get(i).getId() == menuItemId){
                deletingList.remove(i);
            }
        }
	}

}
