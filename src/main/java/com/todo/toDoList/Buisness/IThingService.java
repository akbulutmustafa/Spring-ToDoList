package com.todo.toDoList.Buisness;

import java.util.List;

import com.todo.toDoList.Entities.Thing;

public interface IThingService {
	List<Thing> getAll();
	void add(Thing thing);
	void update(Thing thing);
	void delete(Thing thing);
	Thing getById(int id);
}
