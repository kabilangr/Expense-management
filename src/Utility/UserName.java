package Utility;

import java.io.File;
import java.io.FileInputStream;




import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class UserName 
{

	String name;
	String password;
	int f;
	public String getName() {
		return name;
	}
	public void setName(String n)throws Exception {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		int rd=mySheet.getLastRowNum();
		String str="",st;
		for(int i=1;i<=rd;i++)
		{
			str=mySheet.getRow(i).getCell(0).toString();
			st=mySheet.getRow(i).getCell(8).toString();
			if(n.equals(str)){
				this.f=i;
				this.name=str;
				break;
			}
			if(n.equals(st))
			{
				this.f=i;
				this.name=st;
				break;
			}
		}
		   myWorkBook.close();
		   fis.close();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword()throws Exception {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		try{
			this.password = (mySheet.getRow(f).getCell(9)).toString();
			}
		catch(NullPointerException e)
		{
		   this.password="";
		   System.out.println("You need to SignUp First");
		}
		   myWorkBook.close();
		   fis.close();
	}
}
