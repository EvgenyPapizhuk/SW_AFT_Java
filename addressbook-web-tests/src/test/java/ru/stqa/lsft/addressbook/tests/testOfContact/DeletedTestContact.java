package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class DeletedTestContact extends TestBase {

    @Test
    public void testDeletedTestGroup() throws Exception {
        app.getContactHelper().selectContact();
        app.getContactHelper().initDeletedContact();
        app.wd.switchTo().alert().accept();
        app.exit1();
    }
}
