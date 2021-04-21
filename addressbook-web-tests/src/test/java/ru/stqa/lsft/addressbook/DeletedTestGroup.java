package ru.stqa.lsft.addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeletedTestGroup extends TestBase{

  @Test
  public void testDeletedTestGroup() throws Exception {
    goToGroup();
    deleteOneGroup();
    goToGroup();
    exit1();
  }


}
