package ru.stqa.lsft.addressbook.model;

public class DateTestContact {

    private final String name;
    private final String header;
    private final String footer;

    public DateTestContact(String name, String header, String footer) {
        this.name = "name_person" + (int) (Math.random() * 10) + (int) (Math.random() * 10);
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

}
