package ru.stqa.lsft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.lsft.addressbook.model.Contacts;
import ru.stqa.lsft.addressbook.model.ContactDate;

import java.util.List;


public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContact() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactDate dateContact, boolean create) {
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
        click(By.xpath("(//img[@alt='Edit'])[" + num + "]"));
    }

    public void modify(ContactDate modifiedContact) {
        click(By.xpath("//a[@href='edit.php?id=" + modifiedContact.getId() + "']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void selectContact(ContactDate deletedContact) {
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

    public void createContact(ContactDate contactDate, boolean create) {
        initContact();
        fillContactForm(contactDate, create);
        clickInSubmit();
        returnToContacts();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        int numElement = 2;
        for (WebElement we : elements) {
            List<WebElement> cells = we.findElements(By.tagName("td"));
            int id = Integer.parseInt(we.findElement(By
                    .xpath("//table[@id='maintable']/tbody/tr["+numElement+"]/td[1]/input")).getAttribute("id"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String testPhones = cells.get(5).getText();
            String[] phones = cells.get(5).getText().split("\n");
            System.out.println(phones.length);
            if (phones.length == 3){
                contacts.add(new ContactDate()
                        .withtFirstName(firstName).withttLastName(lastName).withtId(id)
                        .withtHomePhone(phones[0]).withtMobilePhone(phones[1]).withtWorkPhone(phones[2]));
            }else {
                contacts.add(new ContactDate()
                        .withtFirstName(firstName).withttLastName(lastName).withtId(id));
            }
            numElement++;
        }
        return contacts;

    }

    public ContactDate infoFromEditForm(ContactDate contact) {
        modify(contact);
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactDate().withtId(contact.getId()).withtFirstName(firstName).withttLastName(lastName)
                .withtHomePhone(home).withtMobilePhone(mobile).withtWorkPhone(work);
    }
}
