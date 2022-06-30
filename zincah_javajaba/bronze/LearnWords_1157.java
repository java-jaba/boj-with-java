package test01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// น้มุ 1157น๘
public class LearnWords_1157 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String insert = sc.nextLine();
        sc.close();
        
        String result = "";
        
        insert = insert.toUpperCase();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i<insert.length(); i++) {
        	char x = insert.charAt(i);
        	map.put(x, map.getOrDefault(x, 0)+1);
        }
        
        System.out.println(map);
        
        List<Map.Entry<Character, Integer>> sorted = map.entrySet().stream().
        		sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        
        String[] check = String.valueOf(sorted.get(sorted.size()-1)).split("=");
        String[] check2 = new String[2];
        if(sorted.size()>1) {
        	check2 = String.valueOf(sorted.get(sorted.size()-2)).split("=");
        }
        
        if(check2[0] == null) {
        	result = check[0];
        }else {
        	if(Integer.parseInt(check[1])==Integer.parseInt(check2[1])) {
        		result = "?";
        	}else {
        		result = check[0];
        	}
        }

    	System.out.println(result);

		
	}

}
