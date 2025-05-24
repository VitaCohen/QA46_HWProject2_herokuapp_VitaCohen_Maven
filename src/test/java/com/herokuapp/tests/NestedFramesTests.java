package com.herokuapp.tests;

import com.herokuapp.alertsFrameWindow.NestedFramesPage;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver);
        new SidePanel(driver).selectNestedFrames();
    }


    @Test
    public void frameTestMiddle() {
        new NestedFramesPage(driver).returnListOfFrames()
                .switchToFrameByIndex(0)
                //.switchToTopFrame()
                .switchToMiddleFrame()
                .verifyFrameByText("MIDDLE");

    }

    @Test
    public void frameTest2(){
        new NestedFramesPage(driver).switchToFrameByName()
                .verifyFrameByTitle("BOTTOM");

    }


}
