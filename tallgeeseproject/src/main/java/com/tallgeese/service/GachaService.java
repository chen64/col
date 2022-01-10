package com.tallgeese.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tallgeese.model.Collectable;
import com.tallgeese.model.User;
import com.tallgeese.repository.CollectableDao;
import com.tallgeese.repository.UserDao;

@Service("gachaService")
public class GachaService {
	
	private ArrayList<Collectable> collList;
	
	private CollectableDao collDao;
	
	private UserDao userDao;
	
	Random rng = new Random();
	
	public GachaService() {

	}
	
	@Autowired
	public GachaService(CollectableDao collDao, UserDao userDao) {
		super();
		this.collDao = collDao;
		this.userDao = userDao;
	}
	
	public User selectUser(String username) {
		return userDao.selectByUsername(username);
	}
	
	public List<Collectable> selectAllCollectables(){
		return collDao.selectAll();
	}
	
	public List<User> selectAllUsers(){
		return userDao.selectAll();
	}
	
	public List<Collectable> getUserCollectables(String username){
		User user = selectUser(username);
		return user.getCollectable();
	}
	
	public List<Collectable> selectRandomCollectable(String username) {
		User user = selectUser(username);
		List<Collectable> tmpList = user.getCollectable();
		List<Collectable> rollList = new ArrayList<>();
		if (this.collList==null) {
			collList = (ArrayList<Collectable>) collDao.selectAll();
		}
		Collectable newColl = collList.get(rng.nextInt(collList.size()));
		rollList.add(newColl);
		if (!(tmpList.contains(newColl))) {
			tmpList.add(newColl);
			user.setCollectable(tmpList);
			userDao.update(user);
		}
		return rollList;
	}
	
	public List<Collectable> select10RandomCollectables(String username){
		User user = selectUser(username);
		List<Collectable> tmpList = user.getCollectable();
		List<Collectable> rollList = new ArrayList<>();
		if (this.collList==null) {
			collList = (ArrayList<Collectable>) collDao.selectAll();
		}
		for (int i=0; i<10; i++) {
			Collectable newColl = collList.get(rng.nextInt(collList.size()));
			rollList.add(newColl);
			if (!(tmpList.contains(newColl))) {
				tmpList.add(newColl);
				user.setCollectable(tmpList);
			}
		}
		userDao.update(user);
		return rollList;
	}
	
	public void createUser(User user) {
        userDao.insert(user);
    }
}
