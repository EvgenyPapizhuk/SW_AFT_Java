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
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new DateTestGroup().withName("test1"));
    }
  }


  @Test
  public void testDeletedTestGroup() throws Exception {
    List<DateTestGroup> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<DateTestGroup> after = app.group().list();
    Assert.assertEquals(before.size() - 1, after.size());

    before.remove(index);
    Assert.assertEquals(before, after);
  }



}
