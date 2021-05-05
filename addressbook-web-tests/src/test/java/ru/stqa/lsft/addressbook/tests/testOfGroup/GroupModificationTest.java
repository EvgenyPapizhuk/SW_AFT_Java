package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHalper().goToGroup();
        int before = app.getGroupHelper().getGroupCount();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModificater();
        app.getGroupHelper().fillGroupForm(new DateTestGroup("test44", "test22", "test3"));
        app.getGroupHelper().clickUpdate();
        app.getNavigationHalper().goToGroup();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after);
        app.exit1();
    }

}
