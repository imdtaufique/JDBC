package jdbcQuestions;
import java.sql.*;
public class SelectTable {

	public static void main(String[] args) throws Exception {
	
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "mydba","abcd");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from emp");
		
		while(rs.next()) {
			int eid = rs.getInt(1);
			String ename= rs.getString(2);
			double esal= rs.getDouble(3);
			
			System.out.println("Emp Id : "+ eid );
			System.out.println("Emp Name :"+ ename);
			System.out.println("Emp sal..:"+ esal);
			System.out.println("\n");
		}

	}

}
