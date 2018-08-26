import java.sql.*;

public class Dbconn {

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost/test";
	final String USER = "root";
	final String PASS = "";

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Connection connectDb() {
		try {

			Class.forName(JDBC_DRIVER);
			try {
				System.out.println("Connecting to Database...");
				con = DriverManager.getConnection(DB_URL, USER, PASS);
				return con;

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void insertData(int index, String name, String mobile, String eAddress) {
		try {
			System.out.println("Creating Statement...");
			stmt = con.createStatement();
			System.out.println("Executing SQL...");
			String querry = "INSERT INTO StudentDetails VALUES (" +index +",'" + name + "','" + mobile + "','" + eAddress + "')";
			stmt.executeUpdate(querry);
			System.out.println("Insert Recode Successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String[] getData(int index) {
		String[] dataSet = new String[4];
		ResultSet data = null;
		try {
			System.out.println("Creating Statement...");
			stmt = con.createStatement();
			System.out.println("Executing SQL...");
			String querry;
			querry = "SELECT * FROM StudentDetails WHERE indexNo=" + index;
			data = stmt.executeQuery(querry);
			System.out.println("Retrived Recode Successfully...");

			while (data.next()) {
				dataSet[0] = data.getString("indexNo");
				dataSet[1] = data.getString("name");
				dataSet[2] = data.getString("mobile");
				dataSet[3] = data.getString("eaddress");
				System.out.println("data extracted Successfully...");
			}
			return dataSet;
		} catch (Exception e) {
			e.printStackTrace();
			dataSet[0] = "-1";
			return dataSet;
		}

	}
}
