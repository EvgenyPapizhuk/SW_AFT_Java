package ru.stqa.lsft.addressbook.tests.interactionContactsAndGroups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.ContactDate;
import ru.stqa.lsft.addressbook.model.Contacts;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletedContactFromGroupTest extends TestBase {

    ContactDate operationContact;
    DateTestGroup operationGroup;

    @BeforeMethod
    public void ensurePreconditions(){
        Groups localGroups = app.db().groups();
        Contacts localContacts = app.db().contacts();
        int quantityGroups = localGroups.size();
        int quantityContacts = localContacts.size();
        int quantityConnects = app.db().quantityConnects();
        if (quantityConnects == 0) {
            if (quantityGroups == 0) {
                app.goTo().groupPage();
                app.group().create(new DateTestGroup().withName("test1"));
            }
            if (quantityContacts == 0) {
                app.goTo().goToHome();
                File photo = new File("src/test/resources/shrimp.jpg");
                app.contact().createContact(new ContactDate()
                        .withtFirstName("test1").withtMiddleName("test2").withttLastName("test1").withPhoto(photo), true);
//            operationContact = app.db().contacts().iterator().next();
            }
            operationContact = app.db().contacts().iterator().next();
            operationGroup = app.db().groups().iterator().next();
            app.contact().selectContact(operationContact);
            app.contact().selectGroup(operationGroup);
            app.contact().addGroup();
        } else {
            for (ContactDate contact : app.db().contacts()) {
                if (contact.getGroups().size() > 0) {
                    operationContact = contact;
                    return;
                }
            }
            for (DateTestGroup group : localGroups) {
                if (group.getContacts().size() > 0) {
                    operationGroup = group;
                    return;
                }
            }

        }
    }

    @Test
    public void testDeletedContactFromGroup() {
        app.goTo().goToHome();
        Groups before = operationContact.getGroups();


        System.out.println(operationGroup);
        app.contact().selectGroupFilter(operationGroup);
        app.contact().selectContact(operationContact);
        app.contact().removeFromGroup();


        Groups after = app.db().contact(operationContact.getId()).getGroups();
        System.out.println("before: "+ before.size());
        System.out.println("after: "+ after.size());
        assertThat(after, equalTo(before.withhout(operationGroup)));
    }
}
