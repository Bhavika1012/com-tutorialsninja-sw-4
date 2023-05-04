package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {
    //Verify the text “Checkout”
    By verifyCheckOutText = By.xpath("//h1[normalize-space()='Checkout']");
    //Verify the Text “New Customer”
    By verifyNewCustomerText = By.xpath("//h2[normalize-space()='New Customer']");
    //Click on “Guest Checkout” radio button
    By clickOnGuestCheckOut = By.xpath("//input[@value='guest']");
    //Click on “Continue” tab
    By continueButton = By.xpath("//input[@id='button-account']");
    //xPaths for Mandatory details
    By firstName = By.xpath("//input[@id='input-payment-firstname']");
    By lastName = By.xpath("//input[@id='input-payment-lastname']");
    By email = By.xpath("//input[@id='input-payment-email']");
    By telephone = By.xpath("//input[@id='input-payment-telephone']");
    By address1 = By.xpath("//input[@id='input-payment-address-1']");
    By city = By.xpath("//input[@id='input-payment-city']");
    By postcode = By.xpath("//input[@id='input-payment-postcode']");
    By country = By.xpath("//select[@id='input-payment-country']");
    By region = By.xpath("//select[@id='input-payment-zone']");
    By addComments = By.xpath("//textarea[@name='comment']");
    By agree = By.xpath("//input[@name='agree']");
    By warningText = By.xpath("//div[@class='alert alert-warning alert-dismissible']");
    By guestContinueButton = By.xpath("//input[@id='button-guest']");

    //Getting checkout text to verify
    public String verifyCheckOutText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyCheckOutText);
    }

   //verify new customer text
    public String verifyNewCustomerText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyNewCustomerText);
    }

   //click on guest checkout radio button
    public void clickOnGuestCheckOut() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(clickOnGuestCheckOut);
    }

    //click on checkout button
    public void clickOnContinueButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(continueButton);
    }

    //enter first name
    public void enterFirstName(String inputFirstName) {
        sendTextToElement(firstName, inputFirstName);
    }

   //enter last name
    public void enterLastName(String inputLastName) {
        sendTextToElement(lastName, inputLastName);
    }

   //enter email
    public void enterEmail(String inputEmail) {
        sendTextToElement(email, inputEmail);
    }

   //enter phone number
    public void enterPhoneNumber(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(telephone, value);
    }

   //enter address
    public void enterAddress1(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(address1, value);
    }

 //enter city
    public void enterCity(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(city, value);
    }

   //enter postcode
    public void enterPostCode(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(postcode, value);
    }

   //select country
    public void selectCountry(String value) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(country, value);
    }

    //select region from dropdown
    public void selectRegion(String value) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(region, value);
    }

    //click on guest
    public void clickOnGuestContinue() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(guestContinueButton);
    }

   //enter comments
    public void enterComments(String text) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(addComments, text);
    }

  //click on check box to agree t&c's
    public void clickOnAgree() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(agree);
    }

    //verifying payment warning message
    public String getPaymentWarningText() throws InterruptedException {
        Thread.sleep(1000);
        return  getTextFromElement(warningText);
    }
}
