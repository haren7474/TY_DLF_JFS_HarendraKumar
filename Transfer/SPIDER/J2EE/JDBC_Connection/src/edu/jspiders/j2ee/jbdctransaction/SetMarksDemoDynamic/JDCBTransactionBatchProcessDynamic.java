package edu.jspiders.j2ee.jbdctransaction.SetMarksDemoDynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDCBTransactionBatchProcessDynamic 
{
	public static void main(String[] args)
	{
		PreparedStatement pstmt1= null, pstmt2= null;
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter id1");
		int id1=sc.nextInt();
		
		System.out.println("Please enter new Marks");
		double marks1=sc.nextDouble();
		
		System.out.println("Please enter id2");
		int id2=sc.nextInt();
		
		System.out.println("Please enter new Marks");
		double marks2=sc.nextDouble();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/jdbcconnect?user=root&password=";
			con = DriverManager.getConnection(dbUrl);
			
			//Setting Auto commit as false.
			con.setAutoCommit(false);

			
			pstmt1= con.prepareStatement("update politicians set marks =? where id=? ");
			pstmt1.setDouble(1, marks1);
			pstmt1.setInt(2, id1);
			pstmt1.addBatch();
			
			
			pstmt1= con.prepareStatement("update politicians set marks =? where id=? ");
			pstmt1.setDouble(1, marks2);
			pstmt1.setInt(2, id2);
			pstmt1.addBatch();
			
			
			int [] count1= pstmt1.executeBatch();
			
			//int [] count2= pstmt2.executeBatch();
			
			for (int i : count1) 
			{
				System.out.println("Query OK, " + i + "Number of rows affected");
			}
						
			System.out.println("JDBC Transaction is successfull");
			//Setting it to commit
			con.commit();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			try 
			{
				System.out.println("JDBC Transaction is unsuccessfull");
				con.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
