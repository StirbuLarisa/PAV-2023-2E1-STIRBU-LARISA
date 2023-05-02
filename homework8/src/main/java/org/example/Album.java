package org.example;

import java.util.*;

public class Album {
    private int id;
    private int releaseYear;
    private String title;
    private int artistId;
    private List<Integer> genreIds;


    public Album(int id, int releaseYear, String title, int artistId) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artistId = artistId;
        this.genreIds = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }
}