package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Catalog {

    private List<Document> documents;

    public Catalog() {
        documents = new ArrayList<>();
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void addDocument(String id, String name, String path, Map<String, String> tags) {
        Document doc = new Document(id, name, path, tags);
        documents.add(doc);
    }

    public void addDocument(Document doc) {
        documents.add(doc);
    }

    public void save(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filename), this);
    }

    public static Catalog load(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), Catalog.class);
    }


    @java.lang.Override
    public java.lang.String toString() {

        String format = "Catalog: \n";
        for (Document doc : documents) {
            format = format + doc + "\n";
        }

        return format;

    }


}
