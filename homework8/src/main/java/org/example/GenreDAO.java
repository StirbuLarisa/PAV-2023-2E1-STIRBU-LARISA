package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    private Connection connection;

    public GenreDAO() {
        try {
            connection = DBConnectionManager.getInstance().getConnection();
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void addGenre(Genre genre) throws SQLException {
        String sql = "INSERT INTO genres (id, name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, genre.getId());
        statement.setString(2, genre.getName());
        statement.executeUpdate();
    }
    public int getOrCreateGenre(String name) throws SQLException {
        String sql = "SELECT id FROM genres WHERE name = ?";
        int nextId = getNextId("genres");
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

        // Genre does not exist, insert a new record
        String sqlInsert = "INSERT INTO genres (id, name) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, nextId);
            statement.setString(2, name);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating genre failed, no ID obtained.");
                }
            }
        }
    }

    public void updateGenre(Genre genre) throws SQLException {
        String sql = "UPDATE genres SET name = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, genre.getName());
        statement.setInt(2, genre.getId());
        statement.executeUpdate();
    }

    public void deleteGenre(int id) throws SQLException {
        String sql = "DELETE FROM genres WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public Genre getGenreById(int id) throws SQLException {
        String sql = "SELECT * FROM genres WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            return new Genre(id, name);
        } else {
            return null;
        }
    }

    public List<Genre> getAllGenres() throws SQLException {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genres";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            genres.add(new Genre(id, name));
        }
        return genres;
    }

    public List<Genre> getGenreByName(String name) throws SQLException {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genres WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        }
        return genres;
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