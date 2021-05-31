package ru.stqa.lsft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.*;

public class Groups extends ForwardingSet<DateTestGroup> {

    private Set<DateTestGroup> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<DateTestGroup>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<DateTestGroup>();
    }

    public Groups(Collection<DateTestGroup> groups) {
        this.delegate = new HashSet<DateTestGroup>(groups);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Groups groups = (Groups) o;
        return Objects.equals(delegate, groups.delegate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), delegate);
    }
}

