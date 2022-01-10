package com.tallgeese.repository;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tallgeese.model.User;

@Transactional
@Repository("userDao")
public class UserDao {

	private SessionFactory sesFact;
	
	public UserDao() {
		
	}

	@Autowired
	public UserDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(User user) {
		sesFact.getCurrentSession().save(user);
	}
	
	public void update(User user) {
		sesFact.getCurrentSession().update(user);
	}
	
	public List<User> selectAll(){
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
	}
	
	public User selectById(int id) {
		return sesFact.getCurrentSession().get(User.class, id);
	}
	
	public User selectByUsername(String username) {
		List<User> userList = sesFact.getCurrentSession().createQuery("from User where username='" + username + "'", User.class).list();
		if(userList.size()==0) {
			return null;
		}
		return userList.get(0);
	}
	
	public User selectByEmail(String email) {
        List<User> userList = sesFact.getCurrentSession().createQuery("from User where email='" + email + "'", User.class).list();
        if(userList.size()==0) {
            return null;
        }
        return userList.get(0);
    }
}
