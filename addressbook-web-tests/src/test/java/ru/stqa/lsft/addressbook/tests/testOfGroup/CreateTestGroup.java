package ru.stqa.lsft.addressbook.tests.testOfGroup;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.*;

public class CreateTestGroup extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/group.csv")));
    String line = reader.readLine();
      while (line != null) {
          String[] split = line.split(";");
          list.add(new Object[]{new DateTestGroup().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
          line = reader.readLine();
      }
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
