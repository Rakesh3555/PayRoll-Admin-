package admincred;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;


public class adminDB {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {


		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/PayrollApp", "root", "root");
		return connection;

	}

	
	
	public static void payAdminData(PayPojoAdmin p) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
	

		String query =" insert into userDataList values (?,?,?,?,?)";

		PreparedStatement prep = connection.prepareStatement(query);

		prep.setInt(1, 0);
		prep.setString(2,p.getUserName());
		prep.setString(3,p.getPassword());
		prep.setString(4,p.getMailId());
		prep.setString(5,p.getDepartment());


		int rows = prep.executeUpdate();
		System.out.println("Rows Affected : " + rows);
	}
	
	
	
	public static void employeeDeletion(PayPojoAdmin p) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "delete from userDataList where username = '?' and pasword = '?'";
		PreparedStatement del = connection.prepareStatement(query);
		
		del.setString(1,p.getUserName());
		del.setString(2,p.getPassword());
		
		int rows = del.executeUpdate();
		System.out.println("Rows Affected : " + rows);

	}
	
	
	public static void employeeUpdation(PayPojoAdmin p) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "update userdataList set  username = '?' , pasword = '?' , mailId = '?' , department = '?'\r\n" + "where EmpId = '?';";
		PreparedStatement update = connection.prepareStatement(query);
		
		update.setString(1,p.getUserName());
		update.setString(2,p.getPassword());
		update.setString(3,p.getMailId());
		update.setString(4,p.getDepartment());
		update.setString(5,p.getEmpId());
		
		int rows = update.executeUpdate();
		System.out.println("Rows Affected : " + rows);
	}
	
	public static void show() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		String query = "Select * from userDataList";
		PreparedStatement showList = connection.prepareStatement(query);
		ResultSet rows = showList.executeQuery();
		
		ResultSetMetaData metaData = (ResultSetMetaData) rows.getMetaData();
		
		int cCount = metaData.getColumnCount();
		for(int i = 1 ; i <= cCount ; i+=1) {
			System.out.print(metaData.getColumnName(i) + "\t");
		}
		System.out.println();
		while(rows.next()) {
			for(int i = 1 ; i <= cCount ; i+=1) {
				System.out.print(rows.getString(i) + "\t" );
			}
			System.out.println();
		}
		
	}

	public static Connection adminCredDb() throws ClassNotFoundException, SQLException {

		Connection adminDb = DriverManager.getConnection("jdbc:mysql://localhost:3308/AdminCred", "root", "root");
		return adminDb;

	}

	public static void AdminCred(PayPojoAdmin p) throws ClassNotFoundException, SQLException {
		Connection adminDb = adminCredDb();


		String query = "insert into AdminLog values (?,?,?,?)";
		PreparedStatement prepareAdminReg = adminDb.prepareStatement(query);
		prepareAdminReg.setInt(1, 0);
		prepareAdminReg.setString(2, p.getAdId());
		prepareAdminReg.setString(3, p.getAdName());
		prepareAdminReg.setString(4, p.getAdPass());

		int rows = prepareAdminReg.executeUpdate();
		System.out.println("Rows Affected : " + rows);

		
	}


}
