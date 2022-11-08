package testcases;

import resources.updatedb;
import java.sql.SQLException;

public class dbupdater {
    public static void main(String[] args) throws SQLException {

        updatedb.DBupdate("cities","delhi","mysore");
    }
}
