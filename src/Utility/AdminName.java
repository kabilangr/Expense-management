package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class AdminName 
{

	String name;
	String password;
	public String getName() {
		return name;
	}
	public void setName()throws Exception {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(2);
		this.name = mySheet.getRow(0).getCell(0).toString();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword()throws Exception {
		File myFile = new File("./Check.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(2);
		this.password = (mySheet.getRow(0).getCell(1)).toString();
	}

}
