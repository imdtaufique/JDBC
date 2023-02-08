package jdbcQuestions;
import java.sql.*;
import java.sql.DriverManager;

public class StoredProcedure1 {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		CallableStatement cst = con.prepareCall("{call sum (?,?,?)}");
		cst.setInt(1, 100);
		cst.setInt(2, 250);
		cst.registerOutParameter(3, Types.INTEGER);
		cst.execute();
		int result = cst.getInt(3);
		System.out.println("Result : " +result);
		con.close();
		
	}

}
