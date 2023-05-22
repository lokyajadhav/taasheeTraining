package com.taashee.training;
import com.taashee.training.DatabasePack.*;
import java.util.*;

public class App 
{
	static private void  launchJDBCAppConsole() {
		System.out.println("\t\tWelcome to JBDC Console App");
		int input;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("\t\tWelcome to JBDC Console App");
			System.out.println("\t\t1. fetch Users");
			System.out.println("\t\t2. get user byb name");
			System.out.println("\t\t3. insert a new  user");
			System.out.println("\t\t4. Update user ");
			System.out.println("\t\t5.delete a user");
			System.out.println("\t\t6. exit");
			
			System.out.print("\t\tEnter Your Option>>>>");
			input=sc.nextInt();
			switch(input)
			{
			case 1:
				UserDao.getAllUsers();
				break;
			case 2:
				System.out.print("\t\tEnter user name:");
				
				sc.nextLine();
				String name1=sc.nextLine();
				UserDao.getUserByName(name1);
				break;
			case 3:
				System.out.print("\t\tEnter user name:");
				
				sc.nextLine();
				String name=sc.nextLine();
				
				System.out.print("\t\tEnter user city:");
				String city=sc.next();
				UserDao.addNewUser(name, city);
				break;
			case 4:
				System.out.print("\t\tEnter user name:");
				
				//sc.nextLine();
				int ID=sc.nextInt();
				
				System.out.print("\t\tEnter user city:");
				String city1=sc.next();
				UserDao.updateUser(city1, ID);
				break;
			case 5:
				
				System.out.print("\t\tEnter user ID:");
				
				//sc.nextLine();
				int ID1=sc.nextInt();
				UserDao.deleteUser(ID1);
				break;
			case 6:
				System.out.println("\t\t1. fetch Users");
				return ;
			
			}
			
			
		}while(input!=6);
		sc.close();
	}
    public static void main( String[] args )
    {
       launchJDBCAppConsole();
        
    }
}
