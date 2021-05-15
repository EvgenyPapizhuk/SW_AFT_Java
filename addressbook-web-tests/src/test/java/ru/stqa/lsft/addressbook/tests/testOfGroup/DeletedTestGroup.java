package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.List;
import java.util.Set;

public class DeletedTestGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new DateTestGroup().withName("test1"));
    }
  }


  @Test
  public void testDeletedTestGroup() throws Exception {
    Set<DateTestGroup> before = app.group().all();
    DateTestGroup deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<DateTestGroup> after = app.group().all();
    Assert.assertEquals(before.size() - 1, after.size());

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }



}
