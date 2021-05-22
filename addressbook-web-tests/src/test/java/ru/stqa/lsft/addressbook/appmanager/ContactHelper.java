package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.lsft.addressbook.model.Contacts;
import ru.stqa.lsft.addressbook.model.DateTestContact;
import ru.stqa.lsft.addressbook.model.DateTestGroup;

import java.util.ArrayList;
import java.util.List;


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

    public void modify(int num) {
//        click(By.xpath("//img[@alt='Edit']"));
        click(By.xpath("(//img[@alt='Edit'])[" + num + "]"));
    }

    public void modify(DateTestContact modifiedContact) {
        click(By.xpath("//td[.=\"" + modifiedContact.getLastName() + "\"]/..//img[@alt='Edit']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void selectContact(DateTestContact deletedContact) {
        click(By.xpath("//td[.=\"" + deletedContact.getLastName() + "\"]/..//input[@name='selected[]']"));
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

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        int numElement = 2;
        for (WebElement we : elements) {
            int id = Integer.parseInt(
                    we.findElement(By.xpath("//table[@id='maintable']/tbody/tr["+numElement+"]/td[1]/input")).getAttribute("id"));
            String lastName = we.findElement(By.xpath("//table[@id='maintable']/tbody/tr["+numElement+"]/td[2]")).getText();
            String firstName = we.findElement(By.xpath("//table[@id='maintable']/tbody/tr["+numElement+"]/td[3]")).getText();
            DateTestContact date = new DateTestContact(firstName, null, lastName, null);
            contacts.add(new DateTestContact().withtFirstName(firstName).withttLastName(lastName).withtId(id));
            numElement++;
        }
        return contacts;

    }
}
