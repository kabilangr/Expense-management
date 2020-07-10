package DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AdminPage 
{
public void adminPage()throws Exception
{
	System.out.println("You are in");
	int kill=0;
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	while(kill!=1)
	{
	System.out.println("1.Create Employee");
	System.out.println("2.Search Employee");
	System.out.println("3.Remove Employee");
	System.out.println("4.Change Employee details");
	System.out.println("5.back to main");
	System.out.println("Enter your choice");
	DetailsHandler dh=new DetailsHandler();
	int ch=Integer.parseInt(in.readLine());
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
		dh.changeDetails();
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
