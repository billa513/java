package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;



public class CartDaoSqlImpl  implements CartDao{
	
	//public float total = 0.00f;

	
	public void addCartItem(long userId, long menuItemId) 
	{
		Connection con = ConnectionHandler.getConnectoin();
		String Query = "insert into ----------- ";
		
		long cartid = 1;
		try 
		{
			
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.execute();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	
	public ArrayList getAllCartItems(long userId) throws CartEmptyException {
		
		try {
            Connection conn = ConnectionHandler.getConnection();
            ArrayList<MenuItem> menuItemList = new ArrayList<>();
            double total = 0.0;
            String query = "select * from -----------------";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setLong(1,userId);
            ResultSet result = pstmt.executeQuery();
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
            Cart cart = new Cart(total, menuItemList);
            String query2 = "select ------------------";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.setLong(1,userId);
            ResultSet result2 = pstmt2.executeQuery();
            while (result2.next()){
                //System.out.println("price:" + result2.getFloat(1));
                cart.setTotal((double) result2.getFloat(1));
            }
            return menuItemList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
		
	}
	
	
	
	public void removeCartItem(long userId, long menuItemId)
	{
		Connection con = ConnectionHandler.getConnectoin();
		String query = "delete from  cart where user_id = ? AND menu_item_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1,userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}



}
