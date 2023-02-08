package jdbcQuestions;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class SelectEmployee {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");
		
		while(rs.next()) {
			int eid = rs.getInt(1);
			String ename = rs.getString(2);
			double esal = rs.getDouble(3);
			String eadd = rs.getString(4);
			
			
			
			System.out.println("Employee id : "+ eid );
			System.out.println("Employee name : "+ ename);
			System.out.println("Employee salary : "+ esal);
			System.out.println("Employee address : "+ eadd);
			System.out.println("\n");
			
			
		}
		con.close();
	}

}
