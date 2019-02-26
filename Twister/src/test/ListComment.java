package test;

import org.json.JSONObject;

import service.AddCommentS;

public class ListComment {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		JSONObject obj = AddCommentS.listComments("x36mHm0DTnciwuLEffkGyZrtR6QthzA7", "5c751d64d131316d05c87603");
		System.out.println(obj);
		

	}

}
