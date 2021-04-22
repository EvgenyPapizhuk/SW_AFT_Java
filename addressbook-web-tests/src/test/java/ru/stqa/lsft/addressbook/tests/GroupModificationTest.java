package ru.stqa.lsft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.lsft.addressbook.model.DateTestGroup;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification(){
        app.getNavigationHalper().goToGroup();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModificater();
        app.getGroupHelper().fillGroupForm(new DateTestGroup("test44", "test22", "test3"));
        app.getGroupHelper().clickUpdate();
        app.getNavigationHalper().goToGroup();
        app.exit1();
    }

}
