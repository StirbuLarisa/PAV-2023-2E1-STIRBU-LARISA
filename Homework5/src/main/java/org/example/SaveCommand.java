package org.example;

import java.io.IOException;

public class SaveCommand implements Command {
    public void execute(Catalog catalog, String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("Invalid number of arguments for save command");
        }
        String fileName = args[0];
        try {
            catalog.save(fileName);
            System.out.println("Catalog saved to file " + fileName);
        } catch (IOException e) {
            throw new Exception("Error saving catalog to file " + fileName, e);
        }
    }
}