package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class MyAccountPage extends Utility {
    //click on my account link
    By myAccount = By.xpath("//span[normalize-space()='My Account']");
    public void selectMyAccountOptions(String option) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(myAccount);
        clickOnElement(By.xpath("(//a[normalize-space()='" + option + "'])[1]"));
    }
}
