package test;

import org.json.JSONObject;

import service.follows.RemoveFriendS;

public class Unfollow {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		JSONObject o = RemoveFriendS.Unfollow("T5UDpNSvGMXbmWZ3jLeDedBVDPtMdzL4", 9);
		System.out.println(o);

	}
}