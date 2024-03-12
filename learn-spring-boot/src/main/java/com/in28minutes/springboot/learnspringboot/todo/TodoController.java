/**
 * 
 */
package com.in28minutes.springboot.learnspringboot.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 19-Dec-2023
 */
@Controller
public class TodoController {

	private TodoService todoService;

	/**
	 * @param todoService
	 */
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap modelMap) {
		List<Todo> todoList = todoService.findbyUsername("Somendu");
		modelMap.addAttribute("todos", todoList);
		return "listtodos";
	}

}
