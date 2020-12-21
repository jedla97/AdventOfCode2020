package Day.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskOne {

	private static String DATAPATH = System.getProperty("user.dir") + "\\src\\Day\\three\\data.txt";

	private static long numberOfTrees = 0;

	public static void main(String[] args) {
		//int[] horizontal = { 1, 3, 5, 7, 1 };
		//int[] vertical = { 1, 1, 1, 1, 2 };
		numberOfTrees();

		System.out.println(numberOfTrees);
	}

	public static void numberOfTrees() {

		try {
			File myObj = new File(DATAPATH);
			Scanner scr = new Scanner(myObj);
			int counter = 0;
			String row = "";
			int steps1 = 0;
			int steps2 = 0;
			int steps3 = 0;
			int steps4 = 0;
			int steps5 = 0;
			long numberOfTrees1 = 0;
			long numberOfTrees2 = 0;
			long numberOfTrees3 = 0;
			long numberOfTrees4 = 0;
			long numberOfTrees5 = 0;

			while (scr.hasNextLine()) {
				if (counter != 0) {
					row = scr.nextLine();
					steps1 = steps1 + 1;
					steps2 = steps2 + 3;
					steps3 = steps3 + 5;
					steps4 = steps4 + 7;
					if (goRigthAndDown(row, steps1) == true) {
						numberOfTrees1++;
					}
					if (goRigthAndDown(row, steps2) == true) {
						numberOfTrees2++;
					}
					if (goRigthAndDown(row, steps3) == true) {
						numberOfTrees3++;
					}
					if (goRigthAndDown(row, steps4) == true) {
						numberOfTrees4++;
					}

					if (counter % 2 == 0) {
						steps5 = steps5 + 1;
						if (goRigthAndDown(row, steps5) == true) {
							numberOfTrees5++;
						}
					}
				} else {
					scr.nextLine();
				}
				counter++;
			}
			scr.close();

			System.out.println(numberOfTrees1);
			System.out.println(numberOfTrees2);
			System.out.println(numberOfTrees3);
			System.out.println(numberOfTrees4);
			System.out.println(numberOfTrees5);

			numberOfTrees = numberOfTrees1 * numberOfTrees2 * numberOfTrees3 * numberOfTrees4 * numberOfTrees5;

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static boolean goRigthAndDown(String str, int steps) {
		if (str.charAt(steps % 31) == '#') {
			return true;
		}
		return false;
	}
}
