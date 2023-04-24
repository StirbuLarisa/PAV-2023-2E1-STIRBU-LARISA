package org.example;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
            Template template = cfg.getTemplate("report.ftl");
            FileWriter writer = new FileWriter(fileName);
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("catalog", catalog);
            System.out.println("Catalog documents: " + catalog.getDocuments());
            template.process(dataModel, writer);
            writer.close();
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException e) {
            throw new Exception("Error creating or opening report", e);
        }
    }
}