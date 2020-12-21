package Day.four;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaksOne {

	private static String DATAPATH = System.getProperty("user.dir") + "\\src\\Day\\four\\data.txt";

	private static int counterFalse = 0;
	private static int validPassports = 0;
	private static int validPassportsByData = 0;

	public static void main(String[] args) {

		boolean flag = true;
		String value[] = "hgt:193cm".split(":");
		if (value[0].contains("hgt")) {
			if (value[1].matches("^([0-9]{3}|[0-9]{2}|[0-9]{1})[cm|in]{2}")) {
				String help = value[1].replaceFirst("[^0-9]+", "");
				if (value[1].contains("cm")) {
					if (Integer.parseInt(help) <= 193 && Integer.parseInt(help) >= 150) {
					} else {
						flag = false;
					}
				} else if (value[1].contains("in")) {
					if (Integer.parseInt(help) <= 76 && Integer.parseInt(help) >= 59) {
					} else {
						flag = false;
					}
				} else {
					flag = false;
				}
			} else {
				flag = false;
			}

		}

		System.out.println(flag);

		try {
			File myObj = new File(DATAPATH);
			Scanner scr = new Scanner(myObj);
			String passportData = "";
			String dataOfline = "";

			while (scr.hasNextLine()) {
				dataOfline = scr.nextLine();
				if (dataOfline.trim().isEmpty()) {
					isValid(passportData);
					passportData = "";
				} else {
					if (passportData == "") {
						passportData = passportData + dataOfline;
					} else {
						passportData = passportData + " " + dataOfline;
					}
				}
			}
			isValid(passportData);
			scr.close();
			System.out.println(validPassports);
			System.out.println(validPassportsByData);
			System.out.println(counterFalse);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static void isValid(String data) {
		List<String> required = Arrays.asList("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:");
		boolean flag = true;
		for (int i = 0; i < required.size(); i++) {
			if (!data.contains(required.get(i))) {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			isValidByData(data);
			validPassports++;
		}
	}

	public static void isValidByData(String data) {

		List<String> required = Arrays.asList("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:");
		boolean flag = true;
		String passdata[] = data.split("\\s+");

		for (int i = 0; i < required.size(); i++) {
			if (flag == false) {
				break;
			}
			for (int j = 0; j < passdata.length; j++) {
				if (passdata[j].contains(required.get(i))) {
					String value[] = passdata[j].split(":");
					if (value[0].contains("byr")) {
						if (Integer.parseInt(value[1]) <= 2002 && Integer.parseInt(value[1]) >= 1920) {
						} else {
							flag = false;
							break;
						}
					} else if (value[0].contains("iyr")) {
						if (Integer.parseInt(value[1]) <= 2020 && Integer.parseInt(value[1]) >= 2010) {
						} else {
							flag = false;
							break;
						}
					} else if (value[0].contains("eyr")) {
						if (Integer.parseInt(value[1]) <= 2030 && Integer.parseInt(value[1]) >= 2020) {
						} else {
							flag = false;
							break;
						}
					} else if (value[0].contains("hgt")) {
						if (value[1].matches("^([0-9]{3}|[0-9]{2})[cm]{2}")) {
							String help = value[1].replaceFirst("[^0-9]+", "");
							if (Integer.parseInt(help) <= 193 && Integer.parseInt(help) >= 150) {
							} else {
								flag = false;
								break;
							}

						} else if (value[1].matches("^([0-9]{3}|[0-9]{2})[in]{2}")) {
							String help = value[1].replaceFirst("[^0-9]+", "");
							if (Integer.parseInt(help) <= 76 && Integer.parseInt(help) >= 59) {
							} else {
								flag = false;
								break;
							}
						}

						else {
							flag = false;
							break;
						}

					} else if (value[0].contains("hcl")) {
						if (!value[1].matches("^#[0-9a-fA-f]{6}")) {
							flag = false;
							break;
						}
					} else if (value[0].contains("ecl")) {
						if (!value[1].matches("amb|blu|hzl|brn|gry|grn|oth")) {
							flag = false;
							break;
						}
					} else if (value[0].contains("pid")) {
						if (!value[1].matches("^[0-9]{9}")) {
							flag = false;
							break;
						}
					}
				}
			}
		}
		if (flag == true) {
			validPassportsByData++;
		}

	}
}
