package com.hrm.testscript;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class splitStringWithoutSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String str = "Today is good day";
		ArrayList<String> lst = new ArrayList<String>();
		char arr[] = str.toCharArray();
		String st ="";
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=' ') {
				st = st+arr[i];
				if(i==arr.length-1)
					lst.add(st);
			}
			else {
				lst.add(st);
				st="";
			}
		}
		for(int i=0;i<lst.size();i++)
		{
			if(!(lst.get(i).equals("good")))
				System.out.println(lst.get(i));
		}
	}
}