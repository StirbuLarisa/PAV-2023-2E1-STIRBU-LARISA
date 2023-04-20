package org.example;

public interface Command {
    void execute(Catalog catalog, String[] args) throws Exception;

}
