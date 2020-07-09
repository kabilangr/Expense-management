package DAO;


public class RegistrationValidation
{
	public boolean checkUserDetails(String email, String password, String confirmPassword)
	{
		if((validPassword(password,confirmPassword))&&(validEmail(email)))
		{
			return true;
		}
		return false;
	}
	private boolean validPassword(String password, String confirmPassword)
	{
		char ch=0;int k=0,c=0,n=0,s=0;
		for(int i=0;i<password.length();i++)
		{
			ch=password.charAt(i);
			if(Character.isUpperCase(ch))
				k=1;
			else if(Character.isLowerCase(ch))
				c=1;
			else if((ch>=48)&&(ch<=57))
				n=1;
			else
				s=1;
		}
		if((k!=0)&&(c!=0)&&(n!=0)&&(s!=0)&&(password.equals(confirmPassword)))
		{
			return true;
		}
		return false;
	}
	private boolean validEmail(String email) {
		int k=0;int c=0;char ch=0;
		if(email=="")
			return false;
		else 
		{ 
			for(int i=0;i<email.length();i++)
			{ch=email.charAt(i);
				if((ch=='@')||(ch=='_')||(ch=='.'))
					k=k+1;
				else if(((ch>=65)&&(ch<=90))||((ch>=97)&&(ch<=122))||((ch>=48)&&(ch<=57)))
				{
					c=2;
				}
				else
					return false;
			}
			if((k>=2 )&&(c==2))
				return true;
			return false;
		}
	}
}