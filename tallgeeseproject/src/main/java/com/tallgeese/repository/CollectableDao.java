package com.tallgeese.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tallgeese.model.Collectable;

@Transactional
@Repository("collectableDao")
public class CollectableDao {
	
	private SessionFactory sesFact;
	
	public CollectableDao() {
		
	}

	@Autowired
	public CollectableDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(Collectable collectable) {
		sesFact.getCurrentSession().save(collectable);
	}
	
	public List<Collectable> selectAll(){
		return sesFact.getCurrentSession().createQuery("from Collectable", Collectable.class).list();
	}
	
}
