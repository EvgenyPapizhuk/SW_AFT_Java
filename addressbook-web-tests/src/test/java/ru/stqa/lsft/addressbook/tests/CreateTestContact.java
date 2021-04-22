package ru.stqa.lsft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;

public class CreateTestContact extends TestBase{


    @Test
    public void testCreateContact() throws Exception {
        app.getContactHelper().initContact();
        app.getContactHelper().fillContactForm(new DateTestContact("test1", "test2", "test3"));
        Thread.sleep(2000);
        app.getContactHelper().clickInSubmit();
        Thread.sleep(1000);

        app.exit1();
    }

}
