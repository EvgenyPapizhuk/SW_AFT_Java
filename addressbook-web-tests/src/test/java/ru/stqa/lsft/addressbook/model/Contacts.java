package ru.stqa.lsft.addressbook.model;

import com.google.common.collect.ForwardingList;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends ForwardingList {

    private List<DateTestContact> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new ArrayList<>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new ArrayList<>();
    }

    @Override
    protected List delegate() {
        return delegate;
    }

    public Contacts withAdded(DateTestContact contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts withhout(DateTestContact contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
