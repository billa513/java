package com.cognizant.truyum.dao;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	//public static void main(String[] args) 
 public static void testGetMenuItemListAdmin()
 {
	 MenuItemDao menuItemDao;
	 menuItemDao = new MenuItemDaoCollectionImpl();
		ArrayList<MenuItem> menuItemList = new ArrayList <MenuItem>();
		menuItemList = menuItemDao.getMenuItemListAdmin();
		System.out.println("Menu item list for admin"); 
     	for(MenuItem list: menuItemList) {
		System.out.println(list); 
	 }
 }
 		public static void testGetMenuItemListCustomer() {
 		MenuItemDao menuItemDao;
 		 menuItemDao = new MenuItemDaoCollectionImpl();
 		ArrayList<MenuItem> menuItemList = new ArrayList <MenuItem>();
     	menuItemList = menuItemDao.getMenuItemListCustomer();
		System.out.println("Menu item list for Customer"); 
     	for(MenuItem list: menuItemList) {
		System.out.println(list); 
 }
 		}
 		public static void testModifyMenuItem() {
 			MenuItem menuItem = new MenuItem(05L,"Chocolate Brownie",150.0f,true,DateUtil.convertToDate("02/11/2022"),"Dessert",true);
 			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			menuItemDao.modifyMenuItem(menuItem);
			if(menuItemDao.getMenuItem(menuItem.getId()) == menuItem);
			System.out.println(menuItem.getId());
			System.out.println(menuItem.getName());
			System.out.println(menuItem.getPrice());
			System.out.println(menuItem.isActive());
			System.out.println(menuItem.isFreeDelivery());
			System.out.println(menuItem.getDateOfLaunch());
 		
 		}
 		public static void main(String[] args)
 		{
 			testGetMenuItemListAdmin();
 			testGetMenuItemListCustomer();
 	        testModifyMenuItem();
 			
 			
 		}
}
