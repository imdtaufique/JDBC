package jdbcQuestions;
import java.sql.*;
import java.sql.DriverManager;

public class StoredProcedure3 {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		CallableStatement cst = con.prepareCall("{call getEmpInfo(?,?,?)}");
		cst.setInt(1, 2);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.registerOutParameter(3, Types.FLOAT);
		cst.execute();
		System.out.println("Employee name is : "+ cst.getString(2));
		System.out.println("Employee salary is : " + cst.getFloat(3));
		con.close();
	}

}
