package org.example;

import org.example.entities.*;
import jakarta.persistence.*;
import java.util.*;
public class ArtistRepository {

    private EntityManager entityManager;

    public ArtistRepository() {
        entityManager = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
    }

    public void create(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }

    public Artist findById(Long id) {
        return entityManager.find(Artist.class, id);
    }

    public List<Artist> findByName(String name) {
        TypedQuery<Artist> query = entityManager.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
    }
}