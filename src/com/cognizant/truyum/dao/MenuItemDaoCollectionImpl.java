package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static ArrayList<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		if(menuItemList.isEmpty()|| menuItemList==null) {
			menuItemList=new ArrayList<MenuItem>();
		    menuItemList.add(new MenuItem(01L,"Sandwich",99.00f,true,DateUtil.convertToDate("15/03/2017"),"Main Course",false));	
		    menuItemList.add(new MenuItem(02L, "Burger",129.0f,true,DateUtil.convertToDate("23/12/2017"), "Main Course",false));
		    menuItemList.add(new MenuItem(03L, "Pizza",  149.0f,true,DateUtil.convertToDate("21/08/2018"),"Main Course",false));
			menuItemList.add(new MenuItem(04L, "French Fries",57.0f,false,DateUtil.convertToDate("02/07/2017"), "Starters",true));
			menuItemList.add(new MenuItem(05L, "Chocolate Brownie",32.0f,true,DateUtil.convertToDate("02/11/2022"),"Dessert",true));
		}
		
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> list =new ArrayList<MenuItem>();
		for(MenuItem item: menuItemList) {
			Date d = item.getDateOfLaunch();
			Date Cdate=new Date();
			if(d.before(Cdate)||d.equals(Cdate)) {
				if(item.isActive())
					list.add(item);
		}
		}
		return list;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for(MenuItem item:menuItemList) {
			if(item.equals(menuItem)) {
				item.setName(menuItem.getName());
				item.setActive(menuItem.isActive());
				item.setCategory(menuItem.getCategory());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setCategory(menuItem.getCategory());
				item.setFreeDelivery(menuItem.isFreeDelivery());
			}
			
		}
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
