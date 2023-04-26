package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    private final Connection connection;

    public AlbumDAO() {
        connection = DBConnectionManager.getInstance().getConnection();
    }

    public void addAlbum(Album album) throws SQLException {
        String sql = "INSERT INTO albums (id, release_year, title, artist_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, album.getId());
        statement.setInt(2, album.getReleaseYear());
        statement.setString(3, album.getTitle());
        statement.setInt(4, album.getArtistId());
        statement.executeUpdate();
    }

    public void updateAlbum(Album album) throws SQLException {
        String sql = "UPDATE albums SET release_year = ?, title = ?, artist_id = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, album.getReleaseYear());
        statement.setString(2, album.getTitle());
        statement.setInt(3, album.getArtistId());
        statement.setInt(4, album.getId());
        statement.executeUpdate();
    }

    public void deleteAlbum(int id) throws SQLException {
        String sql = "DELETE FROM albums WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public Album getAlbumById(int id) throws SQLException {
        String sql = "SELECT * FROM albums WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int releaseYear = resultSet.getInt("release_year");
            String title = resultSet.getString("title");
            int artistId = resultSet.getInt("artist_id");
            return new Album(id, releaseYear, title, artistId);
        } else {
            return null;
        }
    }

        public List<Album> getAllAlbums() throws SQLException {
            List<Album> albums = new ArrayList<>();
            String sql = "SELECT * FROM albums";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int releaseYear = resultSet.getInt("release_year");
                String title = resultSet.getString("title");
                int artistId = resultSet.getInt("artist_id");
                albums.add(new Album(id, releaseYear, title, artistId));
            }
            return albums;
        }

    public void addGenreForAlbum(int albumId, int genreId) throws SQLException {
        String sql = "INSERT INTO album_genres (album_id, genre_id) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, albumId);
        statement.setInt(2, genreId);
        statement.executeUpdate();
    }

    public List<Integer> getGenresForAlbum(int albumId) throws SQLException {
        List<Integer> genreIds = new ArrayList<>();
        String sql = "SELECT * FROM album_genres WHERE album_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, albumId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int genreId = resultSet.getInt("genre_id");
            genreIds.add(genreId);
        }
        return genreIds;
    }

    public void addGenresForAlbum(Album album) throws SQLException {
        for (int genreId : album.getGenreIds()) {
            addGenreForAlbum(album.getId(), genreId);
        }
    }

    public void deleteGenresForAlbum(int albumId) throws SQLException {
        String sql = "DELETE FROM album_genres WHERE album_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, albumId);
        statement.executeUpdate();
    }
    }
