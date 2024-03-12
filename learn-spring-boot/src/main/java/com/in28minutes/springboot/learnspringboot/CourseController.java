/**
 * 
 */
package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Dec-2023
 */
@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retriveAllCourses() {
		return Arrays.asList(new Course(1, "Learn AWS", "In 28 Minutes"),
				new Course(2, "Learn Devops", "In 28 Minutes"), new Course(3, "Learn Azure", "In 28 Minutes"));
	}

}
