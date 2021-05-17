package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.*;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    DateTestGroup group1 = new DateTestGroup().withName("test2");
    app.group().create(group1);
    Groups after = app.group().all();
    assertThat(before.size() + 1, equalTo(after.size()));

    assertThat(after, equalTo(
            before.withAdded(group1.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
