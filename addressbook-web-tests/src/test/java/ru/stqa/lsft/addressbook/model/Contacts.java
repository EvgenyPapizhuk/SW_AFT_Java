package ru.stqa.lsft.addressbook.model;

import com.google.common.collect.ForwardingList;

import java.util.*;

public class Contacts extends ForwardingList<ContactDate> {

    private List<ContactDate> delegate;

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

    public Contacts withAdded(ContactDate contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts withhout(ContactDate contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

    public Contacts sort1(Comparator<? super ContactDate> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<ContactDate> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((ContactDate) e);
        }
        return this;
    }


}
