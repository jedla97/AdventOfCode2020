package Day.one;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskOne {
	private static String DATAPATH = System.getProperty("user.dir") + "\\src\\Day\\one\\data.txt";
	
	public static void main(String[] args) {
		ArrayList<Integer> expenses = new ArrayList<Integer>();

		try {
			File myObj = new File(DATAPATH);
			Scanner scr = new Scanner(myObj);
			while (scr.hasNextInt()) {
				expenses.add(scr.nextInt());
			}
			scr.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		System.out.println(getMultipliedExpensesForTwoNumbers(expenses));
		System.out.println(getMultipliedExpensesForThreeNumbers(expenses));

	}

	public static int getMultipliedExpensesForTwoNumbers(ArrayList<Integer> expenses) {
		for (int i = 0; i < expenses.size(); i++) {
			for (int j = 0; j < expenses.size(); j++) {
				if (i != j) {
					if (expenses.get(i) + expenses.get(j) == 2020) {
						return expenses.get(i) * expenses.get(j);
					}
				}
			}

		}
		return -1;
	}

	public static int getMultipliedExpensesForThreeNumbers(ArrayList<Integer> expenses) {
		for (int i = 0; i < expenses.size(); i++) {
			for (int j = 0; j < expenses.size(); j++) {
				for (int k = 0; k < expenses.size(); k++) {
					if (i != j && i != k && j != k) {
						if (expenses.get(i) + expenses.get(j) + expenses.get(k) == 2020) {
							return expenses.get(i) * expenses.get(j) * expenses.get(k);
						}
					}
				}
			}

		}
		return -1;
	}
}
