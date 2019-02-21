package test;

import org.json.JSONObject;

import service.LogoutS;
import servlet.Logout;

public class LogoutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject o = LogoutS.logout("neel");
		System.out.println(o);
	}

}
