package sizz.contoller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sizz.model.MenusManager;

@RestController
@CrossOrigin
@RequestMapping("/menus")
public class MenusController {
	@Autowired
	MenusManager M;
	@PostMapping("/getmenus")
	public String getMenus() {
		return M.getMenus();
		
	}
	@PostMapping("/getmenusbyrole")
	public String getMenusByRole(@RequestBody Map<String, String> data)
	{
		return M.getMenusByRole(data.get("csrid"));
	}


	

}

