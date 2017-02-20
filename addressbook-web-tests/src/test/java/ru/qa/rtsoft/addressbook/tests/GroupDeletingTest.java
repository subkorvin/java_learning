package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletingTest extends TestBase{

    @Test
    public void testGroupDeleting() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
