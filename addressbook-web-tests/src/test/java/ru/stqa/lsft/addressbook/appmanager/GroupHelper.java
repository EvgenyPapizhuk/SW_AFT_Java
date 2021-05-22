package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        wd.findElements(By.name("selected[]")).get(i).click();
    }

    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
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


    public void create(DateTestGroup groupDate) {
        initGroup();
        fillGroupForm(groupDate);
        clickInSubmit();
        groupCache = null;
        returnToGroup();
    }

    public void modify(DateTestGroup group1) {
        selectGroupById(group1.getId());
        initGroupModificater();
        fillGroupForm(group1);
        clickUpdate();
        groupCache = null;
        goToGroup();
    }

    public void goToGroup() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                &&  isElementPresent(By.name("new"))  ) {
            return;
        }
        click(By.linkText("groups"));
    }



    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<DateTestGroup> list() {
        List<DateTestGroup> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement we : elements) {
            String name = we.getText();
            int id = Integer.parseInt(we.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new DateTestGroup().withtId(id).withName(name));
        }
        return groups;
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement we : elements) {
            String name = we.getText();
            int id = Integer.parseInt(we.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new DateTestGroup().withtId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void delete(int index) {
        selectGroup(index);
        initDeletedGroup();
        goToGroup();
    }

    public void delete(DateTestGroup group) {
        selectGroupById(group.getId());
        initDeletedGroup();
        groupCache = null;
        goToGroup();

    }



}
