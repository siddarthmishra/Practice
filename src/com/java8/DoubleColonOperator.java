package com.java8;

public class DoubleColonOperator {

	public static void main(String[] args) {
		DoubleColonOperator o = new DoubleColonOperator();
		Interf i = o::m2;
		System.out.println(i.get().getClass().getName());
		Interf i2 = DoubleColonOperator::new;
		System.out.println(i2.get().getClass().getName());
	}

	private DoubleColonOperator m2() {
		System.out.println("Method Reference : ");
		// return new ArrayList<Integer>();
		// return new StringBuffer("1");
		// return "1";
		return new DoubleColonOperator();
	}
}

@FunctionalInterface
interface Interf {
	DoubleColonOperator get();
}
