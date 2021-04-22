package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHalper {
    private FirefoxDriver wd;

    public NavigationHalper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void goToGroup() {
        wd.findElement(By.linkText("groups")).click();
    }
}
