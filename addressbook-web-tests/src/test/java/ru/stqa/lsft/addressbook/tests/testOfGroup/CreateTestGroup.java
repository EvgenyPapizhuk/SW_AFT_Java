package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.List;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    app.getNavigationHalper().goToGroup();
    List<DateTestGroup> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
    List<DateTestGroup> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size() + 1, after.size());
    app.exit1();
  }

}
