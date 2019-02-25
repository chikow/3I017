package test;

import org.json.JSONObject;

import service.LogoutS;
import servlet.Logout;

public class LogoutTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		JSONObject o = LogoutS.logout("beh09aiclV3gH8DE6Z8Xp4yfxAN0dGaO");
		System.out.println(o);
	}

}
