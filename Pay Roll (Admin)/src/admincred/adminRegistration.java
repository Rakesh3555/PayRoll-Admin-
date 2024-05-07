package admincred;

import java.sql.SQLException;
import java.util.Scanner;

public class adminRegistration {
	
	public void adminRegister(PayPojoAdmin p) throws ClassNotFoundException, SQLException {
		Scanner ar = new Scanner(System.in);
		
		while(true) {
			String adIdVal = "[A-Za-z]{4}[0-9]{4}";
			System.out.println("Enter AdminID : ");
			String adId = ar.next();
			while(!adId.matches(adIdVal)) {
				System.err.println("Invalid Input\nEnter Valid ID :");
				adId = ar.next();
			}while(adId.matches(adIdVal)){
				p.setAdId(adId);
			String adNameVal = "[A-Za-z]{4,24}";
			System.out.println("Enter Admin name :");
			String adName = ar.next();
			while(adName.matches(adNameVal)) {
				p.setAdName(adName);
				String AdminPassVal = "[A-Za-z0-9]{4,16}";
				System.out.println("Enter Admin Password : ");
				String adPass = ar.next();
				while(!adPass.matches(adNameVal)) {
					System.out.println("Invalid input ! \nEnter Valid Password :");
					adPass = ar.next();
				}while(adPass.matches(adNameVal)) {
					p.setAdPass(adPass);
					System.out.println("Successfully Register !");
					adminDB.AdminCred(p);
					break;
				}
				break;
			}
			break;
			}
			break;
		}
	}
}


