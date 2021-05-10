package ru.stqa.lsft.addressbook.tests.testOfContact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.List;

public class DeletedTestContact extends TestBase {

    @Test
    public void testDeletedTestGroup() throws Exception {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new DateTestContact("test1", "test2", "test1", "test1"), true);
        }

        List<DateTestContact> before = app.getContactHelper().getContactList();
        System.out.println("начальное количество запоисано");

        app.getContactHelper().selectContact();
        app.getContactHelper().initDeletedContact();
        app.wd.switchTo().alert().accept();
        app.getNavigationHalper().goToHome();
        Thread.sleep(2000);
        List<DateTestContact> after = app.getContactHelper().getContactList();



        before.remove(0);
        Assert.assertEquals(before.size(), after.size());
        System.out.println("Проверка количества прошла");
        Assert.assertEquals(before, after);


        app.exit1();
    }
}
