package com.demo.onlineBanking.accountManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Admin
{
    Admin() throws ClassNotFoundException, SQLException{
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the admin id: :");
        String emp_id=s.next();
        System.out.println("Enter the Password :");
        String emp_pd=s.next();
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection c3=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking","root","root");
        Statement st3=(Statement) c3.createStatement();
        String s8="select * from admin_details where admin_id= '"+emp_id+ "';";
        ResultSet rs6=st3.executeQuery(s8);
        while(rs6.next())
        {
            if(rs6.getString(1).equals(emp_id))
            {
                System.out.println("LOGIN SUCCESSFULLY!!");
            }
            
            else    
            {
                System.out.println("ENTER VALID USER ID AND PASSWORD:");
               Admin admin =new Admin();
            }
        }
        System.out.println();
        System.out.println("Select the domain:");
        System.out.println("1.View the user details");
        System.out.println("2.Update the balance of the user");
        int ad_domain=s.nextInt();
        switch(ad_domain)
        {
        case 1 :
            ViewDetails v=new ViewDetails();
            break;
        case 2 :
        
            Balance b=new Balance();
            
            
            break;
        }
        System.out.println("Do you want to continue ?");
		String t1 = s.next();
		if (t1.equalsIgnoreCase("yes")) {
			int choice = 0;
			switch (choice) {
			case 1 :
	            ViewDetails v=new ViewDetails();
	            break;
	        case 2 :
	            Balance b=new Balance();
	            break;
			
			}}
			else {
				Logout l = new Logout();
				 c3.close(); 
				}
			}
               
    }
    
