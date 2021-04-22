package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){
        app.getContactHelper().initContactModificater();
        app.getContactHelper().fillContactForm(new DateTestContact("test1", "test2", "test3"));
        app.getContactHelper().clickUpdate();
        app.getNavigationHalper().goToHome();
        app.exit1();
    }


}
