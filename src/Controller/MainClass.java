package Controller;
import java.io.*;
import Utility.*;
import Model.*;
import Service.*;
import DAO.*;
public class MainClass {
	public static void main(String args[])throws Exception
	{
		int kill=0;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int c;
		while(kill!=1) 
		{	
		System.out.print("1.Admin login");
		System.out.print("\n2.User login");
		System.out.print("\n3.User signup");
		System.out.print("\n4.Exit");
		System.out.println("\nEnter your option");
		c=Integer.parseInt(in.readLine());
		switch(c)
		{
		case 1:
		{
			String name;String pass;
			System.out.println("Your have chosen Admin login");
			System.out.println("Enter Admin Name");
			name=in.readLine();
			System.out.println("Enter Admin Password");
			pass=in.readLine();
			AdminName crud=new AdminName();
			crud.setName();
			crud.setPassword();
			Admin admin=new Admin(name,pass,crud.getName(),crud.getPassword());
			Validation v=new Validation();
			if((v.nameValidation(admin))&&(v.passwordValidation(admin)))
			{
				AdminPage a=new AdminPage();
              a.adminPage();
			}
			else
				System.out.println("Wrong name or password");
			break;
		}
		case 2:
		{
			System.out.println("Your have chosen User login");
			System.out.println("Enter User Name");
			String name=in.readLine();
			System.out.println("Enter User Password");
			String pass=in.readLine();
			UserName un=new UserName();
			un.setName(name);
			un.setPassword();
			User user=new User(name,pass,un.getName(),un.getPassword());
			Validation v=new Validation();
			if((v.nameValidation(user))&&(v.passwordValidation(user)))
			{
				UserPage u=new UserPage();
              u.userPage(name);
			}
			break;
		}
		case 3:
		{
			System.out.println("Your have chosen User signup");
			UserSignUp us=new UserSignUp();
			us.userSignUp();
			break;
		}
		case 4:
		{
			System.out.println("Your have chosen EXIT");
			System.out.println("BYE BYE!!!!");
			kill=1;
			break;
		}
		default:
		{
			System.out.println("\nWrong choice try again");
		}
		}
		}
		
	}
}
