package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    private final Connection connection;

    public GenreDAO() {
        connection = DBConnectionManager.getInstance().getConnection();
    }

    public void addGenre(Genre genre) throws SQLException {
        String sql = "INSERT INTO genres (id, name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, genre.getId());
        statement.setString(2, genre.getName());
        statement.executeUpdate();
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
}