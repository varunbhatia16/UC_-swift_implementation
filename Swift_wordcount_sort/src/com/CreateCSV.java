package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CreateCSV {
	public void func(String filePath) throws FileNotFoundException {

		File file = new File(filePath);

		Scanner scan = new Scanner(file);

		// System.out.println("this is the file path"+file.getAbsolutePath());

		HashMap<String, Integer> naruto = new HashMap<String, Integer>();

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
				// saskue.add(string);
			}
		}
		for (String string : naruto.keySet()) {

			System.out.println(string + ",@#" + naruto.get(string));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		CreateCSV csv = new CreateCSV();
		csv.func(args[0]);

	}
}