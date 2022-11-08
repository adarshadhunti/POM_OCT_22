package resources;

import pages.BasePage;

import java.sql.*;

public class jdbcconection {

    public static Object[][] DBread(String tablename) throws SQLException, ClassNotFoundException {
        String host = BasePage.getvalue("dbhost");
        String port = BasePage.getvalue("dbport");
        String username = BasePage.getvalue("dbuser");
        String password = BasePage.getvalue("dbpassword");
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/sampledb", "root", "root123");
        Statement s = con.createStatement();
        ResultSet rs1 = s.executeQuery("select count(*) from " + tablename );
        rs1.next();
        int noofrows=Integer.parseInt(rs1.getString(1));
        ResultSet rs = s.executeQuery("select * from " +tablename);
        ResultSetMetaData rsmd = rs.getMetaData();
        int column_count = rsmd.getColumnCount();
        String[][] data = new String[noofrows][column_count];
        int i = 0;
        while (rs.next()) {
            for (int j = 0; j < column_count; j++) {

                data[i][j] = rs.getString(j + 1);
            }
            i++;
        }
        con.close();
        return data;
    }
}
