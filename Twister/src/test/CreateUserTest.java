package test;



import org.json.JSONObject;

import java.sql.Connection;
import java.sql.SQLException;

import db.Database;
import service.CreatUserS;
import tools.UserTools;



/**
 * @author LAOUER Walid
 *
 */
public class CreateUserTest {


	public static void main(String[] args) {


		JSONObject obj = CreatUserS.createUser("Delpax","del", "Pax", "Delpax@gmail.com", "1234");
		System.out.println(obj.toString());
		System.out.println("heeeeey");
		

		//Pour tester les methodes UserTools faut établire la connextion au niveau du main
		Connection c =null;
		try {
			c = Database.getMySQLConnection();
			System.out.println(UserTools.checkPassword("neel", "123", c));
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
