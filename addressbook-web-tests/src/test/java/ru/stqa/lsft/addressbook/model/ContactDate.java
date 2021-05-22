package ru.stqa.lsft.addressbook.model;

import java.io.File;
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
    private String allPhones;

    private String postalAddress;

    private String email;
    private String email2;
    private String email3;
    private String allEmails;

    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactDate withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactDate withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public ContactDate withPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactDate withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactDate withtEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactDate withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactDate withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

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
