package DAO;

public class SalaryCalculator 
{
	double medicalAllowance=4000;double gross=0;
	public double salaryCalcutaions(double basicSalary,double  deductions)
	{
		//Gross Salary = Basic Salary (BS) - Employer's PF Contribution(EPF)
		gross=basicSalary+medicalAllowance-(0.0367*basicSalary);
		 if(((gross*12)>=250000)&&((gross*12)<500000))
			gross=gross-(0.05*gross);
		else if(((gross*12)>=500000)&&((gross*12)<1000000))
			gross=gross-(0.2*gross);
		else if(((gross*12)>=1000000))
			gross=gross-(0.3*gross);
		else 
			gross=gross-0;
		return gross;
	}
}
