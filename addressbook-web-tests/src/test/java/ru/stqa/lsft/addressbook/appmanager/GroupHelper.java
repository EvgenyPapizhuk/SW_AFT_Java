package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
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
        type(By.name("firstname"), groupDate.getFirstName());
        type(By.name("middlename"), groupDate.getMiddlename());
        type(By.name("lastname"), groupDate.getLastName());
    }

    public void clickInSubmit() {
        click(By.name("submit"));
    }


    public void deleteOneGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModificater() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
