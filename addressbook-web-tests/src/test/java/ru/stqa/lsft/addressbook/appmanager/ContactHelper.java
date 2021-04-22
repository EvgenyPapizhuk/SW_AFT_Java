package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.lsft.addressbook.model.DateTestContact;


public class ContactHelper extends HelperBase{
    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void initContact() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(DateTestContact dateContact) {
        type(By.name("firstname"), dateContact.getFirstName());
        type(By.name("middlename"), dateContact.getMiddleName());
        type(By.name("lastname"), dateContact.getLastName());
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

}
