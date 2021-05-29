package ru.stqa.lsft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class DateTestGroup {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Expose
    private String name;
    @Expose
    private String header;
    @Expose
    private String footer;



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
        return id == group.id && Objects.equals(name, group.name);
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
