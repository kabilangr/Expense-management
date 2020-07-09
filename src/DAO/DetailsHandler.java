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
	   for(int i=0;i<rd;i++)
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
	   System.out.println("Enter Employee Name");
	   int id=in.nextInt();
	   int idl=0;
	   String str="";
	   int j=0;
	   int rd=ms.getLastRowNum();
	   for(int i=0;i<rd;i++)
	   {
		   str=(ms.getRow(i).getCell(0)).toString();
		   idl=Integer.parseInt((ms.getRow(i).getCell(1).toString()));
		   if((str.equals(name))&&(idl==id))
			   j=i+1;
	   }
	   for(int i=j;i<rd;i++)
	   {
		   for(int k=0;k<8;k++)
		   {
		   str=(ms.getRow(i).getCell(k)).toString();
		   XSSFRow row=ms.createRow(i-1);
		   Cell cell = row.createCell(k);
               cell.setCellValue((String) str);
	   }
	   }
	   XSSFRow row=ms.createRow(rd);
	   for( j=0;j<8;j++)
	   {
		   row.removeCell(row.getCell(j));

	   }
   }
}
