package demo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class Demo {
	@Test
	public void getmethod() {
	
		String str = "Bharath";
		//int count =0;
		char[] Char = str.toCharArray();
		
	/*	for(int i=0;i<str.length();i++) {
			
			for(int j=i+1;j<str.length();j++) {
				if(Char[i]==Char[j]) {
					count++;
					System.out.println(count +" duplicate charactes is "+Char[j]);
				}
				//System.out.println(count +" duplicate charactes is "+Char[j]);
			}*/
			
			Map<Character, Integer> map = new HashMap<>();
			for(int a=0;a<Char.length;a++) {
				if(map.containsKey(Char[a])) {
					int count = map.get(Char[a]);
					map.put(Char[a], count+1);
				}else {
					map.put(Char[a],1);
				}
				
			}
			System.out.println(map);
		
			
		}
//String str = "Bharath";
//{a=2, B=1, r=1, t=1, h=2}
	}
	

	

