package test;

import org.json.JSONObject;

import service.AddFriendS;

public class ListFriendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject o3 = AddFriendS.listFollowers("p7OxPwaydulGINckYSBWI6naJW3rlSQ5");
		System.out.println(o3);
	}

}
