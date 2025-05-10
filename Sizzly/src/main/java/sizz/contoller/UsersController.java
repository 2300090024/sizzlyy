package sizz.contoller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sizz.model.Users;
import sizz.model.UsersManager;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
//when you want to return data (e.g. JSON or XML) rather than a view (HTML)
@RequestMapping("/users")
//to map requests to controllers methods
@CrossOrigin(origins="http://localhost:5173/")
//simplifies the process of testing APIs and collaborating on API development
public class UsersController {
	
	@Autowired
	
	UsersManager UM;
	
	@PostMapping("/signup")
	//mapping HTTP POST requests onto specific handler methods
	public String signup(@RequestBody Users u) {
		//TODO: process POST request
		
		return UM.addUser(u);
	}
		
	@PostMapping("/signin")
	public String signin(@RequestBody Users u) {
		return UM.validateCredentials(u.getEmail(), u.getPassword());
	
	}
	
	@PostMapping("/getfullname")
	  public String getfullname(@RequestBody Map<String, String> data) {
	    return UM.getFullname(data.get("csrid"));
	  }
	
	
}