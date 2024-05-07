package admincred;

import java.sql.SQLException;
import java.util.Scanner;

public class adminHome {
	adminRegistration ar = new adminRegistration();
	adminEmployeeRegister aer = new adminEmployeeRegister();
	public void home(PayPojoAdmin p) throws ClassNotFoundException, SQLException {
		Scanner sh = new Scanner(System.in);
		System.out.println("--------Admin Portal--------");
		System.out.println("Choose Services :");
		System.out.println("1.New Admin Register \n2.Employee register");
		char ah = sh.next().charAt(0);
		switch(ah) {
		case '1':
			ar.adminRegister(p);
			break;
		case '2':
			System.out.println("Employee CDUR Portal(admin access only)");
			System.out.println("1.Create/Register \n2.Delete \n3.Update \n4.Read/Show");
			char ecp =sh.next().charAt(0);
			switch(ecp) {
			case '1':
				aer.Register(p);
				break;
			case '2':
				aer.Delete(p);
				break;
			case '3':
				aer.Update(p);
				break;
			case '4':
				aer.ShowList();
				break;
			}
		}
	}

}
