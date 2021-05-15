package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHalper().goToGroup();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
        }
    }

    @Test
    public void testGroupModification(){
        List<DateTestGroup> before = app.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        DateTestGroup group1 = new DateTestGroup(before.get(index).getId(), "test44", "test22", "test3");
        app.getGroupHelper().modificationGroup(index, group1);
        List<DateTestGroup> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(group1);

        Comparator<? super DateTestGroup> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after) );
        Assert.assertEquals(before, after);
    }


}
