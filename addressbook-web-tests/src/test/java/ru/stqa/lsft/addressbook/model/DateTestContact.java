package ru.stqa.lsft.addressbook.model;

public class DateTestContact {

    private final String name;
    private final String header;
    private final String footer;

    public DateTestContact(String name, String header, String footer) {
        this.name = "name_person" + (int) (Math.random() * 10) + (int) (Math.random() * 10);
        this.header = header + (int) (Math.random() * 10) + (int) (Math.random() * 10);
        this.footer = footer;
    }

    public String getFirstName() {
        return name;
    }

    public String getMiddleName() {
        return header;
    }

    public String getLastName() {
        return footer;
    }

}
