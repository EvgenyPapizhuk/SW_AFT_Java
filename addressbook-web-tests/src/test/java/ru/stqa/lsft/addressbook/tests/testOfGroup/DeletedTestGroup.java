package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.hamcrest.junit.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletedTestGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new DateTestGroup().withName("test1"));
    }
  }


  @Test
  public void testDeletedTestGroup() throws Exception {
    Groups before = app.db().groups();
    DateTestGroup deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    MatcherAssert.assertThat(before.size()-1, equalTo(app.group().count()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.withhout(deletedGroup)));
  }

}
