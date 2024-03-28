package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.UserDao;
import dto.User;

public class UserController 
{
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Choice");
			System.out.println("1.Save The User");
			System.out.println("2.Update The User");
			System.out.println("3.Delete The User");
			System.out.println("4.Display The User");
			int choice=Integer.parseInt(bufferedReader.readLine());
			switch(choice)
			{
			case 1:
				{
					System.out.println("Enter Id");
					int id=Integer.parseInt(bufferedReader.readLine());
					System.out.println("Enter Name Of The User");
					String name=bufferedReader.readLine();
					System.out.println("Enter City Of The User");
					String city=bufferedReader.readLine();
					System.out.println("Enter Email Id");
					String emailId=bufferedReader.readLine();
					System.out.println("Enter Phone No");
					String phoneNo=bufferedReader.readLine();
					User user=new User();
					user.setName(name);
					user.setId(id);
					user.setEmailId(emailId);
					user.setPhoneNo(phoneNo);
					user.setCity(city);
					new UserDao().saveUser(user);
				}
				break;
			case 2:
			{
				System.out.println("Enter Id Yo Be Updated");
				int id=Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter Name Of The User");
				String name=bufferedReader.readLine();
				System.out.println("Enter City Of The User");
				String city=bufferedReader.readLine();
				System.out.println("Enter Email Id");
				String emailId=bufferedReader.readLine();
				System.out.println("Enter Phone No");
				String phoneNo=bufferedReader.readLine();
				User user=new User();
				user.setName(name);
				user.setEmailId(emailId);
				user.setPhoneNo(phoneNo);
				user.setCity(city);
				new UserDao().updateUser(id, user);
			}
			break;
			case 3:
			{
				System.out.println("Enter Id Yo Be Deleted");
				int id=Integer.parseInt(bufferedReader.readLine());
				new UserDao().deleteUser(id);
			}
			break;
			case 4:
			{
				System.out.println("Enter Id Yo Be Display");
				int id=Integer.parseInt(bufferedReader.readLine());
				new UserDao().displayUser(id);
			}
			break;
			default:
				System.out.println("Enter Choice Between 1-4");
			}
			
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
	}
}
