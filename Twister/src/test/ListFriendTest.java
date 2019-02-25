package test;

import org.json.JSONObject;

import service.AddFriendS;

public class ListFriendTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		JSONObject o3 = AddFriendS.listFollowers("ZC2ggG3SW3mOMxZVUe33hNkIdPj40S3p");
		System.out.println(o3);
	}

}
