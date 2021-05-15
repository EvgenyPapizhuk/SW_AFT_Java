package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new DateTestGroup().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){
        Set<DateTestGroup> before = app.group().all();
        DateTestGroup modifiedGroup = before.iterator().next();

        DateTestGroup group1 = new DateTestGroup().withtId(modifiedGroup.getId()).withName("test2").withHeader("test22").withFooter("test3");
        app.group().modify(group1);
        Set<DateTestGroup> after = app.group().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifiedGroup);
        before.add(group1);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after) );
        Assert.assertEquals(before, after);
    }


}
