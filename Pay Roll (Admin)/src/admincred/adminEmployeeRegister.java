package admincred;

import java.sql.SQLException;
import java.util.Scanner;

public class adminEmployeeRegister {
	Scanner uc = new Scanner(System.in);

	public void Register(PayPojoAdmin p) throws ClassNotFoundException, SQLException {

		while(true) {
			System.out.println("Employee Registration");
			String gMail;
			String gMailVal = "[a-z@.]{4,16}";
			System.out.println("Enter e-mailId : ");
			gMail = uc.next();
			p.setMailId(gMail);
			if(gMail.matches(gMailVal)){

				String userName="";
				String userNameVal = "[a-zA-Z]{4,16}";
				System.out.println("Enter username  : ");
				userName = uc.next();

				while(!userName.matches(userNameVal))
				{
					System.err.println("Invalid Data\nenter it again: ");
					userName = uc.next();
				}
				while(userName.matches(userNameVal)) {
					p.setUserName(userName);
					String userPass="";
					String userPassVal = "[a-zA-Z0-9]{4,16}";
					System.out.println("Enter your password :");
					userPass = uc.next();
					while(!userPass.matches(userPassVal)) 
					{
						System.err.println("Invalid Data\nenter it again :");
						userPass = uc.next();
					}
					while(userPass.matches(userPassVal)) {
						p.setPassword(userPass);
						String reUserPass="";
						System.out.println("Re-enter password : ");
						reUserPass = uc.next();
						while(!reUserPass.equals(userPass)) 
						{
							System.err.println("Invalid data\nenter it again :");
							reUserPass = uc.next();
						}	
						while(reUserPass.equals(userPass)) {
							System.out.println("Choose your Department :");
							System.out.println("1.Developer \n2.Testing \n3.Support ");
							char dc = uc.next().charAt(0);
							switch(dc) {
							case '1':
								p.setDepartment("developer");
								break;
							case '2':
								p.setDepartment("testing");
								break;
							case '3':
								p.setDepartment("support");
								break;
							}
							System.out.println("UserName : "+p.getUserName());
							System.out.println("Mail Id : "+p.getMailId());
							System.out.println("Department : "+p.getDepartment());

							adminDB.payAdminData(p);
							break;	
						}
						break;
					}
					break;
				}
				break;
			}
			break;
		}

	}

	public void Delete(PayPojoAdmin p) throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter Employee Name : ");
		String userName = uc.next();
		p.setUserName(userName);
		System.out.println("Enter Password :");
		String userPass = uc.next();
		p.setPassword(userPass);
		adminDB.employeeDeletion(p);
		
	}
	
	public void Update(PayPojoAdmin p) throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter Employee Name : ");
		String userName = uc.next();
		p.setUserName(userName);
		System.out.println("Enter Password : ");
		String userPass = uc.next();
		p.setPassword(userPass);
		System.out.println("Enter MailId : ");
		String gMail = uc.next();
		p.setMailId(gMail);
		System.out.println("Enter EmployeeId : ");
		String empId = uc.next();
		p.setEmpId(empId);
		System.out.println("Choose your Department :");
		System.out.println("1.Developer \n2.Testing \n3.Support ");
		char dc = uc.next().charAt(0);
		switch(dc) {
		case '1':
			p.setDepartment("developer");
			break;
		case '2':
			p.setDepartment("testing");
			break;
		case '3':
			p.setDepartment("support");
			break;
		}
		adminDB.employeeUpdation(p);	
	}
	public void ShowList() throws ClassNotFoundException, SQLException {
		adminDB.show();
		
		
	}

}

