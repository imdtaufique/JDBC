package jdbcQuestions;
import java.sql.*;
public class ResultSetMetaDataType {
private static final String GET_ALL_STUDENT_QUERY = "SELECT SNO, SNAME, SADD, AVG FROM STUDENT";
		
	public static void main(String[] args) {
	  
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd= null;
		int colCnt = 0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
			
			if(con != null ) 
				st= con.createStatement();
			if(st != null)
				rs = st.executeQuery(GET_ALL_STUDENT_QUERY );
			if(rs != null)
				rsmd = rs.getMetaData();
			//get columns counts
			if(rsmd != null)
				colCnt = rsmd.getColumnCount();
			//pprint column names
			if(rsmd != null) {
				for(int i = 1; i<=colCnt; ++i)
					System.out.print(rsmd.getColumnLabel(i)+ " ");
			}
			System.out.println();
			
			if(rs != null) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
