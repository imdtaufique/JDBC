package jdbcQuestions;
import java.sql.*;
import java.util.Scanner;

public class Application_14 {

	public static void main(String[] args) throws Exception{
	
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner("System.in");
		System.out.println("Enter initial character of employee name : ");
		String initialChar = sc.next()+ "%";
		String sqlQuery = String.format("select * form employee where ename like '%s'",initialChar);
		
		boolean flag = false;
		ResultSet rs = st.executeQuery(sqlQuery);
		
		System.out.println("EID\tENAME\tESAL\tEADD");
		System.out.println("------------------------");
		while(rs.next()) {
			flag = true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		if( flag == false) {
			System.out.println("No record Found ");
		}
		con.close();
	}

}
