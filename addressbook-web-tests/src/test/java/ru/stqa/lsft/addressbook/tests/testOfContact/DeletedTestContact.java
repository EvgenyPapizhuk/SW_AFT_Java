package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class DeletedTestContact extends TestBase {

    @Test
    public void testDeletedTestGroup() throws Exception {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new DateTestContact("test1", "test2", "test1", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initDeletedContact();
        app.wd.switchTo().alert().accept();
        app.exit1();
    }
}
