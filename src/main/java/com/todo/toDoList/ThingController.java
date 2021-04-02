package com.todo.toDoList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.toDoList.Buisness.IThingService;
import com.todo.toDoList.Entities.Thing;

@Controller
@RequestMapping("/")
public class ThingController {
	
	private IThingService thingService;
	
	@Autowired
	public ThingController(IThingService thingService) {
		this.thingService = thingService;
	}
	
	@GetMapping("/")
	public String listHome(Model model) {
		model.addAttribute("things", thingService.getAll());
		return "things";
	}
	
	/*@GetMapping("things")
	public String list(Model model) {
		model.addAttribute("things", thingService.getAll());
		return "things";
	}*/
	
	@GetMapping("done/{id}")
	public String makeItDone(@PathVariable("id") int id, Model model) {
		Thing thing = thingService.getById(id);
		thing.setDone(true);
		model.addAttribute("thing", thingService.getAll());
		return "redirect:/";
	}
	
	@GetMapping("not-done/{id}")
	public String notDone(@PathVariable("id") int id, Model model) {
		Thing thing = thingService.getById(id);
		thing.setDone(false);
		model.addAttribute("thing", thingService.getAll());
		return "redirect:/";
	}
	
	@PostMapping("add")
	public String addWork(Thing thing, Model model) {
		thingService.add(thing);
		return "redirect:/";
	}
	
	@GetMapping("create")
	public String createWork(Thing thing) {
		return "add-thing";
	}
	
	@GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Thing thing = thingService.getById(id);
        model.addAttribute("thing", thing);
        return "update-thing";
    }
	
	@PostMapping("update/{id}")
    public String update(@PathVariable("id") long id, Thing thing, Model model) {
        thingService.update(thing);
        model.addAttribute("thing", thingService.getAll());
        return "redirect:/";
    }
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id, Model model){
		Thing thing = thingService.getById(id);
		thingService.delete(thing);
		model.addAttribute("thing", thingService.getAll());
        return "redirect:/";
	}
	
}
