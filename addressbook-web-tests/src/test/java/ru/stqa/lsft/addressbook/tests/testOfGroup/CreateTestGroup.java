package ru.stqa.lsft.addressbook.tests.testOfGroup;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.*;

public class CreateTestGroup extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
      while (line != null) {
          xml += line;
          line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(DateTestGroup.class);
      List<DateTestGroup> groups = (List<DateTestGroup>) xStream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
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
