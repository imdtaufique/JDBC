package jdbcQuestions;
import java.sql.*;
public class JdbcMysqlDemo {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///mtadb","root","root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employees ");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+".."+rs.getString(2)+".."+rs.getDouble(3)+".."+rs.getString(4));
		}
		con.close();
	}

}
