package com.todo.toDoList.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo.toDoList.Entities.Thing;

@Repository
public class HibernateThingDal implements IThingDal {
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateThingDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Thing> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Thing> things = session.createQuery("from Thing", Thing.class).getResultList();
		return things;
	}

	@Override
	public void add(Thing thing) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(thing);
	}

	@Override
	public void update(Thing thing) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(thing);
	}

	@Override
	public void delete(Thing thing) {
		Session session = entityManager.unwrap(Session.class);
		Thing workToDelete = session.get(Thing.class, thing.getId());
		session.delete(workToDelete);
	}

	@Override
	public Thing getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Thing thing = session.get(Thing.class, id);
		return thing;
	}

}
