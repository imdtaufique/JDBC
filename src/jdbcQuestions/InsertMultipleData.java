package jdbcQuestions;
import java.sql.*;
import java.util.Scanner;

public class InsertMultipleData {

	public static void main(String[] args) throws Exception {
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
	Statement st = con.createStatement();
	
	Scanner sc = new Scanner(System.in);
	
	while(true) {
		System.out.println("Enter employee number :");
		int eno = sc.nextInt();
		
		System.out.println("Enter Employee Name : ");
		String ename= sc.next();
		
		System.out.println("Enter employee salary :");
		Double esal= sc.nextDouble();
		
		String sqlQuery = String.format("insert into emp values (%d,%s,%f)", eno, ename, esal);
		
		st.executeUpdate(sqlQuery);
		System.out.println("Record inserted successfully...");
		
		System.out.println("Do you want to isert one more record[Yes/No]: ");
		String option = sc.next();
		
		if(option.equalsIgnoreCase("no")) {
			break;
		}
	}
	con.close();
	}

}
