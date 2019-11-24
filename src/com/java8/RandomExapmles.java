package com.java8;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomExapmles {

	public static void main(String[] args) {
		Random r = new Random();
		List<Double> listDouble1 = r.doubles(5, 0, 5).boxed().collect(Collectors.toList());
		System.out.println(listDouble1);
		listDouble1 = r.doubles().limit(3).boxed().collect(Collectors.toList());
		System.out.println(listDouble1);
		listDouble1 = r.doubles(3).boxed().collect(Collectors.toList());
		System.out.println(listDouble1);
		listDouble1 = r.doubles(10, 15).limit(3).boxed().collect(Collectors.toList());
		System.out.println(listDouble1);
		List<Integer> listInteger1 = r.ints(5, -2, 3).boxed().collect(Collectors.toList());
		System.out.println(listInteger1);
		listInteger1 = r.ints().limit(5).boxed().collect(Collectors.toList());
		System.out.println(listInteger1);
		listInteger1 = r.ints(5).boxed().collect(Collectors.toList());
		System.out.println(listInteger1);
		listInteger1 = r.ints(100, 150).limit(5).boxed().collect(Collectors.toList());
		System.out.println(listInteger1);
		List<Long> listLong1 = r.longs(5, 25, 75).boxed().collect(Collectors.toList());
		System.out.println(listLong1);
		listLong1 = r.longs().limit(5).boxed().collect(Collectors.toList());
		System.out.println(listLong1);
		listLong1 = r.longs(5).boxed().collect(Collectors.toList());
		System.out.println(listLong1);
		listLong1 = r.longs(25, 75).limit(5).boxed().collect(Collectors.toList());
		System.out.println(listLong1);
		boolean bol = r.nextBoolean();
		System.out.println(bol);
		byte[] bytes = new byte[5];
		r.nextBytes(bytes);
		for (byte b : bytes)
			System.out.print(b + " ");
		System.out.println();
		double d = r.nextDouble();
		System.out.println(d);
		float f = r.nextFloat();
		System.out.println(f);
		double gaussian = r.nextGaussian();
		System.out.println(gaussian);
		int int1 = r.nextInt();
		System.out.println(int1);
		int int2 = r.nextInt(10);
		System.out.println(int2);
		long l = r.nextLong();
		System.out.println(l);
		
	}

}
