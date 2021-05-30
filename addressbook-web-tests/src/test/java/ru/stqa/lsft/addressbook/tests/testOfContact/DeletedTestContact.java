package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.Contacts;
import ru.stqa.lsft.addressbook.model.ContactDate;
import ru.stqa.lsft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletedTestContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().goToHome();
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactDate()
                    .withtFirstName("test1").withtMiddleName("test2").withttLastName("test1").withtGroup("test1"), true);
        }
    }

    @Test
    public void testDeletedTestGroup() throws Exception {
        Contacts before = app.db().contacts();
        System.out.println("начальное количество запоисано");
        ContactDate deletedContact = before.iterator().next();
        app.contact().selectContact(deletedContact);
        app.contact().initDeletedContact();
        app.wd.switchTo().alert().accept();
        app.goTo().goToHome();
        Thread.sleep(2000);
        Contacts after = app.db().contacts();
        System.out.println("Проверка количества прошла");
        assertThat(after, equalTo(before.withhout(deletedContact)));
    }
}
