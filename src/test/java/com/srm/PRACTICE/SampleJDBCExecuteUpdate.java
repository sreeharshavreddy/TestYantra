package com.srm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
@Test
public void Sample() throws Throwable
{
	Connection con =null;

	try
	{
	// step:1 register the database
	Driver Driver = new Driver();
	DriverManager.registerDriver(Driver);
	// step:2 get connect from the database- provide db name
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			//step:3 issues create the statement
			Statement state = con.createStatement();
			//step:4 execute query-provide table name
		 int result = state.executeUpdate("insert into student values('5','akshatha','female')");
			 if(result==1)
			 {
				 System.out.println("data is added");
			 }else{
				 System.out.println("data is not added");
			 }
	}
			 finally
			 {
				 con.close();
				 System.out.println("connection closed");
			 }
	}
}

