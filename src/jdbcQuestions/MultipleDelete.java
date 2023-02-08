package jdbcQuestions;
import java.sql.*;
import java.util.Scanner;


public class MultipleDelete {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id you wants to delete :");
		int id  = sc.nextInt();
		st.executeUpdate("delete from employee where eid = %s");
		System.out.println("one rows deleted");
		

	}

}
