package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();

        if (app.db().groups().size() == 0) {
            app.group().create(new DateTestGroup().withName("test1"));
        }

//        app.goTo().groupPage();
//        if (app.group().all().size() == 0) {
//            app.group().create(new DateTestGroup().withName("test1"));
//        }
    }

    @Test
    public void testGroupModification(){
//        Groups before = app.group().all();
        Groups before = app.db().groups();
        DateTestGroup modifiedGroup = before.iterator().next();

        DateTestGroup group1 = new DateTestGroup().withtId(modifiedGroup.getId()).withName("test2").withHeader("test22").withFooter("test3");
        app.group().modify(group1);
        MatcherAssert.assertThat(before.size(), equalTo(app.group().count()));
//        Groups after = app.group().all();
        Groups after = app.db().groups();
        before.remove(modifiedGroup);
        before.add(group1);
        assertThat(after, equalTo(before.withhout(modifiedGroup).withAdded(group1)));

        verifyGroupListInUI();
    }


}
