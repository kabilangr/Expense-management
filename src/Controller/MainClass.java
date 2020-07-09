package Controller;
import java.util.*;
import Utility.CrudExcel;
import Model.*;
import Service.*;
import DAO.*;
public class MainClass {
	public static void main(String args[])throws Exception
	{
		int kill=0;
		Scanner in=new Scanner(System.in);
		int c;
		while(kill!=1) 
		{	
		System.out.print("\n1.Admin login");
		System.out.print("\n2.User login");
		System.out.print("\n3.User signup");
		System.out.print("\n4.Exit");
		System.out.println("\nEnter your option");
		c=in.nextInt();
		switch(c)
		{
		case 1:
		{
			System.out.println("Your have chosen Admin login");
			System.out.println("Enter Admin Name");
			String name=in.nextLine();
			System.out.println("Enter Admin Password");
			String pass=in.nextLine();
			CrudExcel crud=new CrudExcel();
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
			break;
		}
		case 3:
		{
			System.out.println("Your have chosen User signup");
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
