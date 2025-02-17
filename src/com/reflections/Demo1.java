package com.reflections;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> c = Class.forName("com.reflections.C");
		logSuperClassAndInterfaces(c);
	}

	private static void logSuperClassAndInterfaces(Class<?> c) {
		if (c == null || "java.lang.Object".equals(c.getName())) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		if (c.isInterface()) {
			sb.append("interface ");
		} else {
			sb.append("class ");
		}
		sb.append(c.getSimpleName());
		Class<?> superClass = c.getSuperclass();

		if (superClass != null && !"java.lang.Object".equals(superClass.getName())) {
			sb.append(" extends ").append(superClass.getSimpleName());
		}
		Class<?>[] interfaces = c.getInterfaces();
		if (interfaces != null && interfaces.length > 0) {
			if (c.isInterface()) {
				sb.append(" extends ");
			} else {
				sb.append(" implements ");
			}
		}
		String interfacesString = Arrays.stream(interfaces).filter(Objects::nonNull).map(c1 -> c1.getSimpleName())
				.collect(Collectors.joining(", "));
		if (interfacesString != null && !interfacesString.isEmpty()) {
			sb.append(interfacesString);
		}
		System.out.println(sb.toString());
		if (superClass != null) {
			logSuperClassAndInterfaces(superClass);
		}
		if (interfaces != null && interfaces.length > 0) {
			Arrays.stream(interfaces).filter(Objects::nonNull).forEach(Demo1::logSuperClassAndInterfaces);
		}
	}
}

interface I1 {
}

interface I2 {
}

interface I3 extends I4, I5 {
}

interface I4 {
}

interface I5 {
}

class A implements I1 {
}

class B extends A {
}

class C extends B implements I2, I3 {
}
