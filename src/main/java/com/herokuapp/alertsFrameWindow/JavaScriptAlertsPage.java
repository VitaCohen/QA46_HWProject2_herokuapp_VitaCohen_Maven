package com.herokuapp.alertsFrameWindow;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Click for JS Alert']")
    WebElement jsAlert;

    public JavaScriptAlertsPage clickForJSAlert() {
        click(jsAlert);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .alertIsPresent()).accept();
        return this;
    }

    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    WebElement jsConfirm;

    public JavaScriptAlertsPage clickAlertConfirm(String result) {
        click(jsConfirm);
        if (result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }

        return this;
    }

    @FindBy(id = "result")
    WebElement confirmResult;

    public JavaScriptAlertsPage verifyResult(String text) {
        Assert.assertTrue(confirmResult.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    WebElement jsPromptBtn;

    public JavaScriptAlertsPage sendMessageToAlert(String message) {
        click(jsPromptBtn);
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    public JavaScriptAlertsPage verifyMessage(String text) {
        Assert.assertTrue(confirmResult.getText().contains(text));
        return this;
    }
}
