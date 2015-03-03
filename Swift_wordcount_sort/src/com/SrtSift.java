package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SrtSift {
	static long start;

	public void func(String filePath) {

		
		File file = new File(filePath);
		Scanner scan;
		try {
			scan = new Scanner(file);
			ArrayList<String> tempList = new ArrayList<String>();

			while (scan.hasNext()) {
				String[] asd = scan.next().trim().split(" ");// trim the extra
																// spaces and

				for (String string : asd) {
					tempList.add(string);
				}

			}
			
			
			Collections.sort(tempList);// sorting of the list is done
			
			for (String string : tempList) {
				System.out.println(string);
			}
		//	System.out.println("done");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		SrtSift wrdCount = new SrtSift();
		wrdCount.func(args[0]);

		long end = System.nanoTime();
		double latency = end - start;
		double x = Math.pow(10, 9);
		float latency_sec = (float) ((float) latency / x);
		float latency_min = latency_sec / 60;
		float latency_hr = latency_min / 60;
		System.out.println(latency_sec + "\tseconds");
		System.out.println(latency_min + "\tminutes");
		System.out.println(latency_hr + "\thours");
	}
}
