package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Create a connection
 * 2. Create a statement/Quary
 * 3. Execute statement/Query
 * 4. Store the result in result set
 * 4. Close connection
 */

public class MySQLDMLCommands {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		
		//Load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pratixadb1", "root", "root");
		
		//3. Create statement/Quary
		 Statement ps = con.createStatement();
		 String s = "INSERT INTO STUDENT VALUES(13, 'Smit')";
		 String s1 = "SELECT * from student"; 
		//String s=;
		
		//4. and 5. Execute statement/Query and store data in result set
		ps.execute(s);
		ResultSet r=ps.executeQuery(s1);
		while(r.next()) {
			int id=r.getInt("StudentID");
			String sName = r.getString("StudentName");
			System.out.println("Student id : " + id + "Student name :" + sName);
		}
		
		//6. Close connection
		con.close();
		
		System.out.println("Query executed........");
	}

}
