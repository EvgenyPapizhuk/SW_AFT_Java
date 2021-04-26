package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHalper extends HelperBase{

    public NavigationHalper(WebDriver wd) {
        super(wd);
    }

    public void goToGroup() {
        click(By.linkText("groups"));
    }

    public void goToHome() { click(By.linkText("home")); }
}
