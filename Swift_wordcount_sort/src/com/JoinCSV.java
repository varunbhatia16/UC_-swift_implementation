package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class JoinCSV {
	public HashMap<String, Integer> func(String filePath)
			throws FileNotFoundException {

		File file = new File(filePath);
		Scanner scan = new Scanner(file);
		HashMap<String, Integer> naruto = new HashMap<String, Integer>();

		while (scan.hasNext()) {
			String[] asd = scan.next().trim().split(",@#");// trim the extra
															// spaces and
			naruto.put(asd[0], Integer.parseInt(asd[1]));
		}
		return naruto;
	}

	public HashMap<String, Integer> merge(HashMap<String, Integer> input1,
			HashMap<String, Integer> input2) {
		
	for (String  string :input2.keySet() ) {
		if(input1.containsKey(string)==true)
		{
			input1.put(string, (input1.get(string)+input2.get(string)));
		//	input2.remove(string);			
		}
		else
		{
			input1.put(string, input2.get(string));
		//	input2.remove(string);	
		}
		
	}	
		return input1;

	}

	public void PrintTable(HashMap<String, Integer> input1) {
	
		for (String string : input1.keySet()) {

			System.out.println(string + ",@#" + input1.get(string));
		}
	}

	/*
	 * for (String string : naruto.keySet()) {
	 * 
	 * System.out.println(string + ",@#" + naruto.get(string)); } }
	 */

	public static void main(String[] args) throws FileNotFoundException {
		JoinCSV jc = new JoinCSV();
		HashMap<String, Integer> ip1 ,ip2,op1;
		ip1= jc.func(args[0]);
		ip2= jc.func(args[1]);
		op1 = jc.merge(ip1,ip2);
		jc.PrintTable(op1);
		

	}

}
