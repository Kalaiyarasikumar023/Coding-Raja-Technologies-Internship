package com.demo.onlineBanking.accountManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Balance{
    Balance() throws ClassNotFoundException, SQLException
    {
        Scanner sc=new Scanner(System.in);
         System.out.println("enter the  user id:");
            String userid=sc.next();
        System.out.println("enter the account number of the user:");
        long acc=sc.nextLong();
       
        System.out.println("enter the amount to add:");
        int amount=sc.nextInt();
        Class.forName("com.mysql.jdbc.Driver");
        Connection c5=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking","root","root");
        Statement st=(Statement) c5.createStatement();
        String s3="insert into balance values(?,?,?)";
        PreparedStatement ps=(PreparedStatement) c5.prepareStatement(s3);
        ps.setString(1,userid);
        ps.setLong(2,acc);
        ps.setLong(3,amount);
        ps.execute();
        c5.close();
     }
}
