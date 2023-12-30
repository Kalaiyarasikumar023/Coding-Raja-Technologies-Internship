package com.demo.onlineBanking.accountManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Login {
	Login() throws ClassNotFoundException, SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the user id :");
		String user_id = s.next();
		System.out.println("Enter the Password :");
		String user_pd = s.next();
		System.out.println();
		Class.forName("com.mysql.jdbc.Driver");
		Connection c3 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking", "root",
				"root");
		Statement st4 = (Statement) c3.createStatement();
		String s5 = "select * from  onlinebank where user='" + user_id + "';";
		ResultSet rs2 = st4.executeQuery(s5);
		while (rs2.next()) {
			if (rs2.getString(8).equals(user_id)) {
				System.out.println("LOGIN SUCESSFULL!!");
				System.out.println("Select the domain: ");
				System.out.println("1. VIEW ACCOUNT");
				System.out.println("2.TRANSACTION");
				int domain = s.nextInt();
				switch (domain) {
				case 1:
					ViewProfile v = new ViewProfile(user_id);
					break;
				case 2:
					Transaction t = new Transaction(user_id);
					break;
				}
			} else {
				System.out.println("ENTER THE VALID USER ID OR PASSWORD ");
				Login l = new Login();
			}
		}
		c3.close();
	}
}
