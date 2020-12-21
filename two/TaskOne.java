package Day.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskOne {
	private static String DATAPATH = System.getProperty("user.dir") + "\\src\\Day\\two\\data.txt";
	
	public static void main(String[] args) {
		int numberOfValidPasswd = 0;
		int numberOfValidPositionPasswd = 0;
		String passwd = "";

		try {
			File myObj = new File(DATAPATH);
			Scanner scr = new Scanner(myObj);
			while (scr.hasNextLine()) {
				passwd = scr.nextLine();
				if (validPasswd(passwd) == true) {
					numberOfValidPasswd++;
				}
				if (validPasswdOnPosition(passwd)) {
					numberOfValidPositionPasswd++;
				}
			}
			scr.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		System.out.println(numberOfValidPasswd);
		System.out.println(numberOfValidPositionPasswd);

	}

	public static boolean validPasswd(String passwd) {
		int counter = 0;
		String[] splitPasswd = passwd.split("\\s+");
		String[] treshhold = splitPasswd[0].split("-");
		char help = splitPasswd[1].charAt(0);
		for (int i = 0; i < splitPasswd[2].length(); i++) {
			if (splitPasswd[2].charAt(i) == help) {
				counter++;
			}
		}
		if (counter == 0) {
			return false;
		} else if (counter >= Integer.parseInt(treshhold[0]) && counter <= Integer.parseInt(treshhold[1])) {
			return true;
		} else {

			return false;
		}
	}

	public static boolean validPasswdOnPosition(String passwd) {
		String[] splitPasswd = passwd.split("\\s+");
		String[] treshhold = splitPasswd[0].split("-");

		char help = splitPasswd[1].charAt(0);
		
		if (help == splitPasswd[2].charAt(Integer.parseInt(treshhold[0])-1)
				&& help != splitPasswd[2].charAt(Integer.parseInt(treshhold[1])-1)) {
			return true;
		} else if (help != splitPasswd[2].charAt(Integer.parseInt(treshhold[0])-1)
				&& help == splitPasswd[2].charAt(Integer.parseInt(treshhold[1])-1)) {
			return true;
		} else {
			return false;
		}

	}

}
