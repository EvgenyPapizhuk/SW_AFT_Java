package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    app.getNavigationHalper().goToGroup();
    app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
    app.exit1();
  }

}
