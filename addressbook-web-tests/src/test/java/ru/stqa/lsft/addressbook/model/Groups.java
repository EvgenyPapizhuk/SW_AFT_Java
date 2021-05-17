package ru.stqa.lsft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<DateTestGroup> {

    private Set<DateTestGroup> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<DateTestGroup>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<DateTestGroup>();
    }

    @Override
    protected Set<DateTestGroup> delegate() {
        return delegate;
    }

    public Groups withAdded(DateTestGroup group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups withhout(DateTestGroup group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }

}

