package ru.stqa.lsft.addressbook.model;

public class DateTestContact {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private String group;

    public DateTestContact(String name, String middleName, String lastName, String group, boolean create) {
        this.group = group;
        this.firstName = "name_person" + (int) (Math.random() * 10) + (int) (Math.random() * 10);
        this.middleName = middleName + (int) (Math.random() * 10) + (int) (Math.random() * 10);
        this.lastName = lastName + (int) (Math.random() * 10) + (int) (Math.random() * 10);
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
