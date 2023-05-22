package com.taashee.training.DatabasePack;
import java.sql.*;
public class UserDao {
				public static     void getAllUsers()
				{
					try
					{
						Connection con=connectionFactory.getConnection() ;
						Statement statement=con.createStatement();
						ResultSet res=statement.executeQuery("SELECT * from User");
						while(res.next())
						{
							System.out.printf("%s lives in %s",res.getString("name"),res.getString("city"));
							System.out.println();
						}
						con.close();
						statement.close();
						
					}catch(SQLException throwables)
					{
						throwables.printStackTrace();
					}
				}
				public static void addNewUser(String name,String city)
				{
					try
					{
						String InsertUserQuery="insert into user(name,city) values(?,?)";
						Connection con=connectionFactory.getConnection();
						PreparedStatement statement=con.prepareStatement(InsertUserQuery);
						statement.setString(1, name);
						statement.setString(2, city);
						int insertedRows=statement.executeUpdate();
						if(insertedRows>0)
						{
							System.out.printf("successfully inserted user %s",name);
							System.out.println();
						}
						con.close();
						statement.close();
					}catch(SQLException e)
					
					{
						e.printStackTrace();
					}
				}
				public static void getUserByName(String name)
				{
					try
					{
						String getUserQuery="select * from user where name= ?";
						Connection con=connectionFactory.getConnection();
						PreparedStatement statement=con.prepareStatement(getUserQuery);
						statement.setString(1, name);
						ResultSet rs=statement.executeQuery();
						while(rs.next())
						{
							System.out.printf("%s lives in %s",rs.getString("name"),rs.getString("city"));
						}
						con.close();
						statement.close();
					}catch(SQLException e)
					
					{
						e.printStackTrace();
					}
				}
				public static void updateUser(String city,int id)
				{
					try
					{
						String updateQuery="update user set city=? where id=?";
						Connection con=connectionFactory.getConnection();
						PreparedStatement statement=con.prepareStatement(updateQuery);
						statement.setString(1, city);
						statement.setInt(2, id);
						int updatedRow=statement.executeUpdate();
						if(updatedRow>0)
						{
							System.out.println("user city updated successfully!");
						
							
						}
						con.close();
						statement.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
				public static void deleteUser(int id)
				{
					try
					{
						String deleteQuery="delete from user where id=?";
						Connection con=connectionFactory.getConnection();
						PreparedStatement statement=con.prepareStatement(deleteQuery);
						statement.setInt(1, id);
						int deletedRows=statement.executeUpdate();
						if(deletedRows>0)
						{
							System.out.println("successfully deleted user!");
							
						}
					}catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
				
}
