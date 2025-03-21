package com.jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbcmysqldatabase {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/empdb";
		String user="root";
		String password="Sekar@1972";
		
		try(Connection connection=DriverManager.getConnection(url, user, password)){
			String insertSQL="insert into emp(empcode,empname,empage,esalary)values(?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(insertSQL);
			
			Object[][]data= {
					{101,"Jenny",25,10000},
					{102,"Jacky",30,20000},
					{103,"Joe",20,40000},
					{104,"John",40,80000},
					{105,"Shameer",25,90000}
			};
			
			for(Object[]row:data) {
				preparedStatement.setInt(1,(int) row[0]);
				preparedStatement.setString(2,(String) row[1]);
				preparedStatement.setInt(3,(int) row[2]);
				preparedStatement.setInt(4,(int) row[3]);
				preparedStatement.executeUpdate();
			}
				
			System.out.println("Data inserted successfully.");
			
		}catch(Exception e) {
			e.printStackTrace();
			}
	}
}
