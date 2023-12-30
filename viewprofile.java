package com.demo.onlineBanking.accountManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class ViewProfile {
	ViewProfile(String user_id) throws ClassNotFoundException, SQLException {
		// pass the value for name
		System.out.println(" view profile");
		Class.forName("com.mysql.jdbc.Driver");
		Connection c3 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking", "root",
				"root");
		Statement st1 = (Statement) c3.createStatement();
		String s9 = "select * from  onlinebank where user='" + user_id + "';";
		ResultSet rs2 = st1.executeQuery(s9);
		while (rs2.next()) {
			System.out.println(" ****** PROFILE ******");
			System.out.println();
			System.out.println();
			System.out.println("NAME           : " + rs2.getString(1));
			System.out.println();
			System.out.println("BANK NAME      : " + rs2.getString(2));
			System.out.println();
			System.out.println("ACCOUNT NUMBER : " + rs2.getInt(3));
			System.out.println();
			System.out.println("BRANCH         : " + rs2.getString(4));
			System.out.println();
			System.out.println("IFSC NUMBER    : " + rs2.getString(5));
			System.out.println();
			System.out.println("MICR NUMBER    : " + rs2.getInt(6));
			System.out.println();
			System.out.println("MOBILE NUMBER  : " + rs2.getLong(7));
			System.out.println();
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to continue ?");
		String t1 = sc.next();
		if (t1.equalsIgnoreCase("yes")) {
			int choice = 0;
			System.out.println("1.View Profile ");
			System.out.println("2.Transaction ");
			System.out.println("3.Logout ");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				ViewProfile v = new ViewProfile(user_id);
				break;
			case 2:
				Transaction t = new Transaction(user_id);
				break;

			}
		} else {
			Logout l = new Logout();
			c3.close();
		}
	}
}
