package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class CreateTestContact extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.getNavigationHalper().goToHome();
        List<DateTestContact> before = app.getContactHelper().getContactList();
        DateTestContact dataContact = new DateTestContact("test1", "test2", "test", "test1");
        app.getContactHelper().createContact(dataContact, true);

        List<DateTestContact> after = app.getContactHelper().getContactList();
        before.add(dataContact);

        Comparator<? super DateTestContact> byHC = (o1, o2) -> Integer.compare(o1.hashCode(), o2.hashCode());
        before.sort(byHC);
        after.sort(byHC);
        Assert.assertEquals(before, after);
    }

}
