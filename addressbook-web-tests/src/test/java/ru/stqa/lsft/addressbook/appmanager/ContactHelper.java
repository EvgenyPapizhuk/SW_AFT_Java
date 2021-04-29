package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.lsft.addressbook.model.DateTestContact;


public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContact() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(DateTestContact dateContact, boolean create) {
        type(By.name("firstname"), dateContact.getFirstName());
        type(By.name("middlename"), dateContact.getMiddleName());
        type(By.name("lastname"), dateContact.getLastName());
        if (create) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(dateContact.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactModificater() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initDeletedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void returnToContacts() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void createContact(DateTestContact dateTestContact, boolean create) {
        initContact();
        fillContactForm(dateTestContact, create);
        clickInSubmit();
        returnToContacts();
    }

}
