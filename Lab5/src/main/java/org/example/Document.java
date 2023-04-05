package org.example;

import java.util.Map;

public class Document {

    private String id;
    private String name;
    private String path;
    private Map<String, String> tags;

    public Document() {
    }
    public Document(String id, String name, String path, Map<String, String> tags) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", tags=" + tags +
                '}';
    }
}
