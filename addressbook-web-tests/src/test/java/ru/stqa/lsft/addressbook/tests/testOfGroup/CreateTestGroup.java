package ru.stqa.lsft.addressbook.tests.testOfGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.*;

public class CreateTestGroup extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
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

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<DateTestGroup> groups = gson.fromJson(json, new TypeToken<List<DateTestGroup>>() {}.getType());
        return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }


  @Test (dataProvider = "validGroupsFromJson")
  public void testUntitledCase(DateTestGroup group1) throws Exception {
//      DateTestGroup group1 = new DateTestGroup().withName(name).withHeader(header).withFooter(footer);
      app.goTo().groupPage();
      Groups before = app.db().groups();
      app.group().create(group1);
      assertThat(before.size()+1, equalTo(app.group().count()));
      Groups after = app.db().groups();
      assertThat(before.size() + 1, equalTo(after.size()));

      assertThat(after, equalTo(
              before.withAdded(group1.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testBadUntitledCase() throws Exception {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    DateTestGroup group1 = new DateTestGroup().withName("test2'");
    app.group().create(group1);
    assertThat(before.size(), equalTo(app.group().count()));
    Groups after = app.db().groups();

    assertThat(after, equalTo(before));
  }


}
