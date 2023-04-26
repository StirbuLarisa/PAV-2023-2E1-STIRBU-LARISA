package org.example;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        DBConnectionManager database = DBConnectionManager.getInstance();
        AlbumDAO albumDAO = new AlbumDAO();
        GenreDAO genreDAO = new GenreDAO();
        ArtistDAO artistDAO = new ArtistDAO();

        try {

            Artist artist = new Artist(3, "TheWeeknd");
            artistDAO.addArtist(artist);
            System.out.println("Added artist: " + artist.getName());

            // Add a genre to the database
            Genre genre = new Genre(2, "R&B");
            genreDAO.addGenre(genre);
            System.out.println("Added genre: " + genre.getName());

            // Add an album for the artist to the database
            Album album = new Album(2, 2016, "Starboy", artist.getId());
            albumDAO.addAlbum(album);
            System.out.println("Added album: " + album.getTitle());

            // Add the genre to the album
            albumDAO.addGenreForAlbum(album.getId(), genre.getId());
            albumDAO.addGenreForAlbum(album.getId(), 1);
            System.out.println("Added genre to album");

            // Retrieve the album and display its details
            Album retrievedAlbum = albumDAO.getAlbumById(album.getId());
            System.out.println("Retrieved album: " + retrievedAlbum.getTitle());
            System.out.println("Artist: " + artistDAO.getArtistById(retrievedAlbum.getArtistId()).getName());
            System.out.println("Genre(s):");

            for (int genreId : retrievedAlbum.getGenreIds()) {
                System.out.println(genreDAO.getGenreById(genreId).getName());
            }

                database.getConnection().close();

            } catch(SQLException e){
                System.err.println(e);

            }
        }

}