package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.List;

public class DeletedTestGroup extends TestBase {

  @Test
  public void testDeletedTestGroup() throws Exception {
    app.getNavigationHalper().goToGroup();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
    }
    List<DateTestGroup> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size());
    app.getGroupHelper().initDeletedGroup();
    app.getNavigationHalper().goToGroup();
    List<DateTestGroup> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size() - 1, after.size());

    before.remove(before.size()-1);
      Assert.assertEquals(before, after);


    app.exit1();
  }


}
