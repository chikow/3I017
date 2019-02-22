package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;

import com.sun.corba.se.impl.ior.FreezableList;

import db.Database;
import tools.FriendTools;
import tools.UserTools;

public class RemoveFriendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection c =null;
		try {
			c = Database.getMySQLConnection();
			try {
				System.out.println(FriendTools.unfollow(9, 8, c));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				System.out.println("heeeeey");
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
