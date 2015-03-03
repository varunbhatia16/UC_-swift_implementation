package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WrdCount  {
	public void func() {

		String filePath;
		Scanner in = new Scanner(System.in);

		System.out.println("Please enter the file path");
		filePath = in.nextLine();

		File file = new File(filePath);
		Scanner scan;
		try {
			scan = new Scanner(file);
			System.out.println("reading the file");
			HashMap<String, Integer> naruto = new HashMap<String, Integer>();

			Set<String> saskue = new HashSet<String>();

			while (scan.hasNext()) {
				String[] asd = scan.next().trim().split(" ");// trim the extra
																// spaces and

				for (String string : asd) {

					// adding to a hash map
					if (naruto.containsKey(string)) {
						// if the value exist in the hash map then add to the
						// list.
						naruto.put(string, (naruto.get(string) + 1));
					} else {
						// adding new value to the hash set
						naruto.put(string, 1);
					}
					// adding to a list
					saskue.add(string);
				}

			}
			PrintWriter writer;
			try {
				writer = new PrintWriter("output.txt", "UTF-8");

				ArrayList<String> tempList = new ArrayList<String>(saskue);
				Collections.sort(tempList);// sorting of the list is done

				for (String string : tempList) {
					writer.println(string + "\t:" + naruto.get(string));
					// System.out.println(string + "\t:" + naruto.get(string));
				}
				writer.close();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.err.println("Exception occured while creating file");
			}
			System.out.println("done");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		long start = System.nanoTime();

		WrdCount wrdCount = new WrdCount();
		wrdCount.func();

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