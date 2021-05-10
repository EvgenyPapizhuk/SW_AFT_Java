package ru.stqa.lsft.addressbook.model;

import java.util.Objects;

public class DateTestContact {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private String group;

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
}
