package ru.stqa.lsft.addressbook.model;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.ForwardingSet;

import java.util.*;

public class Contacts extends ForwardingSet<ContactDate> {

    private Set<ContactDate> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactDate>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<ContactDate>();
    }

    public Contacts(Collection<ContactDate> contacts) {
        this.delegate = new HashSet<ContactDate>(contacts);
    }

    @Override
    protected Set<ContactDate> delegate() {
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

//    public Contacts sort1(Comparator<? super ContactDate> c) {
//        Object[] a = this.toArray();
//        Arrays.sort(a, (Comparator) c);
//        ListIterator<ContactDate> i = this.listIterator();
//        for (Object e : a) {
//            i.next();
//            i.set((ContactDate) e);
//        }
//        return this;
//    }


}
