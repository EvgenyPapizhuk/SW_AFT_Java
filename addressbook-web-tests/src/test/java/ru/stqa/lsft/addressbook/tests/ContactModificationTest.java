package ru.stqa.lsft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification(){
        app.getContactHelper().initContactModificater();
        app.getContactHelper().fillContactForm(new DateTestContact("test1", "test2", "test3"));
        app.getContactHelper().clickUpdate();
        app.getNavigationHalper().goToHome();
        app.exit1();
    }


}
