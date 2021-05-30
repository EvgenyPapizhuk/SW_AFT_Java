package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.ContactDate;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().goToHome();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ContactDate()
                    .withtFirstName("test1").withtMiddleName("test2").withttLastName("test1"), true);
        }
    }

    @Test
    public void testContactAddress() {
        app.goTo().goToHome();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getPostalAddress(), equalTo(contactInfoFromEditForm.getPostalAddress()));

    }
}
