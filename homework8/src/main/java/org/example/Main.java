package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBConnectionManager database = DBConnectionManager.getInstance();
        Connection con = database.getConnection();

        try {

            DatasetImporter datasetImporter = new DatasetImporter(database.getConnection());
            datasetImporter.importDataset();
          //  con.commit();
            con.close();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}