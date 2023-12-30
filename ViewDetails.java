package com.demo.onlineBanking.accountManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ViewDetails{
    
    ViewDetails() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c3=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking","root","root");
        Statement st2=(Statement) c3.createStatement();
Statement st5=(Statement) c3.createStatement();
String s2="select * from  onlinebank ;";
ResultSet rs2=st2.executeQuery(s2);
System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s","CUSTOMER NAME","BANK NAME","ACCOUNT NUMBER","BRANCH","IFSC","MICR","PHONE NUMBER","ACCOUNT TYPE");
System.out.println();
while(rs2.next())
    {
System.out.format("%20s %20s %20s %20s %20s %20s %20s %20s",rs2.getString(1),rs2.getString(2),rs2.getInt(3),rs2.getString(4),rs2.getString(5),rs2.getInt(6),rs2.getLong(7),rs2.getString(11));
System.out.println();
System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      
    }
}
}
