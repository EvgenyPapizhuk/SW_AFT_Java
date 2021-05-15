package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHalper().goToHome();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new DateTestContact("test1", "test2", "test1", "test1"), true);
        }
        List<DateTestContact> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModificater(before.size());
        DateTestContact dataContact = new DateTestContact("test122", "test233", "test3", "null");

        app.getContactHelper().fillContactForm(dataContact, false);
        app.getContactHelper().clickUpdate();
        app.getNavigationHalper().goToHome();
        List<DateTestContact> after = app.getContactHelper().getContactList();

        before.remove(before.size() - 1);
        before.add(dataContact);
//        Comparator<? super DateTestContact> byHC = (o1, o2) -> Integer.compare(o1.hashCode(), o2.hashCode());
        Comparator<? super DateTestContact> byHC = (o1, o2) -> o1.toString().compareTo(o2.toString());
        before.sort(byHC);
        after.sort(byHC);
        Assert.assertEquals(before, after);
    }


}
