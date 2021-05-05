package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.lsft.addressbook.model.DateTestGroup;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initGroup() {
        click(By.name("new"));
    }


    public void fillGroupForm(DateTestGroup groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getHeader());
        type(By.name("group_footer"), groupDate.getFooter());
    }


    public void selectGroup(int i) {
        wd.findElements(By.name("selected[]")).get(i-1).click();
    }

    public void initGroupModificater() {
        click(By.name("edit"));
    }

    public void initDeletedGroup() {
        click(By.name("delete"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.className("group"));
    }


    public void returnToGroup() {
        click(By.linkText("groups"));
    }


    public void createGroup(DateTestGroup groupDate) {
        initGroup();
        fillGroupForm(groupDate);
        clickInSubmit();
        returnToGroup();
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
