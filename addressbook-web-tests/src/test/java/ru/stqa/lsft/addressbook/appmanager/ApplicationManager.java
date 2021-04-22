package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private  SessionHelper sessionHelper;
    private  NavigationHalper navigationHalper;
    private  GroupHelper groupHelper;
    public FirefoxDriver wd;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHalper = new NavigationHalper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.loginMethod("admin", "secret");
    }



    public void exit1() {
      wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        wd.quit();
    }

    public boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHalper getNavigationHalper() {
        return navigationHalper;
    }
}
