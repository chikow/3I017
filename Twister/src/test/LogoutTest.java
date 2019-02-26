package test;

import org.json.JSONObject;

import service.LogoutS;
import servlet.Logout;

public class LogoutTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		JSONObject o = LogoutS.logout("CEBUjBMXjxfsTUMdAV4kkoNkGOw6HwoO");
		System.out.println(o);
	}

}
