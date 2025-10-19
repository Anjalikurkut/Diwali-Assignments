package com.demo.main;

import java.lang.reflect.Array;
import java.util.Iterator;

public class LongestString {
	public static void main(String[] args) {
		
		String str1 []= {"Anjali","Vandana","Bharatkumar","Abhishek","Utkarsha","Anvi"};
		int maxLength=0;
		String longestString ="";
		
		for (String string : str1) {
			if(string.length()> maxLength) {
				maxLength = string.length();
				longestString = string;
			}
		}
		
		System.out.println("Longest String is :"+ longestString);
		System.out.println("Length of Longest String is :" +maxLength);
		
	}
}
