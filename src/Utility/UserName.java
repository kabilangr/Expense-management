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
		XSSFSheet mySheet = myWorkBook.getSheetAt(1);
		int rd=mySheet.getLastRowNum();
		String str="",st;
		for(int i=1;i<rd;i++)
		{
			str=mySheet.getRow(i).getCell(0).toString();
			st=mySheet.getRow(i).getCell(8).toString();
			if(n.equals(str)){
				f=i;
				this.name=str;
				break;
			}
			if(n.equals(st))
			{
				f=i;
				this.name=st;
				break;
			}
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword()throws Exception {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(1);
		this.password = (mySheet.getRow(f).getCell(9)).toString();
	}

}
