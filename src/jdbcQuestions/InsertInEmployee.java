package jdbcQuestions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import java.sql.DriverManager;

public class InsertInEmployee {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
		PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)");
		BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
		
		while(true) {
			System.out.println("Enter Employee id");
			int eid = Integer.parseInt(br.readLine());
			
			System.out.println("Enter employee name");
			String ename = br.readLine();
			
			System.out.println("Enter employee salary");
			double esal = Double.parseDouble(br.readLine());
			
			System.out.println("Enter employee address");
			String eadd = br.readLine();
			
			pst.setInt(1, eid);
			pst.setString(2, ename);
			pst.setDouble(3, esal);
			pst.setString(4, eadd);
			
			pst.executeUpdate();
			
			System.out.println("One record entered successfully....");
			System.out.println("Do you want to insert one more record [ Yes/No ]");
			
			String ch = br.readLine();
			if(ch.equalsIgnoreCase("no"))
				break;
			
		}
		con.close();

	}

}
