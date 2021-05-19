package ru.stqa.lsft.addressbook.model;

import com.google.common.collect.ForwardingList;
import ru.stqa.lsft.addressbook.model.DateTestContact;

import java.util.*;

public class Contacts extends ForwardingList<DateTestContact> {

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

    public Contacts sort1(Comparator<? super DateTestContact> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<DateTestContact> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((DateTestContact) e);
        }
        return this;
    }


}
