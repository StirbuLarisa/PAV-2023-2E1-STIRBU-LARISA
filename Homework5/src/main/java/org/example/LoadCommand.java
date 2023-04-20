package org.example;

import java.io.IOException;

public class LoadCommand  implements Command {
    public void execute(Catalog catalog, String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("Invalid number of arguments for load command");
        }
        String fileName = args[0];
        try {
            Catalog loadedCatalog = Catalog.load(fileName);
            catalog.setDocuments(loadedCatalog.getDocuments());
            System.out.println("Catalog loaded from file " + fileName);
        } catch (IOException e) {
            throw new Exception("Error loading catalog from file " + fileName, e);
        }
    }
}