package ru.stqa.lsft.addressbook.model;

import java.util.Objects;

public class DateTestContact {

    private String firstName;
    private String middleName;
    private String lastName;
    private String group;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTestContact that = (DateTestContact) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public String toString() {
        return "DateTestContact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public DateTestContact(String firstName, String middleName, String lastName, String group) {
        this.group = group;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public DateTestContact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() { return group;
    }

    public int getId() {
        return id;
    }

    public DateTestContact withtFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public DateTestContact withtMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public DateTestContact withttLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public DateTestContact withtGroup(String group) {
        this.group = group;
        return this;
    }

    public DateTestContact withtId(int id) {
        this.id = id;
        return this;
    }
}
