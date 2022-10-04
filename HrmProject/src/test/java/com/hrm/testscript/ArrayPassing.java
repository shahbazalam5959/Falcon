package com.hrm.testscript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayPassing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int arr1[] = new int[]{3,5,6,7};
		int arr2[] = new int[]{8,4,5,3,1};
		
//		List<Integer> intList = new ArrayList<Integer>(arr1.length);
//		List<Integer> intList2 = new ArrayList<Integer>(arr2.length);
//		for (int i : arr1)
//		    intList.add(i);
//		for (int i : arr2)
//		    intList2.add(i);
//		intList.removeAll(intList2);
//		intList.addAll(intList2);
//		Collections.sort(intList);
//		System.out.println(intList);
		
		// How to convert int array to ArrayList of Integer in Java 8?

		ArrayList<Integer> list = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list);
		
	}

}
