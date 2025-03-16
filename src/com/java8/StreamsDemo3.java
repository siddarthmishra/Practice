package com.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo3 {

	public static void main(String[] args) throws Throwable {
		
		List<Integer> i1 = List.of(0, 1, 2, 3, 4, 5, 6);
		List<Integer> i2 = List.of(4, 5, 6, 7, 8, 9, 0);
		// Find intersection of the above lists

		List<Integer> result = i1.stream().filter(ii1 -> i2.stream().anyMatch(ii2 -> ii2 == ii1)).distinct().toList();
		System.out.println(result);
		List<Employee> employees = getEmployees();
		Comparator<Employee> c = (e1, e2) -> {
			if (e1.getFirstName().compareTo(e2.getFirstName()) < 0) {
				return -1;
			} else if (e1.getFirstName().compareTo(e2.getFirstName()) > 0) {
				return 1;
			} else if (e1.getLastName().compareTo(e2.getLastName()) < 0) {
				return -1;
			} else if (e1.getLastName().compareTo(e2.getLastName()) > 0) {
				return 1;
			}

			return 0;
		};
		// filter out duplicate, then sort by first name and then by last name
		System.out.println("==========================");
		System.out.println("result2");
		Collection<Employee> result2 = employees.stream().sorted(c).collect(Collectors.collectingAndThen(
				Collectors.toMap(Employee::getId, Function.identity(), (oldVal, newVal) -> newVal, LinkedHashMap::new),
				map -> map.values()));
		result2.forEach(System.out::println);
		System.out.println("==========================");
		System.out.println("result3");
		List<Employee> result3 = employees.stream()
				.collect(Collectors.collectingAndThen(
						Collectors.toMap(Employee::getId, Function.identity(), (oldVal, newVal) -> newVal),
						employeeMap -> employeeMap.values().stream().sorted(c).toList()));
		result3.forEach(System.out::println);
		System.out.println("==========================");
		System.out.println("result4");
		List<Employee> result4 = employees.stream().collect(Collectors.collectingAndThen(
				Collectors.toMap(Employee::getId, Function.identity(), (oldVal, newVal) -> newVal),
				employeeMap -> employeeMap.values().stream()
						.sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName))
						.toList()));
		result4.forEach(System.out::println);
		System.out.println("==========================");
	}

	private static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(2, "Sunny", "Deol"));
		employees.add(new Employee(3, "Ranbir", "Kapoor"));
		employees.add(new Employee(5, "Rohit", "Sharma"));
		employees.add(new Employee(6, "Rohit", "Shetty"));
		employees.add(new Employee(1, "Abhi", "Bachhan"));
		employees.add(new Employee(1, "Abhi", "Bachhan"));
		employees.add(new Employee(4, "Abhi", "Agarwal"));
		employees.add(new Employee(3, "Ranbir", "Kapoor"));
		return employees;
	}
}

class Employee {
	private Integer id;
	private String firstName;
	private String lastName;

	public Employee(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public Integer getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
