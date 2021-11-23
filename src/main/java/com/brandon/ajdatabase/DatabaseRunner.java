package com.brandon.ajdatabase;

import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseRunner {



    public static void main(String[] args) {
        new DatabaseRunner();
    }

    private DatabaseRunner() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM test");

            while(rs.next()){
                System.out.println(rs.getString(2));
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) { } // ignore

                stmt = null;
            }
        }
    }
}
