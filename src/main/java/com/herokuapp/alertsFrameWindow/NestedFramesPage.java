package com.herokuapp.alertsFrameWindow;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "frame")
    List<WebElement> frame;

    public NestedFramesPage returnListOfFrames() {
        // by method size()
        System.out.println("The total number of frames are " + frame.size());

        //by executing java script
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total number of frames are " + numberOfFrames + " JSExecute");
        return this;
    }

    public NestedFramesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    //@FindBy(xpath = "//frame[@name='frame-left']")
    // WebElement left;

    @FindBy(id = "content")
    WebElement middle;

    public NestedFramesPage switchToMiddleFrame() {
        driver.switchTo().frame("frame-middle");
        return this;
    }

    public NestedFramesPage verifyFrameByText(String text) {
        Assert.assertTrue(shouldHaveAText(middle, text, 5));
        return this;
    }


    public NestedFramesPage switchToTopFrame() {
        driver.switchTo().frame("frame-top");
        return this;
    }

    @FindBy(xpath = "//frame[@name='frame-bottom']")
    WebElement frameBottom;

    public NestedFramesPage switchToFrameByName() {
        driver.switchTo().frame(frameBottom);
        return this;
    }

    public NestedFramesPage verifyFrameByTitle(String text) {
        Assert.assertTrue(frameBottom.getText().contains(text));
        return this;
    }
}
