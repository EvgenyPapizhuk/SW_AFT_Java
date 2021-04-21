package ru.stqa.lsft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    app.goToGroup();
    app.initGroup();
    app.fillGroupForm(new DateTestGroup("test1", "test2", "test3"));
    app.exit1();
  }

}
