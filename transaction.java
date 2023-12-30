package com.demo.onlineBanking.accountManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Transaction
{
	Transaction(String user_id) throws ClassNotFoundException, SQLException
   {
       Class.forName("com.mysql.jdbc.Driver");
       Connection c3=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking","root","root");     
       Statement st1=(Statement) c3.createStatement();
       String s5="select * from  onlinebank where user='"+user_id+ "';";
       ResultSet rs2=st1.executeQuery(s5);
       Scanner s=new Scanner(System.in);
       System.out.println("Enter the account number:");
       int accnum_temp=s.nextInt();
       while(rs2.next()) {
       if(rs2.getLong(3)==(accnum_temp))
       {
           int new_amt=0;
           int cur_amt=0;
           System.out.println("Enter the recipient name :");
           String name_to=s.next();
           System.out.println("Enter the recipient account number :");
           String accnum_to=s.next();
           System.out.println("Enter the bank name of the recipient :");
           String bankname_to=s.next();
           System.out.println("Enter the recipient branch:");
           String branch_to=s.next();
           System.out.println("Enter the ifsc of the recipient :");
           String ifsc_to=s.next();
           System.out.println("Enter the micr of the recipient :");
           int micr_to=s.nextInt();
           System.out.println("Enter the amount:");
           int amt=s.nextInt();
           Class.forName("com.mysql.jdbc.Driver");
           Connection c5=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking","root","root");     
           Statement st2=(Statement) c5.createStatement();
           String s1="select * from balance where user_id='"+user_id+ "';";
           ResultSet rs4=st2.executeQuery(s1);
           while(rs4.next()) 
           {
            cur_amt=rs2.getInt(3);
           
           if(amt<=cur_amt)
           {
               System.out.println("Enter the pin number :");
               int pin_num=s.nextInt();
               if(pin_num==rs2.getInt(10)) 
               {
                   System.out.println("                             ************** TRANSACTION RECEIPT ***************");
                   System.out.println();
                   System.out.println();
                   System.out.println("                                    NAME                : "+rs2.getString(1));
                   System.out.println();
                   System.out.println("                                  BANK NAME             : "+rs2.getString(2));
                   System.out.println();
                   System.out.println("                               ACCOUNT NUMBER           : "+rs2.getInt(3));
                   System.out.println();
                   System.out.println("                                   BRANCH               : "+rs2.getString(4));
                   System.out.println();
                   System.out.println("                                RECEIVER NAME           : "+name_to);
                   System.out.println();
                   System.out.println("                               RECIEVER BANK NAME       : "+bankname_to);
                   System.out.println();
                   System.out.println("                            RECIEVER ACCOUNT NUMBER     : "+accnum_to);
                   System.out.println();
                   System.out.println("                                RECIEVER BRANCH         : "+branch_to);
                  System.out.println();
                   System.out.println("                               TRANSFERRED AMOUNT       : "+amt);
                   System.out.println();
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                   LocalDateTime now = LocalDateTime.now();  
                   System.out.println("                                DATE  AND TIME          :"+dtf.format(now)); 
                   System.out.println();
                   System.out.println("                           *************    TRANSACTION SUCCESSFULLY DONE   *************");
                   
               }}}
           Class.forName("com.mysql.jdbc.Driver");
           Connection c4=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking","root","root");     
           Statement st5=(Statement) c4.createStatement();
           String s8="select * from balance where user_id='"+user_id+ "';";
           ResultSet rs3=st5.executeQuery(s8);
           while(rs3.next()) 
           {
           cur_amt=rs3.getInt(3);
           
           }
           new_amt=cur_amt-amt;
           Statement st4=(Statement) c4.createStatement();
           String s4="update balance set balance="+new_amt+" where user_id='"+user_id+ "';";
           st5.executeUpdate(s4);
           
           Scanner sc=new Scanner(System.in);
           System.out.println("Do you want to continue ?");
           String t1=sc.next();
           if (t1.equalsIgnoreCase("yes"))
           {
           int choice=0;
           System.out.println("1.View Profile ");
           System.out.println("2.Transaction ");
           System.out.println("3.Logout ");
           System.out.println("Enter your choice:");
           choice=sc.nextInt();
           switch(choice)
           {
           case 1 :
        	   ViewProfile v=new ViewProfile(user_id);
               break;
           case 2 :
               Transaction t = new Transaction(user_id);
               break;
           case 3:
               Logout l=new Logout();
                  
           }}
           else
            System.out.println("********** LOGOUT SUCCESSFULLY **********");
                       
               }
           }
       }
   }
