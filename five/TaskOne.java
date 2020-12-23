package Day.five;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskOne {
	private static ArrayList<Integer> ticketID=  new ArrayList<Integer>();
	private static String DATAPATH = System.getProperty("user.dir") + "\\src\\Day\\five\\data.txt";

	public static void main(String[] args) {
		int actual = 0;
		int max = 0;
		String seat = "";
		try {
			File myObj = new File(DATAPATH);
			Scanner scr = new Scanner(myObj);
			while (scr.hasNextLine()) {
				seat = scr.nextLine();
				actual = getSeatID(seat);
				ticketID.add(actual);
				max = biggerID(max, actual);
			}
			scr.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println(max);
		System.out.println(findIDOfMyTicket());
	}

	public static int biggerID(int max, int actual) {
		if (max >= actual) {
			return max;
		} else {
			return actual;
		}
	}

	public static int getSeatID(String str) {
		int row;
		int column;
		if (str.matches("[F|B]{7}[R|L]{3}")) {
			String[] rowAndColumn = getRowAndColumn(str);
			row = getRow(rowAndColumn[0]);
			column = getcolumn(rowAndColumn[1]);
			return row * 8 + column;

		} else {
			System.out.println("fail");
		}

		return 0;
	}

	public static String[] getRowAndColumn(String str) {
		String row = "";
		String column = "";
		for (int i = 0; i < str.length(); i++) {
			if (i < 7) {
				row = row + str.charAt(i);
			} else {
				column = column + str.charAt(i);
			}
		}
		String[] ret = { row, column };
		return ret;
	}

	public static int getRow(String str) {
		ArrayList<Integer> half = new ArrayList<Integer>();
		half.add(64);
		half.add(32);
		half.add(16);
		half.add(8);
		half.add(4);
		half.add(2);
		int min = 0;
		int max = 127;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'F') {
				max = max - half.get(i);
			} else if (str.charAt(i) == 'B') {
				min = min + half.get(i);
			} else {
				return 0;
			}
		}
		if (str.charAt(6) == 'B') {
			return max;
		} else if (str.charAt(6) == 'F') {
			return min;
		} else {
			return 0;
		}
	}

	public static int getcolumn(String str) {
		ArrayList<Integer> half = new ArrayList<Integer>();
		half.add(4);
		half.add(2);
		int min = 0;
		int max = 7;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'L') {
				max = max - half.get(i);
			} else if (str.charAt(i) == 'R') {
				min = min + half.get(i);
			} else {
				return 0;
			}
		}
		if (str.charAt(2) == 'R') {
			return max;
		} else if (str.charAt(2) == 'L') {
			return min;
		} else {
			return 0;
		}
	}

	public static int findIDOfMyTicket() {
		//ticketID;
		ArrayList<Integer> arrUp = new ArrayList<Integer>();
		ArrayList<Integer> arrDown = new ArrayList<Integer>();
		for (int i = 0; i < ticketID.size(); i++) {
			arrUp.add(ticketID.get(i)+1);
			arrDown.add(ticketID.get(i)-1);
		}
		
		
		for (int i = 0; i < arrUp.size(); i++) {
			if(arrDown.contains(arrUp.get(i)) && !arrDown.contains(ticketID.get(i))) {
				return arrUp.get(i);
			}
		}
		return 0;
	}

}
