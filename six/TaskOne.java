package Day.six;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskOne {
	
	private static String DATAPATH = System.getProperty("user.dir") + "\\src\\Day\\six\\data.txt";

	public static void main(String[] args) {
		int yesAnswers = 0;
		
		try {
			File myObj = new File(DATAPATH);
			Scanner scr = new Scanner(myObj);
			String answerData = "";
			String dataOfline = "";

			while (scr.hasNextLine()) {
				dataOfline = scr.nextLine();
				if (dataOfline.trim().isEmpty()) {	
					yesAnswers = yesAnswers + getNumberOfYesAnswers(answerData);
					answerData = "";
				} else {
					answerData = answerData + dataOfline;
				}
				
			}
			yesAnswers = yesAnswers + getNumberOfYesAnswers(answerData);
			System.out.println(yesAnswers);
			scr.close();
			

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		


	}
	
	public static int getNumberOfYesAnswers(String str) {
		ArrayList<Character> characters = new ArrayList<Character>();
		int counter = 0;
		char help;
		for (int i = 0; i < str.length(); i++) {
			help = str.charAt(i);
			if (!characters.contains(help)) {
				counter++;
				characters.add(help);
			}
		}
		
		return counter;
	}

}
