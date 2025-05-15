package com.herokuapp.tests;

import com.herokuapp.pages.SidePanel;
import org.testng.annotations.BeforeMethod;

public class JavaScriptAlertsTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new SidePanel(driver).selectJavaScriptAlerts();
    }
}
