package ru.stqa.lsft.addressbook.model;

public class DateTestGroup {
    private final String name;
    private final String header;
    private final String footer;

    public DateTestGroup(String name, String header, String footer) {
//        this.name = "name" + (int)(Math.random()*10);
        this.name = "test1";
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
