package com.tallgeese.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tallgeese.model.Collectable;
import com.tallgeese.model.User;
import com.tallgeese.service.GachaService;
import com.tallgeese.service.JavaMailUtil;

@Controller
@RequestMapping(value="/api/gacha")
@CrossOrigin(origins="*")
public class GachaController {
	
	private GachaService gServ;
	
	public GachaController() {
		
	}

	@Autowired
	public GachaController(GachaService gServ) {
		super();
		this.gServ = gServ;
	}

	@GetMapping(value="/getCollectables.app")
	public @ResponseBody List<Collectable> getAllCollectables(){
		return gServ.selectAllCollectables();
	}
	
	@GetMapping(value="/test.app")
	public @ResponseBody String test() {
		return "Success";
	}
	
	@PostMapping(value="/getUser.app")
	public @ResponseBody User getUser(@RequestBody Object user) {
		String username = (String) ((LinkedHashMap) user).get("username");
		return gServ.selectUser(username);
	}
	
	@PostMapping(value="/roll.app")
	public @ResponseBody List<Collectable> rollGacha(@RequestBody Object user) {
		String username = (String) ((LinkedHashMap) user).get("username");
		return gServ.selectRandomCollectable(username);
	}
	
	@PostMapping(value="/10roll.app")
	public @ResponseBody List<Collectable> roll10Gacha(@RequestBody Object user) {
		String username = (String) ((LinkedHashMap) user).get("username");
		return gServ.select10RandomCollectables(username);
	}
	
	@PostMapping(value="/userCollection.app")
	public @ResponseBody List<Collectable> getUserCollection(@RequestBody Object user){
		String username = (String) ((LinkedHashMap) user).get("username");
		return gServ.getUserCollectables(username);
	}
	
	@PostMapping(value="/addUser.app")
    public @ResponseBody void addNewUser(@RequestBody Object user) {
		String email = (String) ((LinkedHashMap) user).get("email");
		String username = (String) ((LinkedHashMap) user).get("username");
		String password = (String) ((LinkedHashMap) user).get("password");
		User newUser = new User(email, username, password, null);
        gServ.createUser(newUser);
    }
	
	@PostMapping(value="/mail.app")
    public @ResponseBody void passwordMail(@RequestBody Object obj) {
		String email = (String) ((LinkedHashMap) obj).get("email");
        try {
			JavaMailUtil.findEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
