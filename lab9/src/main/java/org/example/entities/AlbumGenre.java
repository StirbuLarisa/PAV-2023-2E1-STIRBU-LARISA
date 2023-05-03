//package org.example.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "album_genres")
//public class AlbumGenre {
//    @ManyToOne(fetch = FetchType.LAZY)      //improve performance
//    @JoinColumn(name = "album_id", nullable = false)
//    private Album album;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "genre_id", nullable = false)
//    private Genre genre;
//
//    public Album getAlbum() {
//        return album;
//    }
//
//    public void setAlbum(Album album) {
//        this.album = album;
//    }
//
//    public Genre getGenre() {
//        return genre;
//    }
//
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }
//}
