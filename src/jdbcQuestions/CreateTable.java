package jdbcQuestions;
import java.sql.*;
import java.sql.DriverManager;

public class CreateTable{
	
		public static void main(String [] args) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
				Statement st = con.createStatement();
				st.executeUpdate("create table emp(eno number, ename varchar(15), esal number)");
				System.out.println("Table created Successfully.....");
				con.close();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
