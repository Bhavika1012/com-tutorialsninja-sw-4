package com.tutorialninja.testsuite;

import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LoginPage;
import com.tutorialninja.pages.MyAccountPage;
import com.tutorialninja.pages.RegisterPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    String email;
    LoginPage loginPage = new LoginPage();


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        String option = "Register";
        myAccountPage.selectMyAccountOptions(option);
        String expectedMessage = "Register Account";
        String actualMessage = registerPage.getRegisterAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        String option = "Login";
        myAccountPage.selectMyAccountOptions(option);
        String expectedMessage = "Returning Customer";
        String actualMessage = loginPage.getReturningCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String option = "Register";
      myAccountPage.selectMyAccountOptions(option);
        registerPage.sendFirstName("john");
        registerPage.sendLastName("smith");
        registerPage.sendEmail(email);
        registerPage.sendTelephone("07854785478");
        registerPage.sendPassword("Prime@123");
        registerPage.sendConfirmPassword("Prime@123");
        registerPage.clickOnSubscribeToNewsletter("Yes");
        registerPage.clickOnPrivacyPolicy();
        registerPage.clickOnContinueButton();

        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = registerPage.verifyAccountCreationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        myAccountPage.selectMyAccountOptions(option);

        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        String option = "Login";
        myAccountPage.selectMyAccountOptions(option);
        loginPage.enterEmailId("admin123456@gmail.com");
        loginPage.enterPassword("Admin@123");
        loginPage.clickOnLogin();
        String expectedMessage = "My Account";
        String actualMessage = homePage.getMyAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        myAccountPage.selectMyAccountOptions(option);

        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
