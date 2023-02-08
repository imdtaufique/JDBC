package jdbcQuestions;
import java.util.*;
import java.sql.*;


import java.sql.*;
public class SQLInjection {

	public static void main(String[] args) throws Exception{
	
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name : ");
		String uname = sc.next();
		
		System.out.println("Enter the password : ");
		String upwd = sc.next();
		
		String sqlQuery = "select count (*) from users where uname = '"+uname+"' and upwd = '"+upwd+"'";
		
		ResultSet rs = st.executeQuery(sqlQuery);
		
		int c = 0;
		if(rs.next()) {
			c=rs.getInt(1);
		}
		if(c==0)
			System.out.println("Invalid credential");
		else
			System.out.println("valid credential");
		
		con.close();
		
	}

}


