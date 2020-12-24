package Day.six;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskOne {

	private static String DATAPATH = System.getProperty("user.dir") + "\\src\\Day\\six\\data.txt";

	public static void main(String[] args) {
		int yesAnswers = 0;
		int yesAnswersForWholeGroup = 0;

		try {
			File myObj = new File(DATAPATH);
			Scanner scr = new Scanner(myObj);
			String answerData = "";
			String dataOfline = "";
			String answerDataWithSpace = "";

			while (scr.hasNextLine()) {
				dataOfline = scr.nextLine();
				if (dataOfline.trim().isEmpty()) {
					yesAnswers = yesAnswers + getNumberOfYesAnswers(answerData);
					yesAnswersForWholeGroup = yesAnswersForWholeGroup + numberOfSameAnswers(answerDataWithSpace);
					answerData = "";
					answerDataWithSpace = "";
				} else {
					answerData = answerData + dataOfline;
					if (answerDataWithSpace == "") {
						answerDataWithSpace = answerDataWithSpace + dataOfline;
					} else {
						answerDataWithSpace = answerDataWithSpace + " " + dataOfline;
					}
				}

			}
			yesAnswers = yesAnswers + getNumberOfYesAnswers(answerData);
			yesAnswersForWholeGroup = yesAnswersForWholeGroup + numberOfSameAnswers(answerDataWithSpace);
			System.out.println(yesAnswers);
			System.out.println(yesAnswersForWholeGroup);
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

	public static int numberOfSameAnswers(String str) {
		String[] answers = str.split("\\s+");
		boolean flag = true;
		String help;
		int counter = 0;
		for (int i = 0; i < answers[0].length(); i++) {
			help = "";
			flag = true;
			help = help + answers[0].charAt(i);
			for (int j = 1; j < answers.length; j++) {
				if (!answers[j].contains(help)) {
					flag = false;
				}
			}
			if (flag == true) {
				counter++;
			}
		}

		return counter;
	}

}
