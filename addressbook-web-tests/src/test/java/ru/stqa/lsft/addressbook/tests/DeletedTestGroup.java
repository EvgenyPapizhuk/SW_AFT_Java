package ru.stqa.lsft.addressbook.tests;

import org.testng.annotations.Test;

public class DeletedTestGroup extends TestBase{

  @Test
  public void testDeletedTestGroup() throws Exception {
    app.goToGroup();
    app.deleteOneGroup();
    app.goToGroup();
    app.exit1();
  }


}
