package src.com.vkkm.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getDBconnection(){
		Connection conn=null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			//conn=DriverManager.getConnection("jdbc:oracle:thin:@172.26.132.40:1521:orcl", "p27b", "p27b");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
		
	}
 public static void closeConnection(Connection conn){
	 try{
		 if(conn!=null){
			 conn.close();
		 }
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
}
