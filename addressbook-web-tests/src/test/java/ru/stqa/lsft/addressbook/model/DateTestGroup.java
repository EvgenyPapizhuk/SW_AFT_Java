package ru.stqa.lsft.addressbook.model;

import java.util.Objects;

public class DateTestGroup {
    private int id = Integer.MAX_VALUE;
    private String name;
    private String header;
    private String footer;

//    public DateTestGroup(String name, String header, String footer) {
//        this.id = Integer.MAX_VALUE;
//        this.name = name;
////        this.name = "test1";
//        this.header = header;
//        this.footer = footer;
//    }
//
//    public DateTestGroup(int id, String name, String header, String footer) {
//        this.id = id;
//        this.name = name;
////        this.name = "test1";
//        this.header = header;
//        this.footer = footer;
//    }

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
        return Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "DateTestGroup{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public DateTestGroup withtId(int id) {
        this.id = id;
        return this;
    }

    public DateTestGroup withName(String name) {
        this.name = name;
        return this;
    }

    public DateTestGroup withHeader(String header) {
        this.header = header;
        return this;
    }

    public DateTestGroup withFooter(String footer) {
        this.footer = footer;
        return this;
    }
}
