package ru.stqa.lsft.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_in_groups")
public class Connects {

    @Id
    public int id;

    @Column(name = "group_id")
    @Type(type = "int")
    public int group_id;

    public Connects() {

    }

}
