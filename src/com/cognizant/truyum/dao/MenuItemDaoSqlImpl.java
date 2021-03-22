package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao{
	
	
	@Override
	public ArrayList<MenuItem> getMenuItemListAdmin() {
		
			try {
			Connection conn = ConnectionHandler.getConnectoin();
			ArrayList<MenuItem> menuItemList=new ArrayList<>();
			PreparedStatement ps=conn.prepareStatement("select* from -----");
			ResultSet result =ps.executeQuery();
			while (result.next()){
                long id = result.getInt(1);
                String name = result.getString(2);
                float price = result.getFloat(3);
                boolean active = result.getBoolean(4);
                Date dateOfLaunch = result.getDate(5);
                String category = result.getString(6);
                boolean freeDelivery = result.getBoolean(7);
                MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
                menuItemList.add(menuItem);
			}
			
		return  menuItemList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		
		
		try 
		{
			Connection con = ConnectionHandler.getConnectoin();
			 ArrayList<MenuItem> menuItemList = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("select * ------------");
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				long id = result.getInt(1);
                String name = result.getString(2);
                float price = result.getFloat(3);
                boolean active = result.getBoolean(4);
                Date dateOfLaunch = result.getDate(5);
                String category = result.getString(6);
                boolean freeDelivery = result.getBoolean(7);
				  MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
	                menuItemList.add(menuItem);
			}
			return menuItemList;
			
		} catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		try {
            Connection conn = ConnectionHandler.getConnectoin();
            String query = "update menu_item set name=?, price=?, active=?, date_of_launch=?, category=?, free_delivery=? where id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, menuItem.getName());
            pstmt.setFloat(2, menuItem.getPrice());
            pstmt.setBoolean(3, menuItem.isActive());
            //pstmt.setDate(4,  menuItem.getDateOfLaunch());
            pstmt.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
            pstmt.setString(5, menuItem.getCategory());
            pstmt.setBoolean(6, menuItem.isFreeDelivery());
            pstmt.setLong(7,menuItem.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		try {
            Connection conn = ConnectionHandler.getConnectoin();
            //List<MenuItem> menuItemList = new ArrayList<>();
            String query = "select * from menu_item where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setLong(1, menuItemId);
            ResultSet result = pstmt.executeQuery();
            long id = 0;
            String name = null;
            float price = 0;
            boolean active = false;
            Date dateOfLaunch = null;
            String category = null;
            boolean freeDelivery = false;
            while(result.next()){
                id = result.getLong(1);
                name = result.getString(2);
                price = result.getFloat(3);
                active = result.getBoolean(4);
                dateOfLaunch = result.getDate(5);
                category = result.getString(6);
                freeDelivery = result.getBoolean(7);
            }
            MenuItem menuItem = new MenuItem(id, name, price,active, dateOfLaunch, category,freeDelivery);
            //menuItem.add(menuItem);
            return menuItem;

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

}
