/**
 * 
 */
package com.assignments.stream.reduce;

import java.util.ArrayList;
import java.util.List;

import com.assignments.stream.Employee;

/**
 * @author Somendu
 *
 * @since 14-Sep-2020
 */
public class LearnReduce {

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

		employeeList.stream()
				.reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
				.ifPresent(System.out::println);

		Employee result = employeeList.stream()
				.reduce(new Employee(0, "", 0, 0), (p1, p2) -> {
					p1.age += p2.getAge();
					p1.firstName += p2.getFirstName();
					return p1;
				});

		System.out.format("name=%s; age=%s", result.firstName, result.age);

		Integer ageSum = employeeList.stream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			return sum += p.age;
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});

		Integer ageSumParallel = employeeList.parallelStream().reduce(0,
				(sum, p) -> {
					System.out.format(
							"accumulator parallelStream: sum=%s; person=%s\n",
							sum, p);
					return sum += p.age;
				}, (sum1, sum2) -> {
					System.out.format(
							"combiner parallelStream: sum1=%s; sum2=%s\n", sum1,
							sum2);
					return sum1 + sum2;
				});
	}

}
