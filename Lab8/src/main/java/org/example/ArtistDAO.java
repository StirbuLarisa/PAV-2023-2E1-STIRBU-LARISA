package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    private final Connection connection;

    public ArtistDAO() {
        connection = DBConnectionManager.getInstance().getConnection();
    }

    public void addArtist(Artist artist) throws SQLException {
        String sql = "INSERT INTO artists (id, name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, artist.getId());
        statement.setString(2, artist.getName());
        statement.executeUpdate();
    }

    public void updateArtist(Artist artist) throws SQLException {
        String sql = "UPDATE artists SET name = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, artist.getName());
        statement.setInt(2, artist.getId());
        statement.executeUpdate();
    }

    public void deleteArtist(int id) throws SQLException {
        String sql = "DELETE FROM artists WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public Artist getArtistById(int id) throws SQLException {
        String sql = "SELECT * FROM artists WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            return new Artist(id, name);
        } else {
            return null;
        }
    }

    public List<Artist> getAllArtists() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artists";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            artists.add(new Artist(id, name));
        }
        return artists;
    }
}