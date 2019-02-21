package test;

import org.json.JSONObject;

import service.AddFriendS;

public class AddFriendTest {
	public static void main(String[] args) {
		JSONObject o = AddFriendS.addFriend(9, 8);
		System.out.println(o);
	}
}
