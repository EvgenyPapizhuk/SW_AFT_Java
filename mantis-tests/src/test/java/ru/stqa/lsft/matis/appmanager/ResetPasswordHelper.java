package ru.stqa.lsft.matis.appmanager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResetPasswordHelper extends HelperBase{

    private CloseableHttpClient httpClient;

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
        httpClient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    public void start(String username, String password) {
        wd.get(app.getProperty("web.BaseUrl") + "/manage_user_page.php");
        type(By.name("username"), username);
        click(By.xpath("//input[@value=\"Вход\"]"));
        type(By.name("password"), password);
        click(By.xpath("//input[@value=\"Вход\"]"));
    }

    public void finish(String confirmationLink, String password1) {
        wd.get(confirmationLink);
        type(By.name("password"), password1);
        type(By.name("password_confirm"), password1);
        click(By.xpath("//button[@type=\"submit\"]"));
    }

    public void loginAdmin() throws IOException {
        wd.get(app.getProperty("web.BaseUrl") + "/manage_user_page.php");
        HttpPost post = new HttpPost(app.getProperty("web.BaseUrl") + "/login.php");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("return", "index.php"));
        params.add(new BasicNameValuePair("username", app.getProperty("web.adminLogin")));
        params.add(new BasicNameValuePair("password", app.getProperty("web.adminPassword")));
        params.add(new BasicNameValuePair("secure_session", "on"));
        post.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = httpClient.execute(post);
        String body = geTextFrom(response);
//        return body.contains(String.format("<span class=\"user-info\">%s</span>", username));
    }
    private String geTextFrom(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }
}
