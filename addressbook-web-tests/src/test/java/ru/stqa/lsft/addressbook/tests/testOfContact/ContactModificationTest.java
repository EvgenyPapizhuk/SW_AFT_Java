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
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ContactDate()
                    .withtFirstName("test1").withtMiddleName("test2").withttLastName("test1").withtGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.contact().all();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate dataContact = new ContactDate()
                .withtFirstName("test122").withtMiddleName("test233").withttLastName("test3").withtGroup("null");
        app.contact().modify(modifiedContact);
        app.contact().fillContactForm(dataContact, false);
        app.contact().clickUpdate();
        app.goTo().goToHome();
        Contacts after = app.contact().all();
        Comparator<? super ContactDate> byHC = (o1, o2) -> o1.toString().compareTo(o2.toString());
        assertThat(after.sort1(byHC),equalTo(before.withhout(modifiedContact).withAdded(dataContact).sort1(byHC)));
    }


}
