package jdbcQuestions;
import java.sql.*;
import java.util.Scanner;

/*
SQL> select * from jdbc_bank_account;

ACNO HOLDERNAME         BALANCE
---------- --------------- ----------
1001 Billa                10000
1002 Gotya                20000

SQL> select * from product;

PID PNAME                     PRICE        QTY
---------- -------------------- ---------- ----------
  1 table                      9000         10
  2 chair                      8000          3
  3 sofa                      18000          3

*/
public class SavePointOnlineShopping {

	private static final String PURCHASE_PRODUCT_QUERY= "UPDATE PRODUCT SET QTY = QTY - 1 WHERE PID = ?" ;
	private static final String PAYMENT_QUERY = "UPDATE JDBC_BANK_ACCOUNT SET BALANCE= BALANCE-(SELECT PRICE FROM PRODUCT WHERE PID =?)WHERE ACNO=?";
	

	public static void main(String[] args) {
		
		Scanner sc = null;
		int pid = 0;
		int acno = 0;
		Connection con = null;
		PreparedStatement ps1 = null,ps2=null;
		int result1 = 0 , result2 = 0;
		Savepoint sp = null;
		try {
			sc = new Scanner(System.in);
			if(sc != null) {
				System.out.println("Enter product id :");
				pid = sc.nextInt();
				System.out.println("Enter bank account number :");
				acno = sc.nextInt();
			}	
				Class.forName("oracle.jdbc.OracleDriver");
				con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mydba","abcd");
				con.setAutoCommit(false);
				
				if(con != null) {
				ps1 = con.prepareStatement(PURCHASE_PRODUCT_QUERY);
				ps2 = con.prepareStatement(PAYMENT_QUERY);
				}
				if(ps1 != null) {
				   ps1.setInt(1, pid);
				   result1 = ps1.executeUpdate();
				   }
				
   // CREATE NAMEES SAVE POINT
				if (con!= null)
					sp = con.setSavepoint("sp1");
				
				if(ps2 != null) {
					ps2.setInt(1, pid);
					ps2.setInt(2, acno);
					result2 = ps2.executeUpdate();  
				}
				if(result1 == 1 && result2 == 1) {
					con.commit();
					System.out.println("Tx Commited, Purchase and payment is done");
				}
				else if (result1 == 0) {
					con.rollback();
					System.out.println("Tx Rollback because product is not Available");
				}
				else if (result1== 1 && result2 ==0) {
					con.rollback(sp);
					con.commit();
					System.out.println("Purchase is done , Payment is failed , so Cash On Delivery is enabled");
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
				if(ps2 != null)
					ps2.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps1 != null)
					ps1.close();
			}
			catch(SQLException se) {
				se.printStackTrace(); 
			}
			try {
				if(con != null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc != null)
					sc.close();
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
