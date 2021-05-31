package ru.stqa.lsft.addressbook.tests.interactionContactsAndGroups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.ContactDate;
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
        app.goTo().groupPage();
        int quantityConnects = app.db().quantityConnects();
        if (app.db().groups().size() == 0) {
            app.group().create(new DateTestGroup().withName("test1"));
        }
        int quantityGroups = app.db().groups().size();
        app.goTo().goToHome();
        boolean needNewContact = false;
        if (app.db().contacts().size() == 0) {
            needNewContact = true;
        } else {
            for (ContactDate contact : app.db().contacts()) {
                if (contact.getGroups().size() < quantityGroups) {
                    operationContact = contact;
                    needNewContact=false;
                    return;
                }
                needNewContact = true;
            }
        }
        if (needNewContact) {
            File photo = new File("src/test/resources/shrimp.jpg");
            app.contact().createContact(new ContactDate()
                    .withtFirstName("test1").withtMiddleName("test2").withttLastName("test1").withPhoto(photo), true);
            operationContact = app.db().contacts().iterator().next();
        }
    }

    @Test
    public void testDeletedContactFromGroup() {
        app.goTo().goToHome();
        Groups before = operationContact.getGroups();
        Groups operationGroups = app.db().groups();
        for (DateTestGroup group : before) {
            operationGroups.remove(group);
        }
        operationGroup = operationGroups.iterator().next();
        app.contact().selectContact(operationContact);
        app.contact().selectGroup(operationGroup);
        app.contact().addGroup();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Groups after = app.db().contact(operationContact.getId()).getGroups();
        System.out.println("before: "+ before.size());
        System.out.println("after: "+ after.size());
        assertThat(after, equalTo(before.withAdded(operationGroup)));
    }
}
