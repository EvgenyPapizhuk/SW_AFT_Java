package ru.stqa.lsft.addressbook;

import org.testng.annotations.Test;

public class CreateTestGroup extends TestBase {


  @Test
  public void testUntitledCase() throws Exception {
    goToGroup();
    initGroup();
    fillGroupForm(new DateTestGroup("test1", "test2", "test3"));
    exit1();
  }

}
