package com.todo.toDoList.Buisness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo.toDoList.DataAccess.IThingDal;
import com.todo.toDoList.Entities.Thing;

@Repository
public class ThingManager implements IThingService {
	
	private IThingDal thingDal;
	
	@Autowired
	public ThingManager(IThingDal thingDal) {
		this.thingDal = thingDal;
	}
	
	@Override
	@Transactional
	public List<Thing> getAll() {
		return this.thingDal.getAll();
	}

	@Override
	@Transactional
	public void add(Thing thing) {
		this.thingDal.add(thing);
	}

	@Override
	@Transactional
	public void update(Thing thing) {
		this.thingDal.update(thing);
	}

	@Override
	@Transactional
	public void delete(Thing thing) {
		this.thingDal.delete(thing);
	}

	@Override
	@Transactional
	public Thing getById(int id) {
		return this.thingDal.getById(id);
	}

}
