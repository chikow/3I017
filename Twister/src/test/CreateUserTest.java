package test;



import org.json.JSONObject;

import service.CreatUserS;
import tools.UserTools;



/**
 * @author LAOUER Walid
 *
 */
public class CreateUserTest {


	public static void main(String[] args) {


		JSONObject obj = CreatUserS.createUser("neel","Nail", "BELAREF", "bealref@gmail.com", "123");
		System.out.println(obj.toString());
		System.out.println("heeeeey");
		System.out.println(UserTools.checkPassword("neel", "123"));

	}


}
