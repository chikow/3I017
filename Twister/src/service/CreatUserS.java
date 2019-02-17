package service;

import org.json.JSONObject;

import tools.ServiceTools;
import tools.UserTools;

/**
 * @author LAOUER Walid
 *
 */
public class CreatUserS {
	
	public static JSONObject createUser(String login, String nom, String prenom, String mail, String mdp) {
		if (nom == null || prenom == null || mail == null || login == null || mdp == null) {
			return ServiceTools.serviceRefused("Paramètre(s) vide(s)", -1);
		}
		
		if (UserTools.userExist(login)) {
			return ServiceTools.serviceRefused("Login existe déja", -2);
		}
		
		if (UserTools.mailExist(mail)) {
			return ServiceTools.serviceRefused("L'adresse mail existe déja", -3);
		}
		
		return UserTools.insertUser(login,nom, prenom, mail, mdp);
	}

}
