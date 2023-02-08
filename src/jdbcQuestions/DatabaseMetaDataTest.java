package jdbcQuestions;
import java.sql.*;
public class DatabaseMetaDataTest {

	public static void main(String[] args) {
		Connection con = null;
		DatabaseMetaData dbmd = null; 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
			dbmd = con.getMetaData();
			
			System.out.println("dbmd class name::"+dbmd.getClass());
			System.out.println("Database Softeare name:: "+dbmd.getDatabaseProductName());
			System.out.println("Database Software version::"+dbmd.getDatabaseProductVersion());
			System.out.println("Oracle major version::"+ dbmd.getDatabaseMajorVersion());
			System.out.println("Oracle minor version::" + dbmd.getDatabaseMinorVersion());
			System.out.println("Jdbc major version:: "+ dbmd.getJDBCMajorVersion());
			System.out.println("jdbc minor version:: "+ dbmd.getJDBCMinorVersion());
			System.out.println("JDBC driver version:: "+ dbmd.getDriverMajorVersion() + ". "+ dbmd.getDriverMinorVersion());
			System.out.println("All SQL keyword:: "+ dbmd.getSQLKeywords());
			System.out.println("All numeric function::"+ dbmd.getNumericFunctions());
			System.out.println("All System  function:: "+ dbmd.getSystemFunctions());
			System.out.println("All db table in select query::"+ dbmd.getMaxTablesInSelect());
			System.out.println("MAx chars in db table name::"+dbmd.getMaxTableNameLength());
			System.out.println("Max row size::"+ dbmd.getMaxRowSize());
			System.out.println("Support Procedures ?"+ dbmd.supportsStoredProcedures());
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(dbmd != null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		

	}

}
