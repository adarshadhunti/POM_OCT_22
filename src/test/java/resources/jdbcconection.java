package resources;

import pages.BasePage;

import java.sql.*;

public class jdbcconection {
    String  host,port,username,password;

    public static Object[][] DBread(String tablename) throws SQLException, ClassNotFoundException {
        jdbcconection jd=new jdbcconection();
        jd.host = BasePage.getvalue("dbhost");
        jd.port = BasePage.getvalue("dbport");
        jd.username = BasePage.getvalue("dbuser");
        jd.password = BasePage.getvalue("dbpassword");
        Connection con = DriverManager.getConnection("jdbc:mysql://" + jd.host + ":" + jd.port + "/sampledb", jd.username, jd.password);
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
    public static void DBupdate(String table,String tocity , String fromcity) throws SQLException {
        jdbcconection jd=new jdbcconection();
        jd.host = BasePage.getvalue("dbhost");
        jd.port = BasePage.getvalue("dbport");
        jd.username = BasePage.getvalue("dbuser");
        jd.password = BasePage.getvalue("dbpassword");
        Connection con = DriverManager.getConnection("jdbc:mysql://" + jd.host + ":" + jd.port + "/sampledb", jd.username, jd.password);
        Statement s = con.createStatement();
        String staments="update "+table+" set city= '" +tocity+"' where city= '"+fromcity+"'";
        System.out.println(staments);
        s.executeUpdate(staments);
        con.close();
    }

    public static void DBinsert(String table,String city , String noofcars) throws SQLException {
        jdbcconection jd=new jdbcconection();
        jd.host = BasePage.getvalue("dbhost");
        jd.port = BasePage.getvalue("dbport");
        jd.username = BasePage.getvalue("dbuser");
        jd.password = BasePage.getvalue("dbpassword");
        Connection con = DriverManager.getConnection("jdbc:mysql://" + jd.host + ":" + jd.port + "/sampledb", jd.username, jd.password);
        Statement s = con.createStatement();
        String staments="insert into "+table+ " values(\""+city+"\", \""+noofcars+"\""+")";
        System.out.println(staments);
        s.executeUpdate(staments);
        con.close();
    }

    public static void DBdelete(String table,String city , String noofcars) throws SQLException {
        jdbcconection jd=new jdbcconection();
        jd.host = BasePage.getvalue("dbhost");
        jd.port = BasePage.getvalue("dbport");
        jd.username = BasePage.getvalue("dbuser");
        jd.password = BasePage.getvalue("dbpassword");
        Connection con = DriverManager.getConnection("jdbc:mysql://" + jd.host + ":" + jd.port + "/sampledb", jd.username, jd.password);
        Statement s = con.createStatement();
        String staments="insert into "+table+ " values(\""+city+"\", \""+noofcars+"\""+")";
        System.out.println(staments);
        s.executeUpdate(staments);
        con.close();
    }



}
