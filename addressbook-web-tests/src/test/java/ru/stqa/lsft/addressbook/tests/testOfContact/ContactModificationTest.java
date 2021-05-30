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
                    .withtFirstName("test1").withtMiddleName("test2").withttLastName("test1"), true);
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.db().contacts();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate dataContact = new ContactDate()
                .withtId(modifiedContact.getId()).withtFirstName("test122").withtMiddleName("test233").withttLastName("lastName 0");
        app.contact().modify(modifiedContact);
        app.contact().fillContactForm(dataContact, false);
        app.contact().clickUpdate();
        app.goTo().goToHome();
        Contacts after = app.db().contacts();
        Comparator<? super ContactDate> byHC = (o1, o2) -> o1.toString().compareTo(o2.toString());
        assertThat(after,equalTo(before.withhout(modifiedContact).withAdded(dataContact)));
        verifyContactListInUI();
    }


}
