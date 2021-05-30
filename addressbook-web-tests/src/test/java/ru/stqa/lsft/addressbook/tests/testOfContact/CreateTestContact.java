package ru.stqa.lsft.addressbook.tests.testOfContact;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.Contacts;
import ru.stqa.lsft.addressbook.model.ContactDate;
import ru.stqa.lsft.addressbook.model.DateTestGroup;
import ru.stqa.lsft.addressbook.model.Groups;
import ru.stqa.lsft.addressbook.tests.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class CreateTestContact extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactDate.class);
        List<ContactDate> contacts = (List<ContactDate>) xStream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactDate> contacts = gson.fromJson(json, new TypeToken<List<ContactDate>>() {}.getType());
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }


    @Test (dataProvider = "validContactsFromXml")
    public void testCreateContact(ContactDate dataContact) throws Exception {
        Groups groups = app.db().groups();
        app.goTo().goToHome();
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/shrimp.jpg");
//        ContactDate dataContact = new ContactDate()
//                .withtFirstName("test1").withtMiddleName("test2").withttLastName("test").withPhoto(photo);
        app.contact().createContact(dataContact.withPhoto(photo), true);

        Contacts after = app.db().contacts();

        Comparator<? super ContactDate> byHC = (o1, o2) -> Integer.compare(o1.hashCode(), o2.hashCode());
        System.out.println("before: " + before.size());
        System.out.println("after: " + after.size());
        assertThat(after,equalTo(before.withAdded(dataContact.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        verifyContactListInUI();
    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/shrimp.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
        verifyContactListInUI();
    }

}
