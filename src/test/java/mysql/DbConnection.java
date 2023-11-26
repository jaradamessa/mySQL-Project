package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://3.88.236.96:3306/ecommerce", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("select* from eproduct;");

		while (result.next()) {
			System.out.println("   ");
			System.out.print(" Product Id " + result.getInt("Id"));
			System.out.print(" Product name " + result.getString("name"));
			System.out.print(" Product price " + result.getDouble("price"));
			System.out.print(" Product date_added " + result.getString("date_added"));
			System.out.println("==========Data====== =");

		}

		stmt.executeUpdate("insert into eproduct (name, price, date_added) values('Television', 15000.00, now())");
		result = stmt.executeQuery("select* from eproduct;");

		while (result.next()) {
			System.out.println("   ");
			System.out.print(" Product Id " + result.getInt("Id"));
			System.out.print(" Product name " + result.getString("name"));
			System.out.print(" Product price " + result.getDouble("price"));
			System.out.print(" Product date_added " + result.getString("date_added"));
			System.out.println("==========Adding new data====== =");

		}

		stmt.executeUpdate("delete from eproduct where name= 'Television';");
		result = stmt.executeQuery("select* from eproduct;");

		while (result.next()) {
			System.out.println("   ");
			System.out.print(" Product Id " + result.getInt("Id"));
			System.out.print(" Product name " + result.getString("name"));
			System.out.print(" Product price " + result.getDouble("price"));
			System.out.print(" Product date_added " + result.getString("date_added"));
			System.out.println("===========Delete======");

		}

		stmt.executeUpdate("update eproduct set price= '6000.00' where name = 'Mobile'");
		result = stmt.executeQuery("select* from eproduct;");

		while (result.next()) {
			System.out.println("   ");
			System.out.print(" Product Id " + result.getInt("Id"));
			System.out.print(" Product name " + result.getString("name"));
			System.out.print(" Product price " + result.getDouble("price"));
			System.out.print(" Product date_added " + result.getString("date_added"));
		}
		System.out.println("========Change======");

		con.close();
	}

}
