package org.example;

import jakarta.persistence.*;

public class EntityManagerFactoryUtil {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitLab9");

    private EntityManagerFactoryUtil() {}

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void shutdown() {
        entityManagerFactory.close();
    }
}
