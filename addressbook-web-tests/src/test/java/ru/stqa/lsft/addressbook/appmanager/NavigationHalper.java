package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHalper extends HelperBase{

    public NavigationHalper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                &&  isElementPresent(By.name("new"))  ) {
        return;
        }
        click(By.linkText("groups"));
    }

    public void goToHome() {
        if (isElementPresent(By.id("maintable"))  ) {
            return;
        }
        click(By.linkText("home"));
    }
}
