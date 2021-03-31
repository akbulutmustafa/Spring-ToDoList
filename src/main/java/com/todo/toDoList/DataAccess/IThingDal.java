package com.todo.toDoList.DataAccess;

import java.util.List;

import com.todo.toDoList.Entities.Thing;

public interface IThingDal {
	List<Thing> getAll();
	void add(Thing thing);
	void update(Thing thing);
	void delete(Thing thing);
	Thing getById(int id);
}
