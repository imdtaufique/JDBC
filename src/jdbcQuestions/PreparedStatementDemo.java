package jdbcQuestions;
import java.util.Scanner;
import java.sql.*;

public class PreparedStatementDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");	
		
		String sqlQuery = "insert into employee values (?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter the number of the employee");
			int eno = sc.nextInt();
			
			System.out.println("Enter the name of the employee");
			String ename = sc.next();
			
			System.out.println("Enter the salary of the employee");
			double esal = sc.nextDouble();
			
			System.out.println("Enter the address of the employee");
			String eadd = sc.next();
			
			pst.setInt(1, eno);
			pst.setString(2, ename);
			pst.setDouble(3, esal);
			pst.setString(4, eadd);
			
			pst.executeUpdate();
			
			System.out.println("One rows inserted Successfully");
			System.out.println("Do you wants to insert one more row");
			String opt =sc.next();
			
			if(opt.equalsIgnoreCase("No")) {
				break;
			}
			
		}
		con.close();
	}

}
