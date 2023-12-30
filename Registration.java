package com.demo.onlineBanking.accountManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Registration {
	Registration() throws ClassNotFoundException, SQLException {
		System.out.println();
		System.out.println("PERSONAL DETAILS :");
		System.out.println();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your name :");
		String name = s.nextLine();
		System.out.println("Bank name :");
		String bank_name = s.nextLine();
		System.out.println("Account number :");
		long acc_num = s.nextLong();
		System.out.println("Branch :");
		String branch = s.next();
		System.out.println(" ");
		System.out.println("IFSC :");
		String ifsc = s.next();
		System.out.println("MICR :");
		long micr = s.nextLong();
		System.out.println("Mobile number:");
		long phone_num = s.nextLong();
		System.out.println("User id:");
		String user = s.next();
		System.out.println("Enter Password:");
		String password = s.next();
		System.out.println("Enter Pin number:");
		String pin_num = s.next();
		System.out.println("Enter the Account type: ");
		String acc_type = s.next();

		Class.forName("com.mysql.jdbc.Driver");
		Connection c3 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking", "root",
				"root");
		Statement st2 = (Statement) c3.createStatement();
		String s3 = "insert into onlinebank values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) c3.prepareStatement(s3);
		ps.setString(1, name);
		ps.setString(2, bank_name);
		ps.setLong(3, acc_num);
		ps.setString(4, branch);
		ps.setString(5, ifsc);
		ps.setLong(6, micr);
		ps.setLong(7, phone_num);
		ps.setString(8, user);
		ps.setString(9, password);
		ps.setString(10, pin_num);
		ps.setString(11, acc_type);
		ps.execute();
		c3.close();
		System.out.println("REGISTRATION SUCESSFULLY:!! \n Login Page:!!\n");
		Admin a = new Admin();
		Login l = new Login();

	}
}
