package test;

import org.json.JSONObject;

import service.LoginS;

public class LoginTest {
	public static void main(String args[]) {
		
		JSONObject obj = LoginS.login("neel", "123");
		JSONObject o = LoginS.login("Delpax", "1234");
		System.out.println( obj);
		System.out.println( o);
	}
}
