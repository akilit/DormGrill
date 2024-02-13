package designProject;

import java.util.Random;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

class PreProgramClass {

	private Scanner askStuID = new Scanner(System.in);
	private double[][] inputs;
	private int numOfStudents = 0;
	private int StudentID = 0;
	private int inputPassword = 0;
	private int password = 0;
	private int roomNum = 0;
	private double tabAmount = 0;

	public void setArray(int numOfStudents) 
	{
		inputs = new double[numOfStudents][4];
	}

	public double[][] arrayInputs() // ---> FILLS 2D ARRAY WITH STUDENT ID, PASSWORD, ROOM #, and TAB AMOUNT
	{ 							   

		for (int row = 0; row < inputs.length; row++) {
			for (int col = 0; col < inputs[0].length; col++) {
				if (col == 0) // Student ID
				{
					askStuID = new Scanner(System.in);
					System.out.println("Enter Student ID: ");
					int StudentID = askStuID.nextInt();
					inputs[row][0] = StudentID;

				}

				if (col == 1) // Password
				{
					System.out.println("Press 1 to create a password. Press any other number for a generated password");
					inputPassword = askStuID.nextInt();

					if (inputPassword == 1)

					{
						askStuID = new Scanner(System.in);
						System.out.println("Create 9 digit numeric password: ");
						password = askStuID.nextInt();
						inputs[row][1] = password;
					}

					else {
						password = randomRange(100000000, 900000000);
						System.out.println("Your password is: " + password + "\n");
						inputs[row][1] = password;
					}

				}

				if (col == 2) // Room #

				{
					askStuID = new Scanner(System.in);
					System.out.println("Type in your room number: ");
					roomNum = askStuID.nextInt();
					inputs[row][2] = roomNum;
				}

				if (col == 3) // Tab Amount
				{
					askStuID = new Scanner(System.in);
					System.out.println("Enter current tab level: ");
					tabAmount = askStuID.nextDouble();
					inputs[row][3] = tabAmount;

				}

			} // ---> End of column loop

		} // ---> End of row for loop

		return inputs;

	}

	public static int randomRange(int min, int max) { // ---> RETURNS A NUMBER BETWEEN A CERTAIN RANGE. METHOD IS CALLED BETWEEN RANGE OF 100000000 AND 900000000.
													 

		int rand = min + (int) (Math.random() * ((max - min) + 1));

		return rand;
	}

	public boolean loginCheck() { // ------> Prompts the user for ID and password, and checks to see if their information is correct.
								 

		boolean passCheck;

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\nLOGIN PAGE\n");
		System.out.println("Type in Student ID:");
		StudentID = sc.nextInt();

		sc = new Scanner(System.in);
		System.out.println("Type in password:");
		password = sc.nextInt();

		passCheck = userPassCheck(StudentID, password); // ------> Calls userPassCheck and returns value as boolean. If true, password is correct, if not password is incorrect
		if (passCheck == false) {
			System.out.println("Password Incorrect! Try Again. ");
			return false;
		}

		else {
			System.out.println("Logged on!\n");
			return true;
		}

	}

	public void tabOrMenu() // --------> Returns no value. Displays either the current tab, the pizza menu,or the Dorm Grill Menu.
	{ 					   // We worked on this method together.
		int input = 0;
		int checker = 0;
		double temp = 0;
		double sum = 0;
		int end = 0;
		int counter = 0;
		double grillSum = 0;
		double grillTemp = 0;

		Scanner askNum = new Scanner(System.in);

		double[] grillPrices = { 0.20, 0.50, 0.75, 1.00, 1.50, 1.50, 1.50, 1.50, 2.00, 2.00, 2.00, 2.50, 0 };
		String[] grillMenu = { "1) Pizza Rolls (each): $", "2) Fruit Roll-Ups: $", "3) Pop Tarts: $", "4) Goldfish: $",
								"5) Soda: $", "6) Potato Chips: $", "7) Gatorade: $", "8) Candy: $", "9) Klondike Bars: $",
								"10) Hot Pockets: $", "11) Protein Bars: $", "12) Protein Shakes: $" }; // Keep order of prices and menu

		while (input != 10) {

			System.out.println(
					"What would you like to do? Press 1 to check Dorm Tab. Press 2 to see Pizza menu. Press 3 to see Grill Menu. Press 10 to log out.");
			input = askNum.nextInt();

			while ((input != 1 && input != 2 && input != 3 && input != 10)) {

				System.out.println("Invalid input. Try again.");
				askNum = new Scanner(System.in);
				input = askNum.nextInt();

			}

			if (input == 1) {
				int rwNum = 0;

				for (int row = 0; row < inputs.length; row++) {
					if (inputs[row][0] == StudentID) {
						rwNum = row;
						System.out.print("Tab is at: " + inputs[rwNum][3] + "\n\n");

						if (inputs[rwNum][3] <= -10) // ---> Managers can set this value to as low or high as they want.
							System.out.println("\nRepay your managers and get your tab positive!\n");
					}
				}
			}

			if (input == 2) {

				double[] pizzaPrice = { 2.50, 2.00, 1.50, 0 };
				String[] pizzaMenu = { "1) Sausage: $", "2) Pepperoni: $", "3) Cheese: $" };

				for (int x = 0; x < pizzaMenu.length; x++) {
					System.out.println(pizzaMenu[x] + pizzaPrice[x]);
				}

				System.out.println(
						"\nType in the number next to item you would like. Press enter after each item. Enter 4 when you are done.");

				while (input == 1 || input == 2 || input == 3) {

					askNum = new Scanner(System.in);
					input = askNum.nextInt();
					sum = sum + temp;

					while ((input != 1 && input != 2 && input != 3 && input != 4)) {
						temp = temp;
						System.out.println("Invalid number. Try again. Enter 4 if you are done.");
						askNum = new Scanner(System.in);
						input = askNum.nextInt();

					}

					temp = (pizzaPrice[input - 1]);

				}

				System.out.println("Your total is: $" + sum);

				for (int row = 0; row < inputs.length; row++) {
					if (inputs[row][0] == StudentID) {

						int rwNum = 0;
						rwNum = row;
						System.out.print("Your tab is now at: $" + (inputs[rwNum][3] - sum) + "\n\n");

						inputs[rwNum][3] = inputs[rwNum][3] - sum;
					}

				}
			}

			if (input == 3) {
				for (int x = 0; x < grillMenu.length; x++) {
					System.out.println(grillMenu[x] + grillPrices[x]);

				}

				System.out.println(
						"\nType in the number next to item you would like. Press enter after each item. Enter 13 when you are done.");

				while (input != 13) {
					askNum = new Scanner(System.in);
					input = askNum.nextInt();

					while ((input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != 6
							&& input != 7 && input != 8 && input != 9 && input != 10 && input != 11 && input != 12
							&& input != 13)) {

						System.out.println("Invalid number. Try again. Enter 13 if you are done.");
						askNum = new Scanner(System.in);
						input = askNum.nextInt();

					}

					grillSum = grillSum + grillTemp;
					grillTemp = (grillPrices[input - 1]);

				}

				System.out.println("Your total is: $" + grillSum);

				for (int row = 0; row < inputs.length; row++) {
					if (inputs[row][0] == StudentID) {

						int rwNum = 0;
						rwNum = row;
						System.out.print("Your tab is now at: $" + (inputs[rwNum][3] - grillSum) + "\n\n");

						inputs[rwNum][3] = inputs[rwNum][3] - grillSum;
					}

				}
			}
		}

	}

	public void exportArray() throws IOException { // ----> EXPORTS OUR DATA FILLED ARRAY LOCALLY ON HARD DRIVE THEN TO THE CLOUD.
												  
		System.out.println("exporting array");

		File exportArray = new File(
				"/Users/akilitulloch/Desktop/CompSci/CompSciArray.csv");
				
		exportArray.createNewFile();  //Returns true if no file under name in file location

		PrintWriter print = new PrintWriter(exportArray); //Instantiating PrintWriter class

		print.write("Student ID,Password (encryted),Room Number,Tab Level\n"); //Writing to file

		for (int row = 0; row < inputs.length; row++) {
			for (int col = 0; col < inputs[0].length; col++) {
				print.write(Double.toString(inputs[row][col]) + ",");
			}
			print.write("\n");
		}

		print.close();
		
        Desktop desktop = Desktop.getDesktop();
        if (exportArray.exists()) {
        	desktop.open(exportArray);
        }

	}

	public boolean userPassCheck(int ID, int passW)	// ----> This takes in the ID and password, and checks to see if they match. If so, user is logged on
	{ 										       
		int rwNum = 0;
		for (int row = 0; row < inputs.length; row++) {
			if (inputs[row][0] == ID) {
				rwNum = row;
				break;
			}
		}

		if (inputs[rwNum][1] == passW) {
			return true;
		}

		return false;
	}

}