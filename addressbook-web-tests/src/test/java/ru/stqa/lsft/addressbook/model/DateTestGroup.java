package ru.stqa.lsft.addressbook.model;

import java.util.Objects;

public class DateTestGroup {
    private final String id;
    private final String name;
    private final String header;
    private final String footer;


    public DateTestGroup(String name, String header, String footer) {
        this.id = null;
        this.name = name;
//        this.name = "test1";
        this.header = header;
        this.footer = footer;
    }

    public DateTestGroup(String id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
//        this.name = "test1";
        this.header = header;
        this.footer = footer;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTestGroup group = (DateTestGroup) o;
        return Objects.equals(id, group.id) && Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "DateTestGroup{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
}
