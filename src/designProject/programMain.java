package designProject;

import java.io.IOException;
import java.util.Scanner;


public class programMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PreProgramClass theProgram = new PreProgramClass();

		Scanner askNum = new Scanner(System.in);
		System.out.println("How many people do you want in the system?"); 
		int numOfStudents = askNum.nextInt();
		theProgram.setArray(numOfStudents); //INDICATES AMOUNT OF ITERATIONS OF FOR LOOP

		theProgram.arrayInputs(); //FILLS ARRAY

		askNum = new Scanner(System.in); 
		System.out.println("How many people want to order from Dorm Grill?");
		int num = askNum.nextInt(); //INDICATES AMOUNT OF ITERATION OF FOR LOOP

		for (int x = 1; x <= num; x++) { // -------------> RERUNS LOGIN PAGE UNTIL USER ENTERS CORRECT USERNAME AND PASSWORD
			boolean checkLogin = theProgram.loginCheck();

			while (checkLogin == false) {

				checkLogin = theProgram.loginCheck();
			}

			theProgram.tabOrMenu();
		}
		System.out.println("\nDelivery on its way!");		
		
		theProgram.exportArray(); // EXPORTS ARRAY TO FILE ON HARD DRIVE THEN CLOUD ~ END OF PROGRAM
	}
}
