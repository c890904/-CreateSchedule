package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	protected static Connection getConnection() throws Exception{
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String usr = "postgres";
		String pwd = "postgres";
		
		Class.forName("org.postgresql.Driver");
		
		return DriverManager.getConnection(url, usr, pwd);
	}
}
