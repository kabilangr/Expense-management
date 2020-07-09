package Model;
public class Employee 
{
private String employeeName;
private int id;
private int age;
private String position;
private String address;
private double basicSal;
private double deductions;
public Employee(String employeeName, int id, int age, String position, String address, double basicSal,
		double deductions) 
{
	this.employeeName = employeeName;
	this.id = id;
	this.age = age;
	this.position = position;
	this.address = address;
	this.basicSal = basicSal;
	this.deductions = deductions;
}
public String getEmployeeName() 
{
	return employeeName;
}
public void setEmployeeName(String employeeName) 
{
	this.employeeName = employeeName;
}
public int getId() 
{
	return id;
}
public void setId(int id) 
{
	this.id = id;
}
public int getAge() 
{
	return age;
}
public void setAge(int age) 
{
	this.age = age;
}
public String getPosition() 
{
	return position;
}
public void setPosition(String position) 
{
	this.position = position;
}
public String getAddress() 
{
	return address;
}
public void setAddress(String address) 
{
	this.address = address;
}
public double getBasicSal() 
{
	return basicSal;
}
public void setBasicSal(double basicSal) 
{
	this.basicSal = basicSal;
}
public double getDeductions() 
{
	return deductions;
}
public void setDeductions(double deductions) 
{
	this.deductions = deductions;
}
}
