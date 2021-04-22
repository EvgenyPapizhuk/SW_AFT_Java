package ru.stqa.lsft.addressbook.tests;

import org.testng.annotations.Test;

public class DeletedTestContact extends TestBase{

    @Test
    public void testDeletedTestGroup() throws Exception {
        app.getContactHelper().selectContact();
        app.getContactHelper().initDeleted();
        app.wd.switchTo().alert().accept();
        app.exit1();
    }
}
