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
        type(By.name("group_name"), dateContact.getName());
        type(By.name("group_header"), dateContact.getHeader());
        type(By.name("group_footer"), dateContact.getFooter());
    }
}
