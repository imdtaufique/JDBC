package jdbcQuestions;
import java.sql.*;
public class CreateTableEmployee {

	public static void main(String[] args) throws Exception {
	Class.forName("oracle.jdbc.OracleDriver");	
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "mydba","abcd");
	Statement st = con.createStatement();
	st.executeUpdate("create table employee( eno number, ename varchar2(15) , esal number , eadd varchar2(20))");
	System.out.println("Table created successfully...");
	con.close();

	}

}
