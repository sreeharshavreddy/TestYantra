package com.srm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	@Test
	public void sampleJDBCExecuteQuery() throws Throwable
	{
		// step:1 register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		// step:2 get connect from the database- provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		//step:3 isues create the statement
		Statement state = con.createStatement();
		//step:4 execute query-provide table name
		 ResultSet result = state.executeQuery("select * from student;");
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+" "+result.getString(2));
		 }
		 //step :5 close the database
		 con.close();
		 }
		
		
	}

