package ru.stqa.lsft.addressbook.model;

import java.util.Objects;

public class ContactDate {

    private String firstName;
    private String middleName;
    private String lastName;
    private String group;
    private int id;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDate that = (ContactDate) o;
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

    public ContactDate(String firstName, String middleName, String lastName, String group) {
        this.group = group;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public ContactDate() {
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

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactDate withtFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactDate withtMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactDate withttLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactDate withtGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactDate withtId(int id) {
        this.id = id;
        return this;
    }

    public ContactDate withtHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactDate withtMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactDate withtWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

}
