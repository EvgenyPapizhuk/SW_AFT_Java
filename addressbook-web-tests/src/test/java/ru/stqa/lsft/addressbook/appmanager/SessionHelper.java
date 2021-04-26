package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void loginMethod(String userlog, String userpass) {
        type(By.name("user") , userlog);
        type(By.name("pass") , userpass);
        wd.findElement(By.id("LoginForm")).submit();
        click(By.id("content"));
    }
}
