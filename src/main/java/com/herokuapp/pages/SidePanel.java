package com.herokuapp.pages;

import com.herokuapp.alertsFrameWindow.JavaScriptAlertsPage;
import com.herokuapp.alertsFrameWindow.NestedFramesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='JavaScript Alerts']")
    WebElement javaScriptAlerts;

    public JavaScriptAlertsPage selectJavaScriptAlerts() {
        click(javaScriptAlerts);
        return new JavaScriptAlertsPage(driver);
    }

    @FindBy(xpath = "//a[.='Nested Frames']")
    WebElement nestedFrames;

    public NestedFramesPage selectNestedFrames() {
        click(nestedFrames);
        return new NestedFramesPage(driver);
    }
}
