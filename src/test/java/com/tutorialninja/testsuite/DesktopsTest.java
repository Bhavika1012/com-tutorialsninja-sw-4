package com.tutorialninja.testsuite;

import com.tutorialninja.pages.DesktopsPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.ShoppingCartPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        String menuName = "Show AllDesktops";
        homePage.mouseHoverAndClickOnDesktop();
        homePage.selectMenu(menuName);
        String excepted = desktopsPage.beforeSortDesktopByPositionZtoA().toString();
        String actual = desktopsPage.afterSortDesktopByPositionZtoA().toString();
        Assert.assertTrue(excepted.contains(actual));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        String menuName = "Show AllDesktops";
        homePage.mouseHoverAndClickOnDesktop();
        homePage.selectMenu(menuName);
        desktopsPage.selectSortByPositionFromDropdownValue("Name (A - Z)");
        desktopsPage.selectProductFromList("HP LP3065");

        String expectedMessage = "HP LP3065";
        String actualMessage = desktopsPage.getTextOfProduct();
        Assert.assertEquals(expectedMessage,actualMessage);
        desktopsPage.selectDate("30", "November", "2022");
        desktopsPage.clickOnAddToCart();

        expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n";
        actualMessage = desktopsPage.verifySuccessfulText();
        String[] actualmsg = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg[0]);

        desktopsPage.clickOnShoppingCartLink();

        expectedMessage = "Shopping Cart  (1.00kg)";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(expectedMessage,actualMessage);

        expectedMessage = "HP LP3065";
        actualMessage = shoppingCartPage.verifyProductName();
        Assert.assertEquals(expectedMessage,actualMessage);

        expectedMessage = "2022-11-30";
        actualMessage = shoppingCartPage.verifyDeliveryDateText();
        String[] actualmsg1 = actualMessage.split(":");
        Assert.assertEquals(expectedMessage, actualmsg1[1]);

        expectedMessage = "Product 21";
        actualMessage = shoppingCartPage.verifyModelText();
        Assert.assertEquals(expectedMessage,actualMessage);

        expectedMessage = "$122.00";
        actualMessage = shoppingCartPage.verifyProductPrice();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
}
