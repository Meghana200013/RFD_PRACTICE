package com.rahulshettyAcademy.senarios;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class OccuranceOfString {

	public static void main(String[] args) {
		// example occurance of character using lamda
		String s="Hi Hello kavitha";
		LinkedHashMap<Character, Integer> map= new LinkedHashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			
				map.put(ch, map.getOrDefault(ch, 0)+1);
			
		}
		map.forEach((k,v)->System.out.print(k+""+v+" "));
		map.forEach((k,v)-> {
		if(v>1) {
			System.out.println(k+"=>"+v);
		}
		}
		);
		
		ArrayList< Integer> list =new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(22);
		list.add(14);
		list.forEach(System.out::println);
		
	}
}
