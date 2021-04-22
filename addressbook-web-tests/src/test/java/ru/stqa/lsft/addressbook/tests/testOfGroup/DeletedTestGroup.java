package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class DeletedTestGroup extends TestBase {

  @Test
  public void testDeletedTestGroup() throws Exception {
    app.getNavigationHalper().goToGroup();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initDeletedGroup();
    app.getNavigationHalper().goToGroup();
    app.exit1();
  }


}
