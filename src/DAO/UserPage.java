package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserPage {
		public void userPage(String name)throws Exception
		{
			System.out.println("You are in");
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			UserDetails ud=new UserDetails();
			File myFile = new File("./Check.xlsx"); 
			FileInputStream fis = new FileInputStream(myFile);
			XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			int rd=mySheet.getLastRowNum();
			String str="",st;
			int f=0;
			for(int i=1;i<=rd;i++)
			{
				str=mySheet.getRow(i).getCell(0).toString();
				st=mySheet.getRow(i).getCell(8).toString();
				if(name.equals(str))
				{
					f=i;
					System.out.println("1");
					break;
				}
				if(name.equals(st))
				{
					f=i;
					System.out.println("2");
					break;
				}
			}
			int kill=0;
			while(kill!=1)
			{
			System.out.println("1.View Details");
			System.out.println("2.View Salary");
			System.out.println("3.Change Details");
			System.out.println("4.Change Password");
			System.out.println("5.Pay Slip");
			System.out.println("6.Exit");
			System.out.println("5.back to main");
			System.out.println("Enter your choice");
			int ch=Integer.parseInt(in.readLine());
			switch(ch)
			{
			case 1:
			{
				ud.viewUserDetails(f);
			break;
			}
			case 2:
			{
				ud.viewSalaryDetails(f);
			break;
			}
			case 3:
			{
				ud.changeDetailsOfUser(f);
			break;
			}
			case 4:
			{
				ud.changePassword(f);
			break;
			}
			case 5:
			{
				ud.paySlipMaking(f);
			break;
			}
			default:
			{
				System.out.println("Wrong Choice!! OOPS!!");
			}
				}
			
			}
			   myWorkBook.close();
			   fis.close();

		}
}
