package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    app.getNavigationHalper().goToGroup();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before + 1, after);
    app.exit1();
  }

}
