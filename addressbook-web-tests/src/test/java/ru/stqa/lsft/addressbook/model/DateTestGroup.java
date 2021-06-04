package ru.stqa.lsft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class DateTestGroup {

    @XStreamOmitField
    @Id
    @Column(name = "group_id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "group_name")
    private String name;
    @Expose
    @Column(name = "group_header")
    @Type(type = "text")
    private String header;
    @Expose
    @Column(name = "group_footer")
    @Type(type = "text")
    private String footer;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER)
    private Set<ContactDate> contacts = new HashSet<ContactDate>();

    public int contactsSize = contacts.size();

    public Contacts getContacts() {
        return new Contacts(contacts);
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
    public String toString() {
        return "DateTestGroup{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTestGroup group = (DateTestGroup) o;
        return id == group.id && Objects.equals(name, group.name) && Objects.equals(header, group.header) && Objects.equals(footer, group.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, header, footer);
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
