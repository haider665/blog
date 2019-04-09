package com.blog.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class HasMapTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 

		Map <String, String> arrayMap = new  HashMap();
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=n ;i++ ) {
			String name =sc.nextLine();
String phone= sc.nextLine();
			arrayMap.put(name, phone);
		}
		while(sc.hasNext()) {
			String asd = sc.nextLine();
			if(arrayMap.containsKey(asd)) {
				System.out.println(asd+"="+ arrayMap.get(asd));
			} else {
				System.out.println("Not found");
			}
		}
		
	}

}
