package ru.stqa.lsft.matis.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.lsft.matis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
//        session.login("administrator", "root");

        assertTrue(session.login("administrator", "root"));
        assertTrue(session.isLoggedInAs("administrator"));
    }


}
