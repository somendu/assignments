/**
 * 
 */
package com.assignments.stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Somendu
 *
 * @since 12-Sep-2020
 */
public class EmployeeStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<>();

		Employee empOne = new Employee(1, "Som", 36, 1000);
		Employee empTwo = new Employee(2, "RK", 31, 3453);
		Employee empThree = new Employee(4, "SK", 34, 2365);
		Employee empFour = new Employee(6, "PK", 34, 1632);
		Employee empFive = new Employee(9, "AK", 30, 5563);

		employeeList.add(empOne);
		employeeList.add(empTwo);
		employeeList.add(empThree);
		employeeList.add(empFour);
		employeeList.add(empFive);

		List<Employee> filtered = employeeList.stream()
				.filter(p -> p.getFirstName().endsWith("K"))
				.filter(p -> p.getAge() > 33).collect(Collectors.toList());

		// System.out.println(filtered);

		Map<Integer, List<Employee>> personsByAge = employeeList.stream()
				.collect(Collectors.groupingBy(p -> p.getAge()));

		// personsByAge
		// .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

		Double averageAge = employeeList.stream()
				.collect(Collectors.averagingInt(p -> p.getAge()));

		// System.out.println(averageAge); // 19.0

		Long count = employeeList.stream().collect(Collectors.counting());

		// System.out.println(count); // 5

		IntSummaryStatistics ageSummary = employeeList.stream()
				.collect(Collectors.summarizingInt(p -> p.getAge()));

		// System.out.println(ageSummary);

		String phrase = employeeList.stream().filter(p -> p.getAge() >= 33)
				.map(p -> p.getFirstName()).collect(Collectors.joining(" and ",
						"In Germany ", " are of legal age."));

		// System.out.println(phrase);

		Map<Integer, String> nameMap = employeeList.stream().collect(
				Collectors.toMap(p -> p.getAge(), p -> p.getFirstName(),
						(name1, name2) -> name1 + ";" + name2));

		// System.out.println(nameMap);

		Collector<Employee, StringJoiner, String> employeeNameAgeCollector = Collector
				.of(() -> new StringJoiner(" | "),
						(j, p) -> j.add(p.getFirstName().toUpperCase() + " "
								+ p.getAge()),
						(j1, j2) -> j1.merge(j2), StringJoiner::toString);

		String namesAges = employeeList.stream()
				.collect(employeeNameAgeCollector);

		System.out.println(namesAges);

	}

}
