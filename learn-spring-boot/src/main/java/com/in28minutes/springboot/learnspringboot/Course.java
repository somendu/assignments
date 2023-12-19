/**
 * 
 */
package com.in28minutes.springboot.learnspringboot;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Dec-2023
 */
public class Course {

	private long id;
	private String name;
	private String author;

	/**
	 * @param id
	 * @param name
	 * @param author
	 */
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
