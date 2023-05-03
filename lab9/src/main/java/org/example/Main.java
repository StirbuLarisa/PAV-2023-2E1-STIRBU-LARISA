package org.example;

import jakarta.persistence.*;
import org.example.entities.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = EntityManagerFactoryUtil.getEntityManagerFactory();

        ArtistRepository artistRepository = new ArtistRepository();

        // Create a new artist and save it to the database
        Artist artist1 = new Artist();
        artist1.setName("Rob Dylan");
        artistRepository.create(artist1);

        // Find an artist by ID
        Artist artist2 = artistRepository.findById(502L);
        System.out.println(artist2.getName()); // should print "Bob Dylan"

        // Find artists by name
        List<Artist> artists = artistRepository.findByName("Dylan");
        for (Artist artist : artists) {
            System.out.println(artist.getName()); // should print "Bob Dylan"
        }

        entityManagerFactory.close();
    }
}