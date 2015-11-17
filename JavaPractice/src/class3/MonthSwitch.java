package class3;

import java.util.Scanner;

public class MonthSwitch {

	public static void main(String[] args) {
		String monthName;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first three letters of the month");
		monthName = scan.next();
		switch(monthName.toLowerCase()){
		case "jan": case "mar": case "may": case "jul": case "aug": case "oct": case "dec":
			System.out.println(monthName + " has 31 days ");
			break;
		case "apr": case "jun": case "sep": case "nov":
			System.out.println(monthName + " has 30 days ");
			break;
		case "feb":
			System.out.println("Enter the year");
			int year = scan.nextInt();
			int days = (year%4==0)?29:28;
			System.out.println(monthName + " has "+days+" days ");
			break;
		default:
			System.out.println("Invalid Input");			
		}
		scan.close();
	}
}
