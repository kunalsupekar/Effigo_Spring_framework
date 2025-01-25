package com.example.MyFirstWebApplication.todo;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
	List<Todo> todos=	todoService.findByUsername("kunal");
	model.addAttribute("todos",todos);
		return "listTodos";
	}
	
	
	@RequestMapping(value = "add-todo",method = RequestMethod.GET)
	public String ShowAddTodo(ModelMap model) {
		String uname=(String) model.get("name");
		Todo todo=new Todo(0,uname,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "addtodo";
	}
	
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo( ModelMap model,@Valid Todo todo,BindingResult result) { 
		
		if(result.hasErrors()) {
			return "addtodo";
		}
		
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), 
				LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}	
	
	@RequestMapping("delete-todo")
	public String listAllTodos(@RequestParam int id) {
	  todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
	  Todo todo =todoService.findByID(id);
	  model.addAttribute(todo);
		return "addtodo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo( ModelMap model,@Valid Todo todo,BindingResult result) { 
		
		if(result.hasErrors()) {
			return "addtodo";
		}
		
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoService.updateToDo(todo);
		return "redirect:list-todos";
	}	
	
	
}
