package org.example;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.*;


public class DatasetImporter {

    private static final String CSV_FILE_PATH = "G:/Anul 2/sem2/JAVA/PAV-2023-2E1-STIRBU-LARISA/homework8/src/main/resources/albumlist.csv";

    private Connection connection;

    public DatasetImporter(Connection connection) {
        this.connection = connection;
    }

    public void importDataset() {
        try {
            ArtistDAO artistDAO = new ArtistDAO();
            AlbumDAO albumDAO = new AlbumDAO();
            GenreDAO genreDAO = new GenreDAO();

            // read the CSV file

            List<Album> albums = new ArrayList<>();
            int id=1;
            try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
                reader.skip(1);
                String[] fields;
                while ((fields = reader.readNext() )!= null) {
                    List<String> genreNames = new ArrayList() ;
                    Integer releaseYear = Integer.parseInt(fields[1]);
                    String title = fields[2];
                    String artistName = fields[3];

                    String[] gen = fields[4].split(",");

                    for (String genName : gen) {
                        genreNames.add(genName);
                    }

                    int artistId = artistDAO.getOrCreateArtist(artistName);
                    List<Integer> genreIds = new ArrayList<>();
                    for (String genreName : genreNames) {

                        int genreId = genreDAO.getOrCreateGenre(genreName);
                        genreIds.add(genreId);
                    }
                    Album album = new Album(id, releaseYear, title, artistId);
                    album.setGenreIds(genreIds);
                    albums.add(album);
                    id++;
                }
            }
            catch (Exception e) {
                System.out.println("no file");
                e.printStackTrace();
            }

            try {
                // add objects to the database
                for (Album album : albums) {
                    albumDAO.getOrCreateAlbum(album);
                    albumDAO.addGenresForAlbum(album);

                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}