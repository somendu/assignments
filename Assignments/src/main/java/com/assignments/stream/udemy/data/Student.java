package com.assignments.stream.udemy.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int gradeLevel;
	private double gpa;
	private String gender;
	private int noteBooks;
	private List<String> activities = new ArrayList<>();

	public Student() {

	}

	public Student(String name, int gradeLevel, double gpa, String gender,
			int noteBooks, List<String> activities) {
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.noteBooks = noteBooks;
		this.activities = activities;
	}

	public Student(String name, int gradeLevel, double gpa, String gender,
			List<String> activities) {
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.activities = activities;
	}

	public Student(String s) {
		this.name = s;
	}

	public void printListOfActivities() {

		System.out.println("List of Activities are : " + this.activities);
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", gradeLevel="
				+ gradeLevel + ", gpa=" + gpa + ", gender='" + gender + '\''
				+ ", activities=" + activities + '}';
	}

}
