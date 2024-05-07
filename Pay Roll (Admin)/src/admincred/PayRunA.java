package admincred;

import java.sql.SQLException;

public class PayRunA {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		adminHome ah = new adminHome();
		PayPojoAdmin p = new PayPojoAdmin();
		ah.home(p);
		

	}

}
