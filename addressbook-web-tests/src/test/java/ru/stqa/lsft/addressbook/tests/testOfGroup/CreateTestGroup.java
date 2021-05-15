package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    app.goTo().groupPage();
//    List<DateTestGroup> before = app.group().list();
    Set<DateTestGroup> before = app.group().all();
    DateTestGroup group1 = new DateTestGroup().withName("test2");
    app.group().create(group1);
    Set<DateTestGroup> after = app.group().all();
    Assert.assertEquals(before.size() + 1, after.size());
    group1.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group1);
//    Comparator<? super DateTestGroup> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
//    before.sort(byId);
//    after.sort(byId);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);
  }

}
