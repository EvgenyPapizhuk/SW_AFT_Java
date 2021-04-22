package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class CreateTestContact extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.getContactHelper().initContact();
        app.getContactHelper().fillContactForm(new DateTestContact("test1", "test2", "test"));
        Thread.sleep(2000);
        app.getContactHelper().clickInSubmit();
        Thread.sleep(1000);

        app.exit1();
    }

}
