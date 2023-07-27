package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoidao {
  public Connection cn;

  public void KetNoi() {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      System.out.println("Đã nạp Driver");
      String url = "jdbc:sqlserver://PHAN-DUC:1433;databaseName=QLSach;user=sa;password=123";
      cn = DriverManager.getConnection(url);
      System.out.println("Đã kết nối");
    } catch (Exception tt) {
      // TODO Auto-generated catch block
    	tt.printStackTrace();
    	System.out.println(tt.getMessage());
    }
  }


}
