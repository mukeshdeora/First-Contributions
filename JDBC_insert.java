package com.example.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_insert {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","MR");
			PreparedStatement psmt=con.prepareStatement("insert into emp values(?,?,?)");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.print("Enter Emp Id: ");
				int eno=Integer.parseInt(br.readLine());
				
				System.out.print("Enter Emp Name: ");
				String ename=br.readLine();
			
				System.out.print("Enter Emp Salary: ");
				double sal=Double.parseDouble(br.readLine());
				
				psmt.setInt(1, eno);
				psmt.setString(2, ename);
				psmt.setDouble(3, sal);
				
				int count=psmt.executeUpdate();
				if(count>0)
					System.out.println(count+" record inserted");
				else
					System.out.println("no record inserted");
				
				System.out.println("Do You Want to Insert More Records[Yes/No]");
				
				String ch=br.readLine();
				if(ch.equalsIgnoreCase("No"))
				   break;
			}
		}
		catch(Exception e)
		{
		System.out.print(e);	
		}
	}

}
