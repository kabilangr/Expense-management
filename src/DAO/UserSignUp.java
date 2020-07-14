package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserSignUp 
{
	public void userSignUp()throws Exception
	{
		RegistrationValidation rv=new RegistrationValidation();
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
		XSSFRow row;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("........................................................................");
		System.out.println("Enter Your Name:");
		String name=in.readLine();
		System.out.println("Enter Your Id:");
		int id=Integer.parseInt(in.readLine());
		System.out.println("Enter Your Age:");
		int age=Integer.parseInt(in.readLine());
		System.out.println("Enter Your Email");
		String email=in.readLine();
		System.out.println("Enter Password");
		String pass=in.readLine();
		System.out.println("Confirm Password");
		String passcon=in.readLine();
		System.out.println("........................................................................");
		 int idl=0;
		   String str="";
		   int j=0;
		   int rd=ms.getLastRowNum();
		   for(int i=1;i<=rd;i++)
		   {
			   str=(ms.getRow(i).getCell(0)).toString();
			   idl=(int)Double.parseDouble((ms.getRow(i).getCell(1).toString()));
			   if((str.equals(name))&&(idl==id))
				   j=i+1;
		   }
		   if((j!=0)&&(rv.validPassword(pass, passcon))&&((ms.getRow(j-1).getCell(9).toString()).equals("null")))
		   {
			   if((rv.validEmail(email)==false))
				   System.out.println(".......Please enter Valid Email ID.......");
			   else
			   {
				   double bs,det,take;
		              String str1=(ms.getRow(j-1).getCell(3)).toString();
		               bs=Double.parseDouble((ms.getRow(j-1).getCell(5)).toString());
		               det=Double.parseDouble((ms.getRow(j-1).getCell(6)).toString());
		               take=Double.parseDouble((ms.getRow(j-1).getCell(7)).toString());
		               String str2=(ms.getRow(j-1).getCell(4)).toString();
				   row=ms.createRow(j-1);
				   Cell cell0 = row.createCell(0);
	               cell0.setCellValue((String) str);
				   Cell cell1 = row.createCell(1);
	               cell1.setCellValue((Integer) id);
				   Cell cell2 = row.createCell(2);
	               cell2.setCellValue((Integer) age);
				   Cell cell3 = row.createCell(3);
	               cell3.setCellValue((String) str1);
				   Cell cell4 = row.createCell(4);
	               cell4.setCellValue((String) str2);
				   Cell cell5 = row.createCell(5);
	               cell5.setCellValue((Double) bs);
				   Cell cell6 = row.createCell(6);
	               cell6.setCellValue((Double) det);
				   Cell cell7 = row.createCell(7);
	               cell7.setCellValue((Double) take);
				   Cell cell8 = row.createCell(8);
	               cell8.setCellValue((String) email); 
				   Cell cell = row.createCell(9);
	               cell.setCellValue((String) pass);   
			   }
		   }
		   else
		   {
			   System.out.println(".........................Details are Wrong....................");
		   }
		   FileOutputStream os = new FileOutputStream(myFile);
	        myWorkBook.write(os);
	        System.out.println("________");
	        System.out.println("|      |");
	        System.out.println("| Done |");
	        System.out.println("|______|");
	        os.flush();
	        os.close();
		   myWorkBook.close();
		   fis.close();
	}

}
