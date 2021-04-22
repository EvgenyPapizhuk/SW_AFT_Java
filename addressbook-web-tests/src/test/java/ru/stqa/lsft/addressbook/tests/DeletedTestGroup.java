package ru.stqa.lsft.addressbook.tests;

import org.testng.annotations.Test;

public class DeletedTestGroup extends TestBase{

  @Test
  public void testDeletedTestGroup() throws Exception {
    app.getNavigationHalper().goToGroup();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initDeletedGroup();
    app.getNavigationHalper().goToGroup();
    app.exit1();
  }


}
