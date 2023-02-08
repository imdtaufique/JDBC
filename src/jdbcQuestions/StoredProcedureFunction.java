package jdbcQuestions;
import java.sql.*;
import java.sql.DriverManager;

public class StoredProcedureFunction {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		CallableStatement cst = con.prepareCall("{? = call getAvg(?,?)}");
		cst.setInt(2, 3);
		cst.setInt(3, 2);
		cst.registerOutParameter(1, Types.FLOAT);
		cst.execute();
		System.out.println("Salary is ...."+ cst.getFloat(1));

	}

}