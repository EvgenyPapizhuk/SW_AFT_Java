package ru.stqa.lsft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      loginMethod("admin", "secret");
    }

    protected void loginMethod(String userlog, String userpass) {
      wd.get("http://localhost/addressbook/");
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(userlog);
      wd.findElement(By.id("LoginForm")).click();
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(userpass);
      wd.findElement(By.id("LoginForm")).submit();
      wd.findElement(By.id("content")).click();
    }

    protected void exit1() {
      wd.findElement(By.linkText("Logout")).click();
    }

    protected void initGroup() {
      wd.findElement(By.name("new")).click();
    }

    protected void goToGroup() {
      wd.findElement(By.linkText("groups")).click();
    }

    protected void fillGroupForm(DateTestGroup groupDate) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupDate.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupDate.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupDate.getFooter());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
      wd.quit();
    }

    protected boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    protected boolean isAlertPresent() {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    protected void deleteOneGroup() {
      wd.findElement(By.name("selected[]")).click();
      wd.findElement(By.name("delete")).click();
    }
}
