package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.lsft.addressbook.model.DateTestGroup;

public class GroupHelper extends HelperBase{

    public GroupHelper(FirefoxDriver wd) {

        super(wd);
    }

    public void initGroup() {
        click(By.name("new"));
    }


    public void fillGroupForm(DateTestGroup groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getHeader());
        type(By.name("group_footer"), groupDate.getFooter());
        click(By.name("submit"));
    }

    public void deleteOneGroup() {
        click(By.name("selected[]"));
        click(By.name("delete"));
    }
}
