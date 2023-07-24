package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {


	public void KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Xong b1");
			String url = "jdbc:sqlserver://PHAN-DUC;databaseName=QlSach";
			String user = "sa";
			String pass = "123";
			Connection cn = DriverManager.getConnection(url,user,pass);
			System.out.println("Xong b2");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
