package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Employee Name");
	    String en=in.readLine();
		System.out.println("Enter Employee ID");
		int id=Integer.parseInt(in.readLine());
		System.out.println("Enter Employee Age");
		int age=Integer.parseInt(in.readLine());
		System.out.println("Enter Employee Position");
		String position=in.readLine();
		System.out.println("Enter Employee Email ID");
		String email=in.readLine();
		System.out.println("Enter Employee Address");
		String address=in.readLine();
		System.out.println("Enter Employee Basic Salary");
		double bs=Double.parseDouble(in.readLine());
		System.out.println("Enter Employee deductions");
		double d=Double.parseDouble(in.readLine());
		Employee obj=new Employee(en,id,age,position,address,bs,d);
		int rd=ms.getLastRowNum();
		XSSFRow row=ms.createRow(rd+1);
		Cell cell1=row.createCell(7);
		cell1.setCellValue((Double) sc.salaryCalcutaions(obj.getBasicSal(),obj.getDeductions()));
		Cell cell2=row.createCell(0);
		cell2.setCellValue((String) obj.getEmployeeName());
		Cell cell3=row.createCell(1);
		cell3.setCellValue((int) obj.getId());
		Cell cell4=row.createCell(2);
		cell4.setCellValue((int) obj.getAge());
		Cell cell5=row.createCell(3);
		cell5.setCellValue((String) obj.getPosition());
		Cell cell6=row.createCell(4);
		cell6.setCellValue((String) obj.getAddress());
		Cell cell7=row.createCell(5);
		cell7.setCellValue((Double) obj.getBasicSal());
		Cell cell8=row.createCell(6);
		cell8.setCellValue((Double) obj.getDeductions());
		Cell cell9=row.createCell(8);
		cell9.setCellValue((String) email);
		Cell cell10=row.createCell(9);
		cell10.setCellValue((String) "null");	
		FileOutputStream os = new FileOutputStream(myFile);
        myWorkBook.write(os);
        System.out.println("Done");
        os.flush();
        os.close();
		   myWorkBook.close();
		   fis.close();
		   
   }
   public void searchEmployee()throws Exception
   {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("Enter Employee Name");
	   String name=in.readLine();
	   System.out.println("Enter Employee Id");
	   int id=Integer.parseInt(in.readLine());
	   double idl=0;
	   String str="";
	   int j=0;
	   int rd=ms.getLastRowNum();
	   System.out.println(rd);
	   for(int i=1;i<=rd;i++)
	   {
		   str=(ms.getRow(i).getCell(0)).toString();
		   System.out.println(str);
		   idl=Double.parseDouble((ms.getRow(i).getCell(1).toString()));
		   if((str.equals(name))&&(idl==id))
			   j=i+1;
	   }
	   if(j!=0)
	   {
		   System.out.println("Employee Name: "+(ms.getRow(j-1).getCell(0)).toString());
           System.out.println("Employee Id: "+(int)idl);
           double age=Double.parseDouble((ms.getRow(j-1).getCell(2)).toString());
          double bs=Double.parseDouble((ms.getRow(j-1).getCell(5)).toString());
          double d=Double.parseDouble((ms.getRow(j-1).getCell(6)).toString());
           System.out.println("Employee Age: "+(int)age);
           System.out.println("Employee Position: "+(ms.getRow(j-1).getCell(3)).toString());
           System.out.println("Employee Email:"+(ms.getRow(j-1).getCell(8)).toString());
           System.out.println("Employee Address: "+(ms.getRow(j-1).getCell(4)).toString());
           System.out.println("Employee Basic Salary: "+bs);
           System.out.println("Employee Deduction: "+d);
           XSSFRow row=ms.createRow(j-1);
           Cell cell=row.createCell(7);
           SalaryCalculator sc=new SalaryCalculator();
   		cell.setCellValue((Double) sc.salaryCalcutaions(bs,d));
           System.out.println("Employee Take Home Salary: "+(ms.getRow(j-1).getCell(7)).toString());
	   }
	   else
	   {
		   System.out.println("Wrong Search Name and ID");
	   }
	   myWorkBook.close();
	   fis.close();
   }
   public void removeEmployee()throws Exception
   {
	   File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
		XSSFRow row;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("Enter Employee Name");
	   String name=in.readLine();
	   System.out.println("Enter Employee Id");
	   int id=Integer.parseInt(in.readLine());
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

	   if(j!=0)
	   {
		   System.out.println("test");
		   int age,idthere;
		   double bs,det,take;
	   for(int i=j;i<=rd;i++)
	   {
	   		row=ms.createRow(i-1);
			   str=(ms.getRow(i).getCell(0)).toString();
			   Cell cell0 = row.createCell(0);
               cell0.setCellValue((String) str);
			   idthere=(int)Double.parseDouble((ms.getRow(i).getCell(1)).toString());
			   Cell cell1 = row.createCell(1);
               cell1.setCellValue((Integer) idthere);
               age=(int)Double.parseDouble((ms.getRow(i).getCell(2)).toString());
			   Cell cell2 = row.createCell(2);
               cell2.setCellValue((Integer) age);
               str=(ms.getRow(i).getCell(3)).toString();
			   Cell cell3 = row.createCell(3);
               cell3.setCellValue((String) str);
               str=(ms.getRow(i).getCell(4)).toString();
			   Cell cell4 = row.createCell(4);
               cell4.setCellValue((String) str);
               bs=Double.parseDouble((ms.getRow(i).getCell(5)).toString());
			   Cell cell5 = row.createCell(5);
               cell5.setCellValue((Double) bs);
               det=Double.parseDouble((ms.getRow(i).getCell(6)).toString());
			   Cell cell6 = row.createCell(6);
               cell6.setCellValue((Double) det);
               take=Double.parseDouble((ms.getRow(i).getCell(7)).toString());
			   Cell cell7 = row.createCell(7);
               cell7.setCellValue((Double) take);
               str=(ms.getRow(i).getCell(8)).toString();
			   Cell cell8 = row.createCell(8);
               cell8.setCellValue((String) str);
               str=(ms.getRow(i).getCell(9)).toString();
			   Cell cell = row.createCell(9);
               cell.setCellValue((String) str);    
	   }
	    row=ms.createRow(rd);
	    System.out.println(rd);
        ms.removeRow(row);
		FileOutputStream os = new FileOutputStream(myFile);
        myWorkBook.write(os);
        System.out.println("Done");
        os.flush();
        os.close();
	   }
	   myWorkBook.close();
	   fis.close();
   }
   public void changeDetails()throws Exception
   {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet ms = myWorkBook.getSheetAt(0);
		RegistrationValidation rv=new RegistrationValidation();
		   SalaryCalculator sc=new SalaryCalculator();
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("Enter Employee Name");
	   String name=in.readLine();
	   System.out.println("Enter Employee ID");
	   int id=Integer.parseInt(in.readLine());
	   int idl=0;
	   String str="";
	   int j=0,idnew,agenew;
	   int rd=ms.getLastRowNum();
	   for(int i=1;i<=rd;i++)
	   {
		   str=(ms.getRow(i).getCell(0)).toString();
		   idl=(int)Double.parseDouble((ms.getRow(i).getCell(1).toString()));
		   if((str.equals(name))&&(idl==id))
			   j=i;
	   }
	   int kill=0;
	   int idthere=(int)Double.parseDouble(ms.getRow(j).getCell(1).toString());
	   int agethere=(int)Double.parseDouble(ms.getRow(j).getCell(2).toString());
	   String posthere=(ms.getRow(j).getCell(3).toString());
	   String addthere=(ms.getRow(j).getCell(4).toString());
	   double bsthere=Double.parseDouble(ms.getRow(j).getCell(5).toString());
		  double detthere=Double.parseDouble(ms.getRow(j).getCell(6).toString());
		   String emailthere=(ms.getRow(j).getCell(8).toString());
		   String pass=(ms.getRow(j).getCell(9).toString());
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
	   int ch=Integer.parseInt(in.readLine());
	   switch(ch)
	   {
	   case 1:
	   {
		   
		  
		   System.out.println("Previous Id: "+idthere);
		   System.out.println("Want to change?(y/n)");
		   String c=in.readLine();
		   if((c.charAt(0)=='y')||(c.charAt(0)=='Y'))
		   {
			   System.out.println("Enter ID:");
			    idnew=Integer.parseInt(in.readLine());
			    idthere=idnew;
		   }
		   
		   break;
	   }
	   case 2:
	   {
			  
			   System.out.println("Previous age: "+agethere);
			   System.out.println("Want to change?(y/n)");
			   String c=in.readLine();
			   if((c.charAt(0)=='y')||(c.charAt(0)=='Y'))
			   {
				   System.out.println("Enter Age:");
				   agenew=Integer.parseInt(in.readLine());
				   agethere=agenew;
			   }
		   break;
	   }
	   case 3:
	   {
			  
			   System.out.println("Previous Position: "+posthere);
			   System.out.println("Want to change?(y/n)");
			   String c=in.readLine();
			   if((c.charAt(0)=='y')||(c.charAt(0)=='Y'))
			   {
				   System.out.println("Enter Position:");
				   String posnew=in.readLine();
                    posthere=posnew;
			   }
		   break;
	   }
	   case 4:
	   {
			 
			   System.out.println("Previous Address: "+addthere);
			   System.out.println("Want to change?(y/n)");
			   String c=in.readLine();
			   if((c.charAt(0)=='y')||(c.charAt(0)=='Y'))
			   {
				   System.out.println("Enter Address:");
				   String addnew=in.readLine();
				   addthere=addnew;
			   }
		   break;
	   }
	   case 5:
	   {

			 
			   System.out.println("Previous Basic Salary: "+bsthere);
			   System.out.println("Want to change?(y/n)");
			   String c=in.readLine();
			   if((c.charAt(0)=='y')||(c.charAt(0)=='Y'))
			   {
				   System.out.println("Enter Basic Salary:");
				   double bsnew=Double.parseDouble(in.readLine());
                       bsthere=bsnew;
			   }
		   break;
	   }
	   case 6:
	   {
			   System.out.println("Previous Deduction: "+detthere);
			   System.out.println("Want to change?(y/n)");
			   String c=in.readLine();
			   if((c.charAt(0)=='y')||(c.charAt(0)=='Y'))
			   {
				   System.out.println("Enter Deduction:");
				   double detnew=Double.parseDouble(in.readLine());

	              detthere=detnew;

			   }
		   break;
	   }
	   case 7:
	   {
		   int flag=0;String emailnew="";

		   System.out.println("Previous Email Id: "+emailthere);
		   System.out.println("Want to change?(y/n)");
		   String c=in.readLine();
		   if((c.charAt(0)=='y')||(c.charAt(0)=='Y'))
		   {
			   while(flag!=1)
			   {
			   System.out.println("Enter Email Id:");
			   emailnew=in.readLine();
			   emailthere=emailnew;
			   if(rv.validEmail(emailnew))
			   {
				   flag=1;
			   }
			   else
				   System.out.println("Enter a valid Email Id");
			   }
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
		XSSFRow row=ms.createRow(j);
		Cell cell1=row.createCell(7);
		cell1.setCellValue((Double) sc.salaryCalcutaions(bsthere,detthere));
		Cell cell2=row.createCell(0);
		cell2.setCellValue((String) name);
		Cell cell3=row.createCell(1);
		cell3.setCellValue((int) idthere);
		Cell cell4=row.createCell(2);
		cell4.setCellValue((int) agethere);
		Cell cell5=row.createCell(3);
		cell5.setCellValue((String) posthere);
		Cell cell6=row.createCell(4);
		cell6.setCellValue((String) addthere);
		Cell cell7=row.createCell(5);
		cell7.setCellValue((Double) bsthere);
		Cell cell8=row.createCell(6);
		cell8.setCellValue((Double) detthere);
		Cell cell9=row.createCell(8);
		cell9.setCellValue((String) emailthere);
		Cell cell10=row.createCell(9);
		cell10.setCellValue((String) pass);
		FileOutputStream os = new FileOutputStream(myFile);
       myWorkBook.write(os);
       System.out.println("Done");
       os.flush();
       os.close();
	   System.out.println("Employee Name: "+(ms.getRow(j).getCell(0)).toString());
	   id=(int)Double.parseDouble((ms.getRow(j).getCell(1)).toString());
       System.out.println("Employee Id: "+(id));
       int age=(int)Double.parseDouble((ms.getRow(j).getCell(2)).toString());
       System.out.println("Employee Age: "+age);
       System.out.println("Employee Position: "+(ms.getRow(j).getCell(3)).toString());
       System.out.println("Employee Email:"+(ms.getRow(j).getCell(8)).toString());
       System.out.println("Employee Address: "+(ms.getRow(j).getCell(4)).toString());
       System.out.println("Employee Basic Salary: "+(ms.getRow(j).getCell(5)).toString());
       System.out.println("Employee Deduction: "+(ms.getRow(j).getCell(6)).toString());
       System.out.println("Employee Take Home Salary: "+(ms.getRow(j).getCell(7)).toString());
	   myWorkBook.close();
	   fis.close();
   }

}
