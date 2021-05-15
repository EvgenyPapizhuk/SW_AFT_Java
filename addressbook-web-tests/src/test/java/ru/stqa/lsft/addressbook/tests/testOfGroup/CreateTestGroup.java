package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    app.goTo().groupPage();
    List<DateTestGroup> before = app.group().list();
    DateTestGroup group1 = new DateTestGroup().withName("test2");
    app.group().create(group1);
    List<DateTestGroup> after = app.group().list();
    Assert.assertEquals(before.size() + 1, after.size());
    before.add(group1);
    Comparator<? super DateTestGroup> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);


    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);
  }

}
