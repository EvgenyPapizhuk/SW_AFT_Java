package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.List;

public class DeletedTestGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHalper().goToGroup();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new DateTestGroup("test1", null, null));
    }
  }


  @Test
  public void testDeletedTestGroup() throws Exception {
    List<DateTestGroup> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().initDeletedGroup();
    app.getNavigationHalper().goToGroup();
    List<DateTestGroup> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size() - 1, after.size());

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }


}
