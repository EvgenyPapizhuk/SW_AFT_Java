package ru.stqa.lsft.addressbook.model;

import java.util.Objects;

public class DateTestGroup {
    private final String name;
    private final String header;
    private final String footer;

    @Override
    public String toString() {
        return "DateTestGroup{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTestGroup that = (DateTestGroup) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

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
