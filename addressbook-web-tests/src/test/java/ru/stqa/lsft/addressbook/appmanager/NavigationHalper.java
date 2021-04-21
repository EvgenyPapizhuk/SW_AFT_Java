package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHalper {
    public FirefoxDriver wd;

    public void goToGroup() {
        wd.findElement(By.linkText("groups")).click();
    }
}
