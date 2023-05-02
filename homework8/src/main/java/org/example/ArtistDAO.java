package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    private  Connection connection;

    public ArtistDAO() {
        try {
            connection = DBConnectionManager.getInstance().getConnection();
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void addArtist(Artist artist) throws SQLException {
        String sql = "INSERT INTO artists (id, name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, artist.getId());
        statement.setString(2, artist.getName());
        statement.executeUpdate();
    }
    public int getOrCreateArtist(String name) throws SQLException {
        String sql = "SELECT id FROM artists WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("id");
                    }
                }
            }
        }

        // Artist does not exist, insert a new record
        String sqlInsert = "INSERT INTO artists (id, name) VALUES (?,?)";
        int nextId = getNextId("artists");
        try (PreparedStatement statement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, nextId);
            statement.setString(2, name);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating artist failed, no ID obtained.");
                }
            }
        }
    }

    public void updateArtist(Artist artist) throws SQLException {
        String sql = "UPDATE artists SET name = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, artist.getId());
        statement.setString(2, artist.getName());
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
    public List<Artist> getArtistByName(String name) throws SQLException {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artists WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Artist artist = new Artist(id, name);
                artists.add(artist);
            }
        }
        return artists;
    }
    private int getNextId(String tableName) throws SQLException {
        String sql = "SELECT MAX(id) FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            if (statement.execute()) {
                try (var resultSet = statement.getResultSet()) {
                    if (resultSet.next()) {
                        int maxId = resultSet.getInt(1);
                        return maxId + 1;
                    }
                }
            }
        }
        return 1;
    }
}