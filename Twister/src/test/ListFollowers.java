package test;

import org.json.JSONObject;

import service.AddFriendS;

public class ListFollowers {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		JSONObject o = AddFriendS.listFollowers("test");
		System.out.println(o);
		
	}
}

