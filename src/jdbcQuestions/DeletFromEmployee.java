package jdbcQuestions;
import java.sql.*;
public class DeletFromEmployee {

	public static void main(String[] args) throws Exception{
	
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		Statement st = con.createStatement();
		st.executeUpdate("delete from employee where ename= 'pilla'");
		System.out.println("One rows deleted");
		con.close();
		
				

	}

}
