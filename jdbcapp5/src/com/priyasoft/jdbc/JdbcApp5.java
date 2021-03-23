package com.priyasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp5 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner scanner=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			st=con.createStatement();
			scanner=new Scanner(System.in);
			float salRange=scanner.nextFloat();
			int rowCount=st.executeUpdate("delete from emp1 where ESAL <"+salRange);
			System.out.println("No of Deleted Rows:"+rowCount);
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				scanner.close();
				st.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		
	}

}
