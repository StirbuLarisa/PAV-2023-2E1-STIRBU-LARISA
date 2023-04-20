package org.example;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class ReportCommand implements Command {
    public void execute(Catalog catalog, String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("Invalid number of arguments for report command");
        }
        String fileName = args[0];
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassForTemplateLoading(Catalog.class, "/");
        try {
            System.out.println("Current working directory: " + System.getProperty("user.dir"));
            Template template = cfg.getTemplate("report.ftl");
            FileWriter writer = new FileWriter(fileName);
            System.out.println("Catalog documents: " + catalog.getDocuments());
            template.process(catalog, writer);
            writer.close();
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException e) {
            throw new Exception("Error creating or opening report", e);
        }
    }
}