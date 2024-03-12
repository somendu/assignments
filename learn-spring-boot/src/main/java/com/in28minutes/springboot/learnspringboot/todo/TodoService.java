/**
 * 
 */
package com.in28minutes.springboot.learnspringboot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 19-Dec-2023
 */
@Service
public class TodoService {

	private static List<Todo> todoList = new ArrayList<Todo>();

	static {
		todoList.add(new Todo(1, "Somendu", "Learn GCP", LocalDate.now().plusYears(1), false));
		todoList.add(new Todo(2, "Somendu", "Learn AWS", LocalDate.now().plusYears(1), false));
		todoList.add(new Todo(3, "Somendu", "Learn PCF", LocalDate.now().plusYears(1), false));

	}

	public List<Todo> findbyUsername(String username) {
		return todoList;
	}
}
