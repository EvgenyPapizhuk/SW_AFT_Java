package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class CreateTestContact extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.getContactHelper().createContact(new DateTestContact("test1", "test2", "test", "test1"), true);
        app.exit1();
    }

}
