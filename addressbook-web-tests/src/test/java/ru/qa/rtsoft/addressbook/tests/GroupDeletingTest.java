package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletingTest extends TestBase{

    @Test
    public void testGroupDeleting() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }

}
