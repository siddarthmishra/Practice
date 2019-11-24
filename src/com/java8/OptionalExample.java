package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OptionalExample {

	public static void main(String[] args) {
		String[] str = new String[10];
		try {
			String str2 = str[9].substring(2, 5);
			System.out.print(str2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Optional<String> opString = Optional.ofNullable(str[9]);
		if (opString.isPresent())
			System.out.println(str[9].substring(2, 5));
		else
			System.out.println("Empty String");

		str[9] = "ABCDEFGHI";
		opString = Optional.ofNullable(str[9]);
		if (opString.isPresent())
			System.out.println(str[9].substring(2, 5));
		else
			System.out.println("Empty String");

		Optional<Integer> empty = Optional.empty();
		System.out.println("empty() isEmpty : " + empty.isEmpty());
		System.out.println("empty() isPresent : " + empty.isPresent());

		Optional<Integer> of = Optional.of(5);
		System.out.println("of() isEmpty : " + of.isEmpty());
		System.out.println("of() isPresent : " + of.isPresent());
		try {
			@SuppressWarnings("unused")
			Optional<Integer> ofNull = Optional.of(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Optional<Integer> ofNullable1 = Optional.ofNullable(null);
		System.out.println("ofNullable() isEmpty : " + ofNullable1.isEmpty());
		System.out.println("ofNullable() isPresent : " + ofNullable1.isPresent());
		Optional<Integer> ofNullable2 = Optional.ofNullable(5);
		System.out.println("ofNullable() isEmpty : " + ofNullable2.isEmpty());
		System.out.println("ofNullable() isPresent : " + ofNullable2.isPresent());
		Optional<String> name = Optional.of("Nikki-Sid");
		name.ifPresent(s -> System.out.println(s.length()));
		Optional<String> nullName = null;
		name = Optional.ofNullable(nullName).orElse(name);
		name.ifPresent(System.out::println);
		name = Optional.ofNullable(nullName).orElseGet(() -> Optional.of("Nikki-Sid"));
		name.ifPresent(System.out::println);
		System.out.println("============================================================");
		Supplier<Optional<String>> supplier = OptionalExample::getMyDefault;
		System.out.println("Using orElseGet:");
		name = Optional.ofNullable(nullName).orElseGet(supplier);
		name.ifPresent(System.out::println);
		System.out.println("Using orElse:");
		name = Optional.ofNullable(nullName).orElse(supplier.get());
		name.ifPresent(System.out::println);
		System.out.println("============================================================");
		nullName = Optional.of("Text present");
		System.out.println("Using orElseGet:");
		name = Optional.ofNullable(nullName).orElseGet(supplier);
		name.ifPresent(System.out::println);
		System.out.println("Using orElse:");
		name = Optional.ofNullable(nullName).orElse(supplier.get());
		name.ifPresent(System.out::println);
		System.out.println("============================================================");
		nullName = null;
		try {
			name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			name = Optional.ofNullable(nullName).orElseThrow();
		} catch (Exception e) {
			e.printStackTrace();
		}
		name = Optional.of("Nikki-Sid");
		String nameString = name.get();
		System.out.println(nameString);
		try {
			Integer emptyInt = empty.get();
			System.out.println(emptyInt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer yr = Integer.valueOf(2019);
		Optional<Integer> year = Optional.of(yr);
		System.out.println(year.filter(y -> y == 2019).isPresent());
		System.out.println(year.filter(y -> y == 2020).isPresent());
		List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
		Optional<List<String>> listOptional = Optional.of(companyNames);
		System.out.println(listOptional.map(List::size).orElseGet(() -> 0));
		List<String> nameList = Arrays.asList("Chetan", "Nikku", "Siddarth", "Nikki", "Nikhita");
		Optional<List<String>> nameOptional = Optional.of(nameList);
		System.out.println(nameOptional.map(l -> l.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()))
				.orElseGet(() -> new ArrayList<String>()));
		String password = " password ";
		Optional<String> passOpt = Optional.of(password);
		boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();
		System.out.println(correctPassword);
		correctPassword = passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();
		System.out.println(correctPassword);
		Person person = new Person("john", 26);
		Optional<Person> personOptional = Optional.of(person);
		Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
		Optional<String> nameOptional1 = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
		nameOptional1.ifPresent(System.out::println);

		String name1 = personOptional.flatMap(Person::getName).orElse("");
		System.out.println(name1);
	}

	public static Optional<String> getMyDefault() {
		System.out.println("Getting Default Value");
		return Optional.of("Default Value");
	}

}

class Person {
	private String name;
	private int age;
	private String password;

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public Optional<Integer> getAge() {
		return Optional.ofNullable(age);
	}

	public Optional<String> getPassword() {
		return Optional.ofNullable(password);
	}

	// normal constructors and setters
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
