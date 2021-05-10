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
    app.getNavigationHalper().goToGroup();

    List<DateTestGroup> before = app.getGroupHelper().getGroupList();

    DateTestGroup group1 = new DateTestGroup("test2", null, null);
    app.getGroupHelper().createGroup(group1);

    List<DateTestGroup> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(before.size() + 1, after.size());

//    int max = 0;
//    for (DateTestGroup g : after) {
//      if (max < g.getId()) {
//        max = g.getId();
//      }
//    }

//    group1.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    before.add(group1);

    Comparator<? super DateTestGroup> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);


    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);

    app.exit1();
  }

}
