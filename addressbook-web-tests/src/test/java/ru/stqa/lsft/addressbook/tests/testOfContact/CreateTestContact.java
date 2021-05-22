package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.Contacts;
import ru.stqa.lsft.addressbook.model.ContactDate;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.io.File;
import java.util.Comparator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class CreateTestContact extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.goTo().goToHome();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/shrimp.jpg");
        ContactDate dataContact = new ContactDate()
                .withtFirstName("test1").withtMiddleName("test2").withttLastName("test").withPhoto(photo);
        app.contact().createContact(dataContact, true);

        Contacts after = app.contact().all();

        Comparator<? super ContactDate> byHC = (o1, o2) -> Integer.compare(o1.hashCode(), o2.hashCode());
//        before.sort(byHC);
//        after.sort(byHC);
//        Assert.assertEquals(before, after);
        System.out.println("before: " + before.size());
        System.out.println("after: " + after.size());
//        assertThat(after,equalTo(before));
        assertThat(after.sort1(byHC),equalTo(before.withAdded(dataContact).sort1(byHC)));
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/shrimp.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

}
