package jdbcQuestions;
import java.sql.*;
public class Application_12 {

	public static void main(String[] args) throws Exception{
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		Statement st= con.createStatement();
		String sqlQuery = "select ename,esal from employee";
		
		boolean flag = false;
		ResultSet rs = st.executeQuery(sqlQuery);
		
		System.out.println("ENAME \t ESAL");
		System.out.println("-------------");
		
		while(rs.next()) {
			flag = true;
			System.out.println(rs.getString("ename")+"\t"+ rs.getInt("esal"));
		}
		if( flag == false) {
			System.out.println("No records found");
		}
		con.close();
	}

}
