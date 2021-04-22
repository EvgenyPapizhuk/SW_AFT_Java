package ru.stqa.lsft.addressbook.model;

public class DateTestGroup {
    private final String name;
    private final String header;
    private final String footer;

    public DateTestGroup(String name, String header, String footer) {
        this.name = "name" + (int)(Math.random()*10);
        this.header = header;
        this.footer = footer;
    }

    public String getFirstName() {
        return name;
    }

    public String getMiddlename() {
        return header;
    }

    public String getLastName() {
        return footer;
    }
}