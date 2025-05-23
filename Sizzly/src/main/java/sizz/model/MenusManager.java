package sizz.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;

import sizz.repository.UserRepository;

@Service
public class MenusManager {
  @Autowired
  MenusRepository MR;
  @Autowired
	JWTManager JWT;
	
	@Autowired
	UserRepository UR;

  public String getMenus() {
    List<String> menulist = new ArrayList<String>();
    for (Menus M : MR.findAll())
      menulist.add(new GsonBuilder().create().toJson(M));
    return menulist.toString();
    }
//Fetch menu items from database based on user role
	public String getMenusByRole( String token) {
		
		String email =  JWT.validateToken(token);
		if(email.equals("401"))
			return "401::Invalid Token";
		
		Users U = UR.findById(email).get();
		List<Menus> menuList = MR.findByRole(U.getRole());
		
		return new GsonBuilder().create().toJson(menuList).toString();
	}
}



