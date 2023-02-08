package jdbcQuestions;
import java.sql.*;

public class UpdateEmployee {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		Statement st = con.createStatement();
		st.executeUpdate("update employee set ename ='Bachi' where eadd= 'bhopal'");
		System.out.println("one row updated");
	}

}
