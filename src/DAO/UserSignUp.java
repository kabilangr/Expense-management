package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserSignUp 
{
	public void userSignUp()throws Exception
	{
		int k=1;
		RegistrationValidation rv=new RegistrationValidation();
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
		Scanner in=new Scanner(System.in);
		while(k!=1)
		{
		System.out.println("Enter Your Name:");
		String name=in.nextLine();
		System.out.println("Enter Your Id:");
		int id=in.nextInt();
		System.out.println("Enter Your Age:");
		int age=in.nextInt();
		System.out.println("Enter Your Email");
		String email=in.nextLine();
		System.out.println("Enter Password");
		String pass=in.nextLine();
		System.out.println("Confirm Password");
		String passcon=in.nextLine();
		 int idl=0;
		   String str="";
		   int j=0;
		   int rd=ms.getLastRowNum();
		   for(int i=1;i<rd;i++)
		   {
			   str=(ms.getRow(i).getCell(0)).toString();
			   idl=Integer.parseInt((ms.getRow(i).getCell(1).toString()));
			   if((str.equals(name))&&(idl==id))
				   j=i+1;
		   }
		   if((j!=0)&&(rv.validPassword(pass, passcon))&&((ms.getRow(j-1).getLastCellNum())==9))
		   {
			   if((rv.validEmail(email)))
				   System.out.println(".......Please enter Valid Email ID.......");
			   else
			   {
				   XSSFRow row=ms.createRow(j-1);
				   Cell cell = row.createCell(9);
		               cell.setCellValue((String) pass);
		               cell = row.createCell(8);
		               cell.setCellValue((String) email);
		               cell = row.createCell(2);
		               cell.setCellValue((Integer) age);
			   }
		   }
		   else
		   {
			   System.out.println("Details are Wrong");
		   }
		}
	}

}
