package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringJoinerExamples {

	public static void main(String[] args) {
		final String PREFIX = "[";
		final String SUFFIX = "]";
		
		StringJoiner joiner1 = new StringJoiner(",");
		joiner1.setEmptyValue("default");
		System.out.println(joiner1);
		
		StringJoiner joiner2 = new StringJoiner(",", PREFIX, SUFFIX);
		//joiner2.setEmptyValue("default");
		//System.out.println(joiner2);
		joiner2.add("Red").add("Green").add("Blue");
		System.out.println(joiner2);
		System.out.println(joiner2.toString());
		System.out.println(joiner2.length());
		
		StringJoiner joiner3 = new StringJoiner("-", "{", "}");    
        joiner3.add("Logan").add("Magneto").add("Rogue").add("Storm");  
        System.out.println(joiner3); 
        
        //joiner2.merge(joiner3);
        //System.out.println(joiner2);
        
        joiner3.merge(joiner2);
        System.out.println(joiner3);
        
        List<String> rgbList = Arrays.asList("Red", "Green", "Blue");
        String s = rgbList.stream().map(Function.identity()).collect(Collectors.joining());
        System.out.println(s);
        s = rgbList.stream().map(Function.identity()).collect(Collectors.joining(","));
        System.out.println(s);
        s = rgbList.stream().map(Function.identity()).collect(Collectors.joining("-","{", "}"));
        System.out.println(s);
	}

}
