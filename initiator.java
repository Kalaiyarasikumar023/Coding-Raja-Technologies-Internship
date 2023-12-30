package com.demo.onlineBanking.accountManagement;

import java.sql.SQLException;
import java.util.Scanner;

 class Initiator {
	 Initiator() throws ClassNotFoundException, SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("WELCOME TO ONLINE BANKING");
		System.out.println();
		System.out.println("(Existing user?:userInput yes or no)  (If Admin?:userInput admin)");
		String userInput = s.next();
		if (userInput.equalsIgnoreCase("yes")) {
			System.out.println("Enter your login details");
			Login login = new Login();
		} else if (userInput.equalsIgnoreCase("no")) {
			System.out.println("Register NEW USER");
			Registration registration = new Registration();
		} else if (userInput.equalsIgnoreCase("admin")) {
			Admin admin = new Admin();
		} else {
			System.out.println("enter the valid details");
			Initiator initiator = new Initiator();
		}
	}
}
