package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class DeletedTestGroup extends TestBase {

  @Test
  public void testDeletedTestGroup() throws Exception {
    app.getNavigationHalper().goToGroup();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initDeletedGroup();
    app.getNavigationHalper().goToGroup();
    app.exit1();
  }


}
