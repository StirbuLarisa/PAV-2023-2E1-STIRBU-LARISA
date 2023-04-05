package org.example;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Map<String, String> tags1 = new HashMap<>();
        tags1.put("title", "First Article");
        tags1.put("author", "Ana");
        tags1.put("year", "2022");
        Map<String, String> tags2 = new HashMap<>();
        tags2.put("title", "First Book");
        tags2.put("author", "Maria");
        tags2.put("year", "1980");

        Catalog catalog = new Catalog();
        Catalog loadedcatalog = new Catalog();
        Document document1 = new Document("1a2b","First Article","G:/Anul 2/sem2/JAVA/PAV-2023-2E1-STIRBU-LARISA/Lab5", tags1 );
        Document document2 = new Document("1a2b3c","First Book","G:/Anul 2/sem2/JAVA/PAV-2023-2E1-STIRBU-LARISA/Lab5/", tags2 );

        catalog.addDocument(document1);
        catalog.addDocument(document2);

        try{
            catalog.save("catalog.json");
        }catch (IOException e){
            System.err.println("Error saving catalog: " + e.getMessage());
        }

        try {
            loadedcatalog=catalog.load("catalog.json");
        } catch (IOException e) {
            System.err.println("Error loading catalog: " + e.getMessage());
        }

        System.out.println(catalog);
        System.out.println();
        System.out.println(loadedcatalog);

    }

    }
