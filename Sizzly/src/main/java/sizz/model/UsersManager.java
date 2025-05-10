package sizz.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sizz.repository.UserRepository;

@Service
public class UsersManager {

    @Autowired
    UserRepository UR;

    @Autowired
    JWTManager JWT;

    public String addUser(Users u) {
        if (UR.validateEmail(u.getEmail()) > 0)
            return "401::E-mail Already Exist";

        UR.save(u);
        System.out.println(u.getFullname());
        return "200::User Registration Successful";
    }

    public String validateCredentials(String email, String password) {
    	if(UR.validateCredentials(email , password)>0) {
    		String token=JWT.generateToken(email);
    		return "200::"+token;
    	}
    	return "401::Invalid credentials";
    		
    	}
    public String getFullname(String token) {
        String email = JWT.validateToken(token);
        if (email.compareTo("401") == 0)
            return "401::Token Expired!";
        Users U = UR.findById(email).get();
        return U.getFullname();
    }
}
