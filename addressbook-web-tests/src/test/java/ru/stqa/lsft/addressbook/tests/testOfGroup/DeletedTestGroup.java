package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Groups before = app.group().all();
    DateTestGroup deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertEquals(before.size() - 1, after.size());
    assertThat(after, equalTo(before.withhout(deletedGroup)));

  }



}
