package org.example;

import java.util.List;

public class ListCommand implements Command {
    public void execute(Catalog catalog, String[] args) throws Exception {
        List<Document> documents = catalog.getDocuments();
        if (documents.isEmpty()) {
            System.out.println("Catalog is empty");
        } else {
            for (Document document : documents) {
                System.out.println(document.toString());
            }
        }
    }
}