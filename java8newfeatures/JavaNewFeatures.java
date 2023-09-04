package com.java8newfeatures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class JavaNewFeatures {
	public static void main(String[] args) {
		LinkedList <String> list1 = new LinkedList<String>();
		list1.add("Ajitha");
		list1.add("Bujji");
		list1.add("Ajitha");
		list1.add("saranya");
		list1.add("Eurekha");
		Iterator itr=list1.iterator();  
		while(itr.hasNext())
		{  
		System.out.println(itr.next());
		}  
		ArrayList<String> list2 =new ArrayList<String>();
		list2.add("aaa");
		list2.add("bbb");
		list2.add("ccc");
		Iterator ltr1 = list2.iterator();
		while(ltr1.hasNext());
		{
			System.out.println(ltr1.next());
		}
	}
}
