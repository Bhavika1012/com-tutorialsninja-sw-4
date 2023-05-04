package com.tutorialninja.testsuite;

import com.tutorialninja.pages.CheckoutPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopsAndNoteBookPage;
import com.tutorialninja.pages.ShoppingCartPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage = new HomePage();
    LaptopsAndNoteBookPage showAllLaptopsAndNotebooksPage = new LaptopsAndNoteBookPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    CheckoutPage checkOutPage = new CheckoutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

        String menuName = "Show AllLaptops & Notebooks";
        homePage.mouseHoverAndClickOnLaptopAndNoteBooks();
        homePage.selectMenu(menuName);
        //Select Sort By "Price (High > Low)"
        String exceptedMessage = showAllLaptopsAndNotebooksPage.beforeSortPriceHighToLow().toString();
        String actualMessage = showAllLaptopsAndNotebooksPage.afterSortPriceHighToLow().toString();
        Assert.assertEquals(exceptedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Select Sort By "Price (High > Low)"
        showAllLaptopsAndNotebooksPage.sortByFilter("Price (High > Low)");
        //Select Product “MacBook”
        showAllLaptopsAndNotebooksPage.selectProduct("MacBook");
        //Verify the text “MacBook”
        String expectedMessage = "MacBook";
        String actualMessage = showAllLaptopsAndNotebooksPage.verifyMacBookText();
        Assert.assertEquals(expectedMessage, actualMessage);
// Click on ‘Add To Cart’ button
        showAllLaptopsAndNotebooksPage.clickOnAddToCart();
        // Verify the message “Success: You have added MacBook to your shopping cart!”
        expectedMessage = "Success: You have added MacBook to your shopping cart!\n";
        actualMessage = showAllLaptopsAndNotebooksPage.getSuccessText();
        String[] actualmsg = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg[0]);
//Click on link “shopping cart” display into success message
        showAllLaptopsAndNotebooksPage.clickOnShoppingCartLink();
//Verify the text "Shopping Cart"
        expectedMessage = "Shopping Cart  (0.00kg)";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(expectedMessage, actualMessage);
// Verify the Product name "MacBook"
        expectedMessage = "MacBook";
        actualMessage = shoppingCartPage.verifyMacBookText();
        Assert.assertEquals(expectedMessage, actualMessage);
//Change Quantity "2"
        shoppingCartPage.changeQuantity("2");
// Verify the message “Success: You have modified your shopping cart!”
        expectedMessage = "Success: You have modified your shopping cart!\n";
        actualMessage = shoppingCartPage.getSuccessText();
        String[] actualmsg1 = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg1[0]);

        expectedMessage = "$1,204.00";
        actualMessage = shoppingCartPage.verifyProductPrice();
        Assert.assertEquals(expectedMessage, actualMessage);

        shoppingCartPage.clickOnCheckOutButton();

        expectedMessage = "Checkout";
        actualMessage = checkOutPage.verifyCheckOutText();
        Assert.assertEquals(expectedMessage, actualMessage);

        expectedMessage = "New Customer";
        actualMessage = checkOutPage.verifyNewCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);

        checkOutPage.clickOnGuestCheckOut();
        checkOutPage.clickOnContinueButton();
        checkOutPage.enterFirstName("John");
        checkOutPage.enterLastName("Smith");
        checkOutPage.enterEmail("johnsmith@gmail.com");
        checkOutPage.enterPhoneNumber("07854785698");
        checkOutPage.enterAddress1("Handy Lane");
        checkOutPage.enterCity("London");
        checkOutPage.enterPostCode("NW26AZ");
        checkOutPage.selectCountry("United Kingdom");
        checkOutPage.selectRegion("Middlesex");
        checkOutPage.clickOnGuestContinue();
        checkOutPage.enterComments("Macbook Purchase");
        checkOutPage.clickOnAgree();

        expectedMessage = "Warning: No Payment options are available. Please contact us for assistance!";
        actualMessage = checkOutPage.getPaymentWarningText();
        Assert.assertEquals(expectedMessage, actualMessage);


    }

}
