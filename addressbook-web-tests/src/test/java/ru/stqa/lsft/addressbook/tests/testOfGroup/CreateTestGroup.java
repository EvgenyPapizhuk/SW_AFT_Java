package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.*;

public class CreateTestGroup extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new DateTestGroup().withName("test 1").withHeader("header 1").withFooter("footer 1")});
    list.add(new Object[] {new DateTestGroup().withName("test 2").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[] {new DateTestGroup().withName("test 3").withHeader("header 3").withFooter("footer 3")});
    return list.iterator();
  }


  @Test (dataProvider = "validGroups")
  public void testUntitledCase(DateTestGroup group1) throws Exception {
//      DateTestGroup group1 = new DateTestGroup().withName(name).withHeader(header).withFooter(footer);
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group1);
      assertThat(before.size()+1, equalTo(app.group().count()));
      Groups after = app.group().all();
      assertThat(before.size() + 1, equalTo(after.size()));

      assertThat(after, equalTo(
              before.withAdded(group1.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadUntitledCase() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    DateTestGroup group1 = new DateTestGroup().withName("test2'");
    app.group().create(group1);
    assertThat(before.size(), equalTo(app.group().count()));
    Groups after = app.group().all();

    assertThat(after, equalTo(before));
  }


}
