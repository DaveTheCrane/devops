import java.sql.*;

/** simple class to use on the command-line to test JDBC connections */
public class JdbcPing {
 
	public static void main( String args[]) {
		 
		int argLen=args.length;
		if (argLen<4 || argLen>5) {
			usage();
		} else {
			String driverClassName = args[0];
			String connectionURL = args[1];
			String user=args[2];
			String pwd=args[3];
			String testSql=(args.length==5) ? args[4] : "SELECT SUM(1);";
		 
			Connection con = null;
			try {
				Class.forName(driverClassName);
				con = DriverManager.getConnection(connectionURL,user,pwd);
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(testSql);
				int counter=0;
				while (rs.next()){
					counter++;
				}
				System.out.println(" - retrieved "+counter+" rows of data");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try{
					con.close();
				} catch (SQLException sqex2){
					System.out.println("Unable to close connection");
				}
			}
		}
	}

	/* print a simple help message */
	private static void usage() {
		System.out.println("Usage: java JbdcPing [driver] [connection url] [user] [password] [testSQL:optional]");
		System.out.println(" - driver class name e.g. org.postgresql.Driver");
		System.out.println(" - connection url e.g. jdbc:postgres://localhost/myDB");
		System.out.println(" - test SQL defaults to \"SELECT SUM(1)\"");
	}
}