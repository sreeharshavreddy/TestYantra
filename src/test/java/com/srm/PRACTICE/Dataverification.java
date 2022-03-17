package com.srm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Dataverification 
{
  @Test
  public void dataVerificationInDB() throws Throwable{
  String expData="Nithesh";
  //step:1
  
  Driver driver = new Driver();
  DriverManager.registerDriver(driver);
  //step:2
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
   // step:3 isuess the create statement
   Statement state = con.createStatement();
   // step:4  create the querry
   ResultSet result = state.executeQuery("select * from student");
   
   while(result.next())
   {
	 String actData = result.getString(2);
	 if(expData.equalsIgnoreCase(actData))
	 {
		 System.out.println("Data is verifind");
	 }
   }
   //step:5
   con.close();
}
}