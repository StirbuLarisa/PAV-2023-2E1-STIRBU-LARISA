package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    public void execute(Catalog catalog, String[] args) throws Exception {
        if (args.length != 0) {
            throw new IllegalArgumentException("Invalid number of arguments for view command");
        }

        Desktop.getDesktop().open(new File("catalog.json"));
    }
}