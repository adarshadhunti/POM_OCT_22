package resources;

import pages.BasePage;

import java.sql.*;

public class updatedb {

    public static void DBupdate(String table,String tocity , String fromcity) throws SQLException {
        String host = BasePage.getvalue("dbhost");
        String port = BasePage.getvalue("dbport");
        String username = BasePage.getvalue("dbuser");
        String password = BasePage.getvalue("dbpassword");
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/sampledb", username, password);
        Statement s = con.createStatement();
        String staments="update "+table+" set city= '" +tocity+"' where city= '"+fromcity+"'";
        System.out.println(staments);
        s.executeUpdate(staments);
        con.close();
    }
}
