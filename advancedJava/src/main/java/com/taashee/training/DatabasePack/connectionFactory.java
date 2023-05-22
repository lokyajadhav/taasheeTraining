package com.taashee.training.DatabasePack;
import java.sql.*;
public class connectionFactory {
		private static  connectionFactory connFac=new  connectionFactory();
		private String URL="jdbc:mysql://localhost:3306/user";
		private String USER="root";
		private String PASSWORD="Loky@9985";
		public connectionFactory()
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		private Connection fetchConnection()
		{
			Connection con=null;
			try 
			{
				con= DriverManager.getConnection(URL,USER,PASSWORD);
			}catch(SQLException throwable )
			{
				throwable.printStackTrace();
			}
			return con;
		}
		public static Connection  getConnection() {
			return connFac.fetchConnection();
		}
}
