package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.Contacts;
import ru.stqa.lsft.addressbook.model.ContactDate;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().goToHome();
//        if (!app.contact().isThereAContact()) {
            if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactDate()
                    .withtFirstName("test1").withtMiddleName("test2").withttLastName("test1").withtGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.db().contacts();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate dataContact = new ContactDate()
                .withtId(modifiedContact.getId()).withtFirstName("test122").withtMiddleName("test233").withttLastName("lastName 0").withtGroup("null");
        app.contact().modify(modifiedContact);
        System.out.println("Дошли до заполнения");
        app.contact().fillContactForm(dataContact, false);
        System.out.println("Прошли заполнение");
        app.contact().clickUpdate();
        app.goTo().goToHome();
        Contacts after = app.db().contacts();
        Comparator<? super ContactDate> byHC = (o1, o2) -> o1.toString().compareTo(o2.toString());

        System.out.println("Список до:");
        for ( ContactDate contact : before ) {
            System.out.println(contact);
        }
        System.out.println("Список до(дополненный):");
        for ( ContactDate contact : before.withhout(modifiedContact).withAdded(dataContact) ) {
            System.out.println(contact);
        }

        System.out.println("Список после:");
        for ( ContactDate contact : after ) {
            System.out.println(contact);
        }


        assertThat(after,equalTo(before.withhout(modifiedContact).withAdded(dataContact)));
    }


}
