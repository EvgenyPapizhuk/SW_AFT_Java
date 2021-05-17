package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.Contacts;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class CreateTestContact extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.goTo().goToHome();
        Contacts before = app.getContactHelper().all();
        DateTestContact dataContact = new DateTestContact("test1", "test2", "test", "test1");
        app.getContactHelper().createContact(dataContact, true);

        Contacts after = app.getContactHelper().all();

        Comparator<? super DateTestContact> byHC = (o1, o2) -> Integer.compare(o1.hashCode(), o2.hashCode());
//        before.sort(byHC);
//        after.sort(byHC);
//        Assert.assertEquals(before, after);
        System.out.println("before: " + before.size());
        System.out.println("after: " + after.size());
//        assertThat(after,equalTo(before));
        assertThat(after.sort1(byHC),equalTo(before.withAdded(dataContact).sort1(byHC)));
    }

}
