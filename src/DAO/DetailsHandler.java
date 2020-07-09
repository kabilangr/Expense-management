package DAO;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import Model.Employee;
public class DetailsHandler 
{
   public void createEmployee()throws Exception
   { 
	   SalaryCalculator sc=new SalaryCalculator();
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Employee Name");
	    String en=in.nextLine();
		System.out.println("Enter Employee ID");
		int id=in.nextInt();
		System.out.println("Enter Employee Age");
		int age=in.nextInt();
		System.out.println("Enter Employee Position");
		String position=in.nextLine();
		System.out.println("Enter Employee Email ID");
		String email=in.nextLine();
		System.out.println("Enter Employee Address");
		String address=(in.nextLine());
		System.out.println("Enter Employee Basic Salary");
		double bs=in.nextDouble();
		System.out.println("Enter Employee deductions");
		double d=in.nextDouble();
		Employee obj=new Employee(en,id,age,position,address,bs,d);
		int rd=ms.getLastRowNum();
		XSSFRow row=ms.createRow(rd);
		 Object[] o= {obj.getEmployeeName(),obj.getId(),obj.getAge(),obj.getPosition(),obj.getAddress(),obj.getBasicSal(),obj.getDeductions()};
		 Object cell_value=o;
		 for(int i=0;i<7;i++)
		 {
			 Cell cell = row.createCell(i);//1
             if (cell_value instanceof String) {
                 cell.setCellValue((String) cell_value);
             } else if (cell_value instanceof Integer) {
                 cell.setCellValue((Integer) cell_value);
             }else if (cell_value instanceof Boolean) {
                 cell.setCellValue((Boolean) cell_value);
             }else if (cell_value instanceof Date) {
                 cell.setCellValue((Date) cell_value);
             }
                 else if(cell_value instanceof Double )
                 {
                	 cell.setCellValue((Double) cell_value); 
		 }     
             
   }
		Cell cell=row.createCell(7);
		cell.setCellValue((Double) sc.salaryCalcutaions(obj.getBasicSal(),obj.getDeductions()));
		cell=row.createCell(8);
		cell.setCellValue((String) email);
   }
   public void searchEmployee()throws Exception
   {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
	   Scanner in=new Scanner(System.in);
	   System.out.println("Enter Employee Name");
	   String name=in.nextLine();
	   System.out.println("Enter Employee Name");
	   int id=in.nextInt();
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
	   if(j!=0)
	   {
		   System.out.println("Employee Name: "+(ms.getRow(j-1).getCell(0)).toString());
           System.out.println("Employee Id: "+(ms.getRow(j-1).getCell(1)).toString());
           System.out.println("Employee Age: "+(ms.getRow(j-1).getCell(2)).toString());
           System.out.println("Employee Position: "+(ms.getRow(j-1).getCell(3)).toString());
           System.out.println("Employee Email:"+(ms.getRow(j-1).getCell(8)).toString());
           System.out.println("Employee Address: "+(ms.getRow(j-1).getCell(4)).toString());
           System.out.println("Employee Basic Salary: "+(ms.getRow(j-1).getCell(5)).toString());
           System.out.println("Employee Deduction: "+(ms.getRow(j-1).getCell(6)).toString());
           System.out.println("Employee Take Home Salary: "+(ms.getRow(j-1).getCell(7)).toString());
	   }
	   else
	   {
		   System.out.println("Wrong Search Name and ID");
	   }
   }
   public void removeEmployee()throws Exception
   {
	   File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
	   Scanner in=new Scanner(System.in);
	   System.out.println("Enter Employee Name");
	   String name=in.nextLine();
	   System.out.println("Enter Employee Id");
	   int id=in.nextInt();
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
	   for(int i=j;i<rd;i++)
	   {
		   for(int k=0;k<9;k++)
		   {
		   str=(ms.getRow(i).getCell(k)).toString();
		   XSSFRow row=ms.createRow(i-1);
		   Cell cell = row.createCell(k);
               cell.setCellValue((String) str);
	   }
	   }
	   XSSFRow row=ms.createRow(rd);
	   for( j=0;j<9;j++)
	   {
		   row.removeCell(row.getCell(j));

	   }
   }
   public void changeDetails()throws Exception
   {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
		RegistrationValidation rv=new RegistrationValidation();
	   Scanner in=new Scanner(System.in);
	   System.out.println("Enter Employee Name");
	   String name=in.nextLine();
	   System.out.println("Enter Employee Name");
	   int id=in.nextInt();
	   int idl=0;
	   String str="";
	   int j=0;
	   int rd=ms.getLastRowNum();
	   for(int i=1;i<rd;i++)
	   {
		   str=(ms.getRow(i).getCell(0)).toString();
		   idl=Integer.parseInt((ms.getRow(i).getCell(1).toString()));
		   if((str.equals(name))&&(idl==id))
			   j=i;
	   }
	   int kill=0;
	   while(kill!=1)
	   {
	   System.out.println("1.change ID");
	   System.out.println("2.change Age");
	   System.out.println("3.change Position");
	   System.out.println("4.change Address");
	   System.out.println("5.change Basic Salary");
	   System.out.println("6.change Deduction");
	   System.out.println("7.Change Email");
	   System.out.println("8.Exit");
	   System.out.println("Enter your choice:");
	   int ch=in.nextInt();
	   switch(ch)
	   {
	   case 1:
	   {
		   
		  int idthere=Integer.parseInt(ms.getRow(j).getCell(1).toString());
		   System.out.println("Previous Id: "+idthere);
		   System.out.println("Want to change?(y/n)");
		   char c=in.next().charAt(0);
		   if((c=='y')||(c=='Y'))
		   {
			   System.out.println("Enter ID:");
			   int idnew=in.nextInt();
		   XSSFRow row=ms.createRow(j);
		   Cell cell = row.createCell(1);
               cell.setCellValue((Integer) idnew);
		   }
		   
		   break;
	   }
	   case 2:
	   {
			  int agethere=Integer.parseInt(ms.getRow(j).getCell(2).toString());
			   System.out.println("Previous age: "+agethere);
			   System.out.println("Want to change?(y/n)");
			   char c=in.next().charAt(0);
			   if((c=='y')||(c=='Y'))
			   {
				   System.out.println("Enter Age:");
				   int agenew=in.nextInt();
			   XSSFRow row=ms.createRow(j);
			   Cell cell = row.createCell(2);
	               cell.setCellValue((Integer) agenew);
			   }
		   break;
	   }
	   case 3:
	   {
			  String posthere=(ms.getRow(j).getCell(3).toString());
			   System.out.println("Previous Position: "+posthere);
			   System.out.println("Want to change?(y/n)");
			   char c=in.next().charAt(0);
			   if((c=='y')||(c=='Y'))
			   {
				   System.out.println("Enter Position:");
				   String posnew=in.nextLine();
			   XSSFRow row=ms.createRow(j);
			   Cell cell = row.createCell(3);
	               cell.setCellValue((String) posnew);
			   }
		   break;
	   }
	   case 4:
	   {
			  String addthere=(ms.getRow(j).getCell(4).toString());
			   System.out.println("Previous Address: "+addthere);
			   System.out.println("Want to change?(y/n)");
			   char c=in.next().charAt(0);
			   if((c=='y')||(c=='Y'))
			   {
				   System.out.println("Enter Address:");
				   String addnew=in.nextLine();
			   XSSFRow row=ms.createRow(j);
			   Cell cell = row.createCell(4);
	               cell.setCellValue((String) addnew);
			   }
		   break;
	   }
	   case 5:
	   {
		   SalaryCalculator sc=new SalaryCalculator();
			  double bsthere=Double.parseDouble(ms.getRow(j).getCell(5).toString());
			   System.out.println("Previous Basic Salary: "+bsthere);
			   System.out.println("Want to change?(y/n)");
			   char c=in.next().charAt(0);
			   if((c=='y')||(c=='Y'))
			   {
				   System.out.println("Enter Basic Salary:");
				   double bsnew=in.nextDouble();
			   XSSFRow row=ms.createRow(j);
			   Cell cell = row.createCell(5);
	               cell.setCellValue((Double) bsnew);
	               double det=Double.parseDouble(ms.getRow(j).getCell(6).toString());
	               cell = row.createCell(7);
	               cell.setCellValue((Double) (sc.salaryCalcutaions(bsnew, det)));
			   }
		   break;
	   }
	   case 6:
	   {
		   SalaryCalculator sc=new SalaryCalculator();
			  double detthere=Double.parseDouble(ms.getRow(j).getCell(6).toString());
			   System.out.println("Previous Deduction: "+detthere);
			   System.out.println("Want to change?(y/n)");
			   char c=in.next().charAt(0);
			   if((c=='y')||(c=='Y'))
			   {
				   System.out.println("Enter Deduction:");
				   double denew=in.nextDouble();
			   XSSFRow row=ms.createRow(j);
			   Cell cell = row.createCell(6);
	               cell.setCellValue((Double) denew);
	               double bs=Double.parseDouble(ms.getRow(j).getCell(5).toString());
	               cell = row.createCell(7);
	               cell.setCellValue((Double) (sc.salaryCalcutaions(bs, denew)));
			   }
		   break;
	   }
	   case 7:
	   {
		   int flag=0;String emailnew="",str1="";
		   String emailthere=(ms.getRow(j).getCell(8).toString());
		   System.out.println("Previous Email Id: "+emailthere);
		   System.out.println("Want to change?(y/n)");
		   char c=in.next().charAt(0);
		   if((c=='y')||(c=='Y'))
		   {
			   while(flag!=1)
			   {
			   System.out.println("Enter Email Id:");
			   emailnew=in.nextLine();
			   str1=emailnew;
			   if(rv.validEmail(emailnew))
			   {
				   flag=1;
			   }
			   else
				   System.out.println("Enter a valid Email Id");
			   }
		   XSSFRow row=ms.createRow(j);
		   Cell cell = row.createCell(8);
               cell.setCellValue((String) str1);
		   }
		   break;
	   }
	   case 8:
	   {
		   kill=1;
		   break;
	   }
	   default:
	   {
		   System.out.println("Wrong choice!!! OOPS!!!");
	   }
	   }
	   }
	   System.out.println("Employee Name: "+(ms.getRow(j).getCell(0)).toString());
       System.out.println("Employee Id: "+(ms.getRow(j).getCell(1)).toString());
       System.out.println("Employee Age: "+(ms.getRow(j).getCell(2)).toString());
       System.out.println("Employee Position: "+(ms.getRow(j).getCell(3)).toString());
       System.out.println("Employee Email:"+(ms.getRow(j).getCell(8)).toString());
       System.out.println("Employee Address: "+(ms.getRow(j).getCell(4)).toString());
       System.out.println("Employee Basic Salary: "+(ms.getRow(j).getCell(5)).toString());
       System.out.println("Employee Deduction: "+(ms.getRow(j).getCell(6)).toString());
       System.out.println("Employee Take Home Salary: "+(ms.getRow(j).getCell(7)).toString());
   }
}
