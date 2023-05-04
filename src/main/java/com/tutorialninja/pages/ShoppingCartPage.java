package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    //verify shopping cart text
    By shoppingCartText =By.xpath("//h1[contains(text(),'Shopping Cart')]");
    //verify product name
    By verifyProductName =By.xpath("(//a[contains(text(),'HP LP3065')])[2]");
    //verify macbook text
    By verifyMacBookText =By.xpath("(//a[contains(text(),'MacBook')])[2]");
    //verify model text
    By verifyModelText =By.xpath("//td[normalize-space()='Product 21']");
    //verify delivery date
    By verifyDeliveryDateText =By.xpath("(//small)[2]");
    //Enter quantity
    By changeQuantity =By.xpath("//input[contains(@name,'quantity')]");
    //update quantity
    By updateButton =By.xpath("//i[@class='fa fa-refresh']");
    //verify success text
    By verifySuccessText =By.xpath("//div[@class='alert alert-success alert-dismissible']");
    //verify product price
    By verifyProductPrice =By.xpath("(//td[@class='text-right'][normalize-space()='$122.00'])[4]");
    By macBookPriceText =By.xpath("(//td[@class='text-right'][normalize-space()='$1,204.00'])[3]");
    By checkOut =By.xpath("//a[@class='btn btn-primary']");

 //getting shopping cart text
    public String getShoppingCartText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(shoppingCartText);
    }

    //getting product text
    public String verifyProductName() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyProductName);
    }

    //getting mac book text
    public String verifyMacBookText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyMacBookText);
    }


    //Get model text
    public String verifyModelText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyModelText);
    }
//verify delivery date text
    public String verifyDeliveryDateText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyDeliveryDateText);
    }

    //verify price text
    public String verifyProductPrice() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyProductPrice);
    }

 //change quantity
 public void changeQuantity(String value) throws InterruptedException {
     Thread.sleep(2000);
     sendTextToElement(changeQuantity,value);
     clickOnElement(updateButton);
 }

 //verify success message
    public String getSuccessText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifySuccessText);
    }

  //get macbook price
    public String macBookPriceText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(macBookPriceText);
    }

    //Click on checkout button
    public void clickOnCheckOutButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(checkOut);
    }

}
