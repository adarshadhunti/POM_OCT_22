package testcases;

import resources.jdbcconection;
import java.sql.SQLException;

public class dbupdater {
    public static void main(String[] args) throws SQLException {

        jdbcconection.DBupdate("cities","mysore","delhi");
        jdbcconection.DBinsert("cities","Haryana","48");
    }
}
