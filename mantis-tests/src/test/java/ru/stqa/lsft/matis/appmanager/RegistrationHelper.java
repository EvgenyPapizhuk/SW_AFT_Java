package ru.stqa.lsft.matis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.BaseUrl") + "/signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.xpath("//input[@value=\"Зарегистрироваться\"]"));
    }

    public void finish(String confirmationLink, String password1) {
        wd.get(confirmationLink);
        type(By.name("password"), password1);
        type(By.name("password_confirm"), password1);
        click(By.xpath("//button[@type=\"submit\"]"));
    }
}
