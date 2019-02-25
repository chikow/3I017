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


	public static void main(String[] args) throws InstantiationException, IllegalAccessException {


		JSONObject obj = CreatUserS.createUser("Delpaxll","del", "Pax", "Dellpax@gmail.com", "1234");
		System.out.println(obj.toString());
		System.out.println("heeeeey");

		
	}


}
