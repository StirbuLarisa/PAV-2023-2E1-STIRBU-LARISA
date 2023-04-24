package org.example;
import java.util.*;

public class AddCommand implements Command {
    public void execute(Catalog catalog, String[] args) throws Exception {
        if (args.length < 4) {
            throw new IllegalArgumentException("Invalid number of arguments for add command");
        }
        String id = args[0];
        String name = args[1];
        String path = args[2];
        Map<String, String> tags = new HashMap<>();
        String tagString = args[3];
        String[] tagPairs = tagString.split(",");
        for (String tagPair : tagPairs) {
            String[] parts = tagPair.split("=");
            if (parts.length == 2) {
                tags.put(parts[0], parts[1]);
            }
        }
        catalog.addDocument(new Document(id, name, path, tags));
    }
}