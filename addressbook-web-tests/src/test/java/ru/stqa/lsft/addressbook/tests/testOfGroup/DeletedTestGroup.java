package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class DeletedTestGroup extends TestBase {

  @Test
  public void testDeletedTestGroup() throws Exception {
    app.getNavigationHalper().goToGroup();
    int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
    }
    app.getGroupHelper().selectGroup(1);
    app.getGroupHelper().initDeletedGroup();
    app.getNavigationHalper().goToGroup();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before - 1, after);
    app.exit1();
  }


}
