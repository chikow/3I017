package test;

import org.json.JSONObject;

import service.follows.AddFriendS;

public class ListFollowers {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		JSONObject o = AddFriendS.listFollowers("9MLZHEOBJrcimnfVyHq7703mrZhyMbZi");
		System.out.println(o);
		
	}
}

