/** */
package com.assignments.udemy.stream.udemy.stream_terminal;

import com.assignments.udemy.stream.udemy.StudentDataBase;
import java.util.stream.Collectors;

/**
 * @author Somendu
 * @since 01-Oct-2020
 */
public class StreamsCountingExample {

  public static long count() {

    return StudentDataBase.getAllStudents().stream()
        .filter(student -> student.getGender().equalsIgnoreCase("male"))
        .collect(Collectors.counting());
  }

  public static void main(String[] args) {

    System.out.println("Count of Male Students: " + count());
  }
}
