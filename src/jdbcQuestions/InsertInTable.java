package jdbcQuestions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import java.sql.DriverManager;

public class InsertInTable {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
			PreparedStatement pst= con.prepareStatement("insert into emp values(?,?,?)");
			
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			
			while(true) {
				System.out.print("Enter Employee id : ");
				int eno = Integer.parseInt(br.readLine());
				
				System.out.print("Enter Employee Name : ");
				String ename = br.readLine();
				
				System.out.print("Enter Employee Salary : ");
				double sal = Double.parseDouble(br.readLine());
				
				pst.setInt(1, eno);
				pst.setString(2, ename);
				pst.setDouble(3, sal);
		
				pst.executeUpdate();
				
				
				System.out.println("One record entered successfully..");
				System.out.println("Do yo want to insert more records[Yes/No]");
				
				String ch = br.readLine();
				if(ch.equalsIgnoreCase("no"))
				break;
			}
			con.close();

		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
