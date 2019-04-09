package com.blog.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListUse {

	 public static void main(String [] args){
		    Scanner sc = new Scanner(System.in);
		    System.out.println("enter num of node");
		    int node = sc.nextInt();
		    System.out.println("enter num of edge");
		    int edge = sc.nextInt();
		    
//		    List< ArrayList<Integer> >   list = new Arraylist<>;
//		    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		    LinkedList<LinkedList<Integer>> list = new LinkedList<>();
		    for(int i=1; i<=node; i++) {
		    	LinkedList<Integer> l = new LinkedList<>();
		    	list.add(l);
//		    	l.addLast(null);
		    	
		    }
//		    System.out.println("enter edge connection");
		    for( int i=0; i<edge; i++) {
		    	System.out.println("enter edge connection");
		        int x = sc.nextInt(), y = sc.nextInt();
		        list.get(x-1).add(y);
		    }
		    for(int i=0; i<list.size() ; i++) {
		    	System.out.println(list.get(i));
		    }
		  }
	
}
