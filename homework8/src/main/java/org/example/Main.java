package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBConnectionManager database = DBConnectionManager.getInstance();
        Connection con = database.getConnection();
        ArtistDAO artistDAO = new ArtistDAO();
        AlbumDAO albumDAO = new AlbumDAO();
        GenreDAO genreDAO = new GenreDAO();
        try {

            // DatasetImporter datasetImporter = new DatasetImporter(database.getConnection());
          //  datasetImporter.importDataset();
          //  con.commit();
            Artist artist = artistDAO.getArtistById(43);
            System.out.println(artist);

            albumDAO.deleteGenresForAlbum(2);
            System.out.println(albumDAO.getAlbumById(2));

            List<Genre> genres = genreDAO.getGenreByName("Rock");

            System.out.println(genres);

            con.close();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}