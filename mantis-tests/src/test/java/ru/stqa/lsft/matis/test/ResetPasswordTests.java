package ru.stqa.lsft.matis.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.lsft.matis.model.MailMessage;
import ru.stqa.lsft.matis.model.UserMantisModel;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String newPassword = "password1" + now;
//        String email = String.format("user1%s@lmail.ld", now);

        app.reset().start(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        UserMantisModel operationUser = app.reset().resetPasswordNotAdmin();
        String email = operationUser.getEmail();
        String user = operationUser.getUsername();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 20000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.reset().finish(confirmationLink, newPassword);
        assertTrue(app.newSession().login(user, newPassword));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
