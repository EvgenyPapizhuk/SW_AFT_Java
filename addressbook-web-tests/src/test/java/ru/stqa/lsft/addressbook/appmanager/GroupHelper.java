package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.lsft.addressbook.model.DateTestGroup;

public class GroupHelper {
    private WebDriver wd;

    public GroupHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void initGroup() {
      wd.findElement(By.name("new")).click();
    }



    public void fillGroupForm(DateTestGroup groupDate) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupDate.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupDate.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupDate.getFooter());
      wd.findElement(By.name("submit")).click();
    }

    public void deleteOneGroup() {
      wd.findElement(By.name("selected[]")).click();
      wd.findElement(By.name("delete")).click();
    }
}
