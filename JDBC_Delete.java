package com.example.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Delete {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","MR");
			Statement smt=con.createStatement();
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.print("Enter Deletion Emp Id: ");
				int eno=Integer.parseInt(br.readLine());
				
				int count=smt.executeUpdate("delete from emp where eno="+eno);
				if(count==1)
					System.out.println(count+" rows deleted");
				else
					System.out.println("no record deleted");
				
				System.out.println("Do You Want to Delete More Records[Yes/No]");
				
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
