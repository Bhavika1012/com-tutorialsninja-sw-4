package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {
    By registerAccount = By.xpath("//h1[normalize-space()='Register Account']");
    By verifyAccountCreationMessage = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By email = By.name("email");
    By telephone = By.name("telephone");
    By password = By.name("password");
    By confirmPassword = By.name("confirm");
    By newsletter = By.name("newsletter");
    By privacyPolicy = By.name("agree");
    By continueButton = By.xpath("//input[@type='submit']");

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccount);
    }


    //enter first name
    public void sendFirstName(String inputFirstName) {
        sendTextToElement(firstName, inputFirstName);
    }

    //enter last name
    public void sendLastName(String inputLastName) {
        sendTextToElement(lastName, inputLastName);
    }

    //enter email address
    public void sendEmail(String text) {
        sendTextToElement(By.id("input-email"), "DPPatel123" + "@gmail.com");
    }

    //enter telephone number
    public void sendTelephone(String inputTelephone) {
        sendTextToElement(telephone, inputTelephone);
    }

    //enter password
    public void sendPassword(String inputPassword) {
        sendTextToElement(password, inputPassword);
    }

    //enter confirmation password
    public void sendConfirmPassword(String inputConfirmPassword) {
        sendTextToElement(confirmPassword, inputConfirmPassword);
    }

    //select subscribe button
    public void clickOnSubscribeToNewsletter(String yes) {
        clickOnElement(newsletter);
    }

    //click on agree button
    public void clickOnPrivacyPolicy() {
        clickOnElement(privacyPolicy);
    }

    //Clicking on continue button
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    By verifyAccountCreationText = By.xpath("//div[@id='content']/h1");
    By continueAfterAccountCreation = By.xpath("//a[text()='Continue']");


    public String verifyAccountCreationMessage(){
        return getTextFromElement(verifyAccountCreationText);
    }

    public void clickOnContinueAfterAccountCreation() {

        clickOnElement(continueAfterAccountCreation);
    }
}
