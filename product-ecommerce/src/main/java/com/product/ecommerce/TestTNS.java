/**
 * 
 */
package com.product.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author admin
 *
 */
public class TestTNS {

	public static void main(String[] args) throws Exception {
		// tell the driver where to look for the TNSNAMES.ORA file
		System.setProperty("oracle.net.tns_admin",
				"C:\\FortyTwo42\\Work-Area\\Soft\\WINDOWS.X64_193000_db_home\\network\\admin");

		// ORCL is net service name from the TNSNAMES.ORA file
		String dbURL = "jdbc:oracle:thin:@ORCLPDB";

		// load the driver
		Class.forName("oracle.jdbc.OracleDriver");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(dbURL, "hr", "hr123");

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT 1 FROM dual");

			if (rs.next()) {
				System.out.println("Dummy is equal to: " + rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}

}
