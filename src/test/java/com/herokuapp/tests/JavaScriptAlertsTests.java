package com.herokuapp.tests;

import com.herokuapp.alertsFrameWindow.JavaScriptAlertsPage;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver);
        new SidePanel(driver).selectJavaScriptAlerts();
    }

    @Test
    public void clickAlertTest() {
        new JavaScriptAlertsPage(driver).clickForJSAlert().isAlertPresent("You successfully clicked an alert");
    }

    @Test
    public void alertWithConfirmTest() {
        new JavaScriptAlertsPage(driver).clickAlertConfirm("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertPromptTest(){
        new JavaScriptAlertsPage(driver).sendMessageToAlert("QA46")
                .verifyMessage("QA46");
    }


}
