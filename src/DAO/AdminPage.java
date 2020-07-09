package DAO;

import java.util.Scanner;

public class AdminPage 
{
public void adminPage()throws Exception
{
	int kill=0;
	while(kill!=1)
	{
	System.out.println("You are in");
	System.out.println("1.Create Employee");
	System.out.println("2.Search Employee");
	System.out.println("3.Remove Employee");
	System.out.println("4.Change Employee");
	System.out.println("5.back to main");
	Scanner in=new Scanner(System.in);
	System.out.println("Enter your choice");
	DetailsHandler dh=new DetailsHandler();
	int ch=in.nextInt();
	switch(ch)
	{
	case 1:
	{
		dh.createEmployee();
		break;
	}
	case 2:
	{
		dh.searchEmployee();
		break;
	}
	case 3:
	{
		dh.removeEmployee();
		break;
	}
	case 4:
	{
		break;
	}
	case 5:
	{
		kill=1;
		break;
	}
	default:
	{
		System.out.println("wrong choice");
	}
	}
	}
}
}
