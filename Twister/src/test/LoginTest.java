package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.LoginS;
import tools.SessionTools;

public class LoginTest {
	public static void main(String args[]) throws SQLException, JSONException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
	JSONObject obj = LoginS.login("neel", "123");
		//JSONObject o = LoginS.login("Delpaxll", "1234");
	//	System.out.println( obj);
	//System.out.println(o);
		
		System.out.println("L'utilisateur est-il toujours connecté ? "+SessionTools.isConnected("236Y3kSj2apuTFYgDKkLY1Ch5ao3Hicg"));
	}
}
