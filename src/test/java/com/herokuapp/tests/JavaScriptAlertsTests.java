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
        new JavaScriptAlertsPage(driver).clickForJSAlert();
    }

    @Test
    public void alertWithConfirmTest() {
        new JavaScriptAlertsPage(driver).clickAlertConfirm("Cancel").verifyResult("Cancel");
    }

}
