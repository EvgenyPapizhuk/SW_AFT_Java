package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHalper().goToGroup();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
        }
        List<DateTestGroup> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(1);
        app.getGroupHelper().initGroupModificater();
        app.getGroupHelper().fillGroupForm(new DateTestGroup("test44", "test22", "test3"));
        app.getGroupHelper().clickUpdate();
        app.getNavigationHalper().goToGroup();
        List<DateTestGroup> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());
        app.exit1();
    }

}
