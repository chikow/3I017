package test;

import org.json.JSONObject;

import service.comments.AddCommentS;

public class ListComment {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		JSONObject obj = AddCommentS.listComments("OfLqQL7cmvOYkK9pnxut4gF3YMcQWGEO", "5c751d64d131316d05c87603");
		System.out.println(obj);
		

	}

}
