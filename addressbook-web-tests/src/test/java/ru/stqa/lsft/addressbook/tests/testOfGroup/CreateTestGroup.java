package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    app.getNavigationHalper().goToGroup();
    List<DateTestGroup> before = app.getGroupHelper().getGroupList();
    DateTestGroup group1 = new DateTestGroup("test1", null, null);
    app.getGroupHelper().createGroup(group1);
    List<DateTestGroup> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size() + 1, after.size());

    int max = 0;
    for (DateTestGroup g : after) {
      if (max < g.getId()) {
        max = g.getId();
      }
    }

    group1.setId(max);

    before.add(group1);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    app.exit1();
  }

}
