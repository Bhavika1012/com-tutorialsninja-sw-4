package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By returningCustomer = By.xpath("//h2[normalize-space()='Returning Customer']");
    By sendEmailId = By.xpath("//input[@id='input-email']");
    By sendPassword = By.xpath("//input[@id='input-password']");
    By clickOnLoginButton = By.xpath("//input[@value='Login']");


    //get returning customer text to verify
    public String getReturningCustomerText(){
        return getTextFromElement(returningCustomer);
    }

    //enter email ID
    public void enterEmailId(String inputEmail) {
        sendTextToElement(sendEmailId, inputEmail);
    }

    //entering password
    public void enterPassword(String inputPassword) {
        sendTextToElement(sendPassword, inputPassword);
    }

    //click on login
    public void clickOnLogin() {
        clickOnElement(clickOnLoginButton);
    }


}
