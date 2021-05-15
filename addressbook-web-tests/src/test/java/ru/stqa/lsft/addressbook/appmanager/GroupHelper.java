package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.lsft.addressbook.model.DateTestGroup;

import java.util.ArrayList;
import java.util.List;

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

    public void modificationGroup(int index, DateTestGroup group1) {
        selectGroup(index);
        initGroupModificater();
        fillGroupForm(group1);
        clickUpdate();
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

    public List<DateTestGroup> getGroupList() {
        List<DateTestGroup> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement we : elements) {
            String name = we.getText();
            int id = Integer.parseInt(we.findElement(By.tagName("input")).getAttribute("value"));
            DateTestGroup date = new DateTestGroup(id, name, null, null);
            groups.add(date);
        }
        return groups;
    }


}
